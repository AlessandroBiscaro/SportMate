package sportmateinc.sportmatepresentationlayer.application.views.accountutente;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import sportmateinc.sportmatepresentationlayer.application.data.SamplePerson;
import sportmateinc.sportmatepresentationlayer.application.services.SamplePersonService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("AccountUtente")
@Route("accountU")
@Menu(order = 9, icon = LineAwesomeIconUrl.USER)
@AnonymousAllowed
@Uses(Icon.class)
public class AccountUtenteView extends Composite<VerticalLayout> {

    public AccountUtenteView() {
        H1 h1 = new H1();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H5 h5 = new H5();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        DatePicker datePicker = new DatePicker();
        ComboBox comboBox = new ComboBox();
        Button buttonPrimary2 = new Button();
        H5 h52 = new H5();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        TextField textField5 = new TextField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Button buttonPrimary3 = new Button();
        Button buttonPrimary4 = new Button();
        H5 h53 = new H5();
        VerticalLayout layoutColumn7 = new VerticalLayout();
        Grid basicGrid = new Grid(SamplePerson.class);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("SportMate");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h5.setText("Dati personali:");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, h5);
        h5.setWidth("max-content");
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutColumn3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("100%");
        layoutColumn3.setHeight("min-content");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn3.setAlignItems(Alignment.START);
        textField.setLabel("Nome:");
        textField.setWidth("192px");
        textField2.setLabel("Mail:");
        textField2.setWidth("192px");
        buttonPrimary.setText("Modifica");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("100%");
        layoutColumn4.setHeight("min-content");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        textField3.setLabel("Cognome:");
        textField3.setWidth("192px");
        textField4.setLabel("Cellulare:");
        textField4.setWidth("192px");
        layoutColumn5.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setWidth("100%");
        layoutColumn5.setHeight("min-content");
        layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn5.setAlignItems(Alignment.END);
        datePicker.setLabel("Data di nascita:");
        datePicker.setWidth("min-content");
        comboBox.setLabel("Livello:");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        buttonPrimary2.setText("Salva");
        layoutColumn5.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary2);
        buttonPrimary2.setWidth("107px");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        h52.setText("Credito:");
        h52.setWidth("max-content");
        layoutColumn6.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("100%");
        layoutColumn6.getStyle().set("flex-grow", "1");
        textField5.setLabel("Importo:");
        textField5.setWidth("192px");
        layoutRow2.setWidthFull();
        layoutColumn6.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow3.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        buttonPrimary3.setText("Ricarica");
        buttonPrimary3.setWidth("107px");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary4.setText("Dati pagamento");
        buttonPrimary4.setWidth("min-content");
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        h53.setText("Partite prenotate:");
        h53.setWidth("max-content");
        layoutColumn7.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.setWidth("100%");
        layoutColumn7.getStyle().set("flex-grow", "1");
        basicGrid.setWidth("100%");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid);
        getContent().add(h1);
        getContent().add(layoutColumn2);
        layoutColumn2.add(h5);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(textField);
        layoutColumn3.add(textField2);
        layoutColumn3.add(buttonPrimary);
        layoutRow.add(layoutColumn4);
        layoutColumn4.add(textField3);
        layoutColumn4.add(textField4);
        layoutRow.add(layoutColumn5);
        layoutColumn5.add(datePicker);
        layoutColumn5.add(comboBox);
        layoutColumn5.add(buttonPrimary2);
        layoutColumn2.add(h52);
        layoutColumn2.add(layoutColumn6);
        layoutColumn6.add(textField5);
        layoutColumn6.add(layoutRow2);
        layoutRow2.add(layoutRow3);
        layoutRow3.add(buttonPrimary3);
        layoutRow2.add(buttonPrimary4);
        layoutColumn2.add(h53);
        layoutColumn2.add(layoutColumn7);
        layoutColumn7.add(basicGrid);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;
}
