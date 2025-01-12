package sportmateinc.sportmatepresentationlayer.application.views.gestore;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;

import sportmateinc.sportmatepresentationlayer.application.data.TypeDisp;
import sportmateinc.sportmatepresentationlayer.application.services.TypeDispService;

import java.time.Duration;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Gestione disponibilità")
@Route("gestDisp/:typeDispID?/:action?(edit)")
@Menu(order = 8, icon = LineAwesomeIconUrl.ADDRESS_BOOK_SOLID)
@AnonymousAllowed
@Uses(Icon.class)
@Uses(Icon.class)
public class GestionedisponibilitàView extends Div implements BeforeEnterObserver {

    private final String TYPEDISP_ID = "typeDispID";
    private final String TYPEDISP_EDIT_ROUTE_TEMPLATE = "gestDisp/%s/edit";

    private final Grid<TypeDisp> grid = new Grid<>(TypeDisp.class, false);

    private Checkbox prenotato;
    private DateTimePicker dataOra;
    private TextField tipologiaCampo;
    private TextField prezzo;
    private Checkbox spogliatoi;
    private TextField note;

    private final Button cancel = new Button("Cancel");
    private final Button save = new Button("Save");

    private final BeanValidationBinder<TypeDisp> binder;

    private TypeDisp typeDisp;

    private final TypeDispService typeDispService;

    public GestionedisponibilitàView(TypeDispService typeDispService) {
        this.typeDispService = typeDispService;
        addClassNames("gestionedisponibilità-view");

        // Create UI
        SplitLayout splitLayout = new SplitLayout();

        createGridLayout(splitLayout);
        createEditorLayout(splitLayout);

        add(splitLayout);

        // Configure Grid
        LitRenderer<TypeDisp> prenotatoRenderer = LitRenderer.<TypeDisp>of(
                "<vaadin-icon icon='vaadin:${item.icon}' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: ${item.color};'></vaadin-icon>")
                .withProperty("icon", prenotato -> prenotato.isPrenotato() ? "check" : "minus").withProperty("color",
                        prenotato -> prenotato.isPrenotato()
                                ? "var(--lumo-primary-text-color)"
                                : "var(--lumo-disabled-text-color)");

        grid.addColumn(prenotatoRenderer).setHeader("Prenotato").setAutoWidth(true);

        grid.addColumn("dataOra").setAutoWidth(true);
        grid.addColumn("tipologiaCampo").setAutoWidth(true);
        grid.addColumn("prezzo").setAutoWidth(true);
        LitRenderer<TypeDisp> spogliatoiRenderer = LitRenderer.<TypeDisp>of(
                "<vaadin-icon icon='vaadin:${item.icon}' style='width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: ${item.color};'></vaadin-icon>")
                .withProperty("icon", spogliatoi -> spogliatoi.isSpogliatoi() ? "check" : "minus").withProperty("color",
                        spogliatoi -> spogliatoi.isSpogliatoi()
                                ? "var(--lumo-primary-text-color)"
                                : "var(--lumo-disabled-text-color)");

        grid.addColumn(spogliatoiRenderer).setHeader("Spogliatoi").setAutoWidth(true);

        grid.addColumn("note").setAutoWidth(true);
        grid.setItems(query -> typeDispService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        // when a row is selected or deselected, populate form
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                UI.getCurrent().navigate(String.format(TYPEDISP_EDIT_ROUTE_TEMPLATE, event.getValue().getId()));
            } else {
                clearForm();
                UI.getCurrent().navigate(GestionedisponibilitàView.class);
            }
        });

        // Configure Form
        binder = new BeanValidationBinder<>(TypeDisp.class);

        // Bind fields. This is where you'd define e.g. validation rules
        binder.forField(prezzo).withConverter(new StringToIntegerConverter("Only numbers are allowed")).bind("prezzo");

        binder.bindInstanceFields(this);

        cancel.addClickListener(e -> {
            clearForm();
            refreshGrid();
        });

        save.addClickListener(e -> {
            try {
                if (this.typeDisp == null) {
                    this.typeDisp = new TypeDisp();
                }
                binder.writeBean(this.typeDisp);
                typeDispService.update(this.typeDisp);
                clearForm();
                refreshGrid();
                Notification.show("Data updated");
                UI.getCurrent().navigate(GestionedisponibilitàView.class);
            } catch (ObjectOptimisticLockingFailureException exception) {
                Notification n = Notification.show(
                        "Error updating the data. Somebody else has updated the record while you were making changes.");
                n.setPosition(Position.MIDDLE);
                n.addThemeVariants(NotificationVariant.LUMO_ERROR);
            } catch (ValidationException validationException) {
                Notification.show("Failed to update the data. Check again that all values are valid");
            }
        });
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        Optional<Long> typeDispId = event.getRouteParameters().get(TYPEDISP_ID).map(Long::parseLong);
        if (typeDispId.isPresent()) {
            Optional<TypeDisp> typeDispFromBackend = typeDispService.get(typeDispId.get());
            if (typeDispFromBackend.isPresent()) {
                populateForm(typeDispFromBackend.get());
            } else {
                Notification.show(String.format("The requested typeDisp was not found, ID = %s", typeDispId.get()),
                        3000, Notification.Position.BOTTOM_START);
                // when a row is selected but the data is no longer available,
                // refresh grid
                refreshGrid();
                event.forwardTo(GestionedisponibilitàView.class);
            }
        }
    }

    private void createEditorLayout(SplitLayout splitLayout) {
        Div editorLayoutDiv = new Div();
        editorLayoutDiv.setClassName("editor-layout");

        Div editorDiv = new Div();
        editorDiv.setClassName("editor");
        editorLayoutDiv.add(editorDiv);

        FormLayout formLayout = new FormLayout();
        prenotato = new Checkbox("Prenotato");
        dataOra = new DateTimePicker("Data Ora");
        dataOra.setStep(Duration.ofSeconds(1));
        tipologiaCampo = new TextField("Tipologia Campo");
        prezzo = new TextField("Prezzo");
        spogliatoi = new Checkbox("Spogliatoi");
        note = new TextField("Note");
        formLayout.add(prenotato, dataOra, tipologiaCampo, prezzo, spogliatoi, note);

        editorDiv.add(formLayout);
        createButtonLayout(editorLayoutDiv);

        splitLayout.addToSecondary(editorLayoutDiv);
    }

    private void createButtonLayout(Div editorLayoutDiv) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.setClassName("button-layout");
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save, cancel);
        editorLayoutDiv.add(buttonLayout);
    }

    private void createGridLayout(SplitLayout splitLayout) {
        Div wrapper = new Div();
        wrapper.setClassName("grid-wrapper");
        splitLayout.addToPrimary(wrapper);
        wrapper.add(grid);
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

    private void clearForm() {
        populateForm(null);
    }

    private void populateForm(TypeDisp value) {
        this.typeDisp = value;
        binder.readBean(this.typeDisp);

    }
}
