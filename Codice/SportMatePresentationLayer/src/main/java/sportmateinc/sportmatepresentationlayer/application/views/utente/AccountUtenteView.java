package sportmateinc.sportmatepresentationlayer.application.views.utente;

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

	H1 titoloAccountUtente = new H1();
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

	public AccountUtenteView() {

		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, titoloAccountUtente);

		setTitoloAccountUtente();
		setH5();
		setLayoutColumn2();
		setLayoutRow();
		setLayoutRow2();
		setLayoutColumn3();
		setLayoutRow3();
		setLayoutColumn4();
		setLayoutColumn5();
		setLayoutColumn6();
		setLayoutColumn7();
		setButtonPrimary();
		setButtonPrimary2();
		setButtonPrimary3();
		setButtonPrimary4();
		setTextField();
		setTextField2();
		setTextField3();
		setTextField4();
		setTextField5();
		setDatePicker();
		setH52();
		setH53();
		setComboBox();
		setBasicGrid();
	}

	private void setTitoloAccountUtente() {
		titoloAccountUtente.setText("SportMate");
		titoloAccountUtente.setWidth("max-content");
		getContent().add(titoloAccountUtente);
	}
	
	private void setH5() {
		h5.setText("Dati personali:");
		h5.setWidth("max-content");
	}

	private void setLayoutColumn2() {
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.addClassName(Gap.XSMALL);
		layoutColumn2.addClassName(Padding.XSMALL);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set("flex-grow", "1");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, h5);
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutColumn2.setFlexGrow(1.0, layoutColumn6);
		getContent().add(layoutColumn2);
		layoutColumn2.add(h5);
		layoutColumn2.add(layoutRow);
		layoutColumn2.add(h52);
		layoutColumn2.add(layoutColumn6);
		layoutColumn2.add(h53);
		layoutColumn2.add(layoutColumn7);
		layoutColumn2.setFlexGrow(1.0, layoutColumn7);
	}

	private void setLayoutRow() {
		layoutRow.setWidthFull();
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.setHeight("min-content");
		layoutRow.setFlexGrow(1.0, layoutColumn3);
		layoutRow.setFlexGrow(1.0, layoutColumn4);
		layoutRow.setFlexGrow(1.0, layoutColumn5);
		layoutRow.add(layoutColumn4);
		layoutRow.add(layoutColumn3);
		layoutRow.add(layoutColumn5);
		layoutRow2.setWidthFull();
		layoutRow2.add(layoutRow3);
		layoutRow2.add(buttonPrimary4);
	}

	private void setLayoutRow2() {
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set("flex-grow", "1");
		layoutRow2.setFlexGrow(1.0, layoutRow3);
	}
	
	private void setLayoutColumn3() {
		layoutColumn3.setWidth("100%");
		layoutColumn3.setHeight("min-content");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn3.setAlignItems(Alignment.START);
		layoutColumn3.setHeightFull();
		layoutColumn3.add(textField);
		layoutColumn3.add(textField2);
		layoutColumn3.add(buttonPrimary);
	}
	
	private void setLayoutRow3() {
		layoutRow3.setHeightFull();
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set("flex-grow", "1");
		layoutRow3.add(buttonPrimary3);
	}
	
	private void setLayoutColumn4() {
		layoutColumn4.setHeightFull();
		layoutColumn4.setWidth("100%");
		layoutColumn4.setHeight("min-content");
		layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn4.setAlignItems(Alignment.CENTER);
		layoutColumn4.add(textField3);
		layoutColumn4.add(textField4);
	}
	
	private void setLayoutColumn5() {
		layoutColumn5.setWidth("100%");
		layoutColumn5.setHeight("min-content");
		layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn5.setAlignItems(Alignment.END);
		layoutColumn5.setHeightFull();
		layoutColumn5.add(datePicker);
		layoutColumn5.add(comboBox);
		layoutColumn5.add(buttonPrimary2);
		layoutColumn5.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary2);
	}
	
	private void setLayoutColumn6() {
		layoutColumn6.setWidthFull();

		layoutColumn6.setWidth("100%");
		layoutColumn6.getStyle().set("flex-grow", "1");
		layoutColumn6.setFlexGrow(1.0, layoutRow2);
		layoutColumn6.add(textField5);
		layoutColumn6.add(layoutRow2);
	}
	
	private void setLayoutColumn7() {
		layoutColumn7.setWidthFull();
		layoutColumn7.setWidth("100%");
		layoutColumn7.getStyle().set("flex-grow", "1");
		layoutColumn7.add(basicGrid);
	}
	
	private void setButtonPrimary() {
		buttonPrimary.setText("Modifica");
		buttonPrimary.setWidth("min-content");
		buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setButtonPrimary2() {
		buttonPrimary2.setText("Salva");
		buttonPrimary2.setWidth("107px");
		buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setButtonPrimary3() {
		buttonPrimary3.setText("Ricarica");
		buttonPrimary3.setWidth("107px");
		buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setButtonPrimary4() {
		buttonPrimary4.setText("Dati pagamento");
		buttonPrimary4.setWidth("min-content");
		buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setTextField() {
		textField.setLabel("Nome:");
		textField.setWidth("192px");
	}
	
	private void setTextField2() {
		textField2.setLabel("Mail:");
		textField2.setWidth("192px");
	}
	
	private void setTextField3() {
		textField3.setLabel("Cognome:");
		textField3.setWidth("192px");
	}
	
	private void setTextField4() {
		textField4.setLabel("Cellulare:");
		textField4.setWidth("192px");
	}
	
	private void setTextField5() {
		textField5.setLabel("Importo:");
		textField5.setWidth("192px");
	}
	
	private void setDatePicker() {
		datePicker.setLabel("Data di nascita:");
		datePicker.setWidth("min-content");
	}
	
	private void setComboBox() {
		comboBox.setLabel("Livello:");
		comboBox.setWidth("min-content");
		setComboBoxSampleData(comboBox);
	}
	
	private void setH52() {
		h52.setText("Credito:");
		h52.setWidth("max-content");
	}
	
	private void setH53() {
		h53.setText("Partite prenotate:");
		h53.setWidth("max-content");
	}
	
	private void setBasicGrid() {
		basicGrid.setWidth("100%");
		basicGrid.getStyle().set("flex-grow", "0");
		setGridSampleData(basicGrid);
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
