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
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import SportMateInc.SportMateBusinessLayer.entity.Livello;
import SportMateInc.SportMateBusinessLayer.services.LivelliService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatepresentationlayer.application.data.Role;
import sportmateinc.sportmatepresentationlayer.application.data.SamplePerson;
import sportmateinc.sportmatepresentationlayer.application.services.SamplePersonService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("My Profile")
@Route("myprofile")
@Menu(order = 9, icon = LineAwesomeIconUrl.USER)
@PermitAll
//@RolesAllowed({"USER"})
@Uses(Icon.class)
public class AccountUtenteView extends Composite<VerticalLayout> {

	H1 titoloAccountUtente = new H1();
	VerticalLayout layoutColumn2 = new VerticalLayout();
	H5 titoloDatiPersonali = new H5();
	HorizontalLayout layoutRow = new HorizontalLayout();
	VerticalLayout layoutColumn3 = new VerticalLayout();
	TextField txtNome = new TextField();
	TextField txtMail = new TextField();
	Button btnModfica = new Button();
	VerticalLayout layoutColumn4 = new VerticalLayout();
	TextField textField3 = new TextField();
	TextField txtCellulare = new TextField();
	VerticalLayout layoutColumn5 = new VerticalLayout();
	DatePicker datePicker = new DatePicker();
	ComboBox<Livello> cmbLivello = new ComboBox<>();
	Button btnSalva = new Button();
	H5 titoloCredito = new H5();
	VerticalLayout layoutColumn6 = new VerticalLayout();
	TextField txtImporto = new TextField();
	HorizontalLayout layoutRow2 = new HorizontalLayout();
	HorizontalLayout layoutRow3 = new HorizontalLayout();
	Button btnRicaricaCredito = new Button();
	Button btnDatiPagamento = new Button();
	H5 titoloPartitePrenotate = new H5();
	VerticalLayout layoutColumn7 = new VerticalLayout();
	Grid gridPartitePrenotate = new Grid(SamplePerson.class);

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
		setTxtNome();
		setTxtMail();
		setTxtCognome();
		setTxtCellulare();
		setTxtImporto();
		setDtpDataNascita();
		setTitoloCredito();
		setTitoloPartitePrenotate();
		setCmbLivello();
		setGridPartitePrenotate();
	}

	private void setTitoloAccountUtente() {
		titoloAccountUtente.setText("SportMate");
		titoloAccountUtente.setWidth("max-content");
		getContent().add(titoloAccountUtente);
	}
	
	private void setH5() {
		titoloDatiPersonali.setText("Dati personali:");
		titoloDatiPersonali.setWidth("max-content");
	}

	private void setLayoutColumn2() {
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.addClassName(Gap.XSMALL);
		layoutColumn2.addClassName(Padding.XSMALL);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set("flex-grow", "1");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, titoloDatiPersonali);
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutColumn2.setFlexGrow(1.0, layoutColumn6);
		getContent().add(layoutColumn2);
		layoutColumn2.add(titoloDatiPersonali);
		layoutColumn2.add(layoutRow);
		layoutColumn2.add(titoloCredito);
		layoutColumn2.add(layoutColumn6);
		layoutColumn2.add(titoloPartitePrenotate);
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
		layoutRow2.add(btnDatiPagamento);
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
		layoutColumn3.add(txtNome);
		layoutColumn3.add(txtMail);
		layoutColumn3.add(btnModfica);
	}
	
	private void setLayoutRow3() {
		layoutRow3.setHeightFull();
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set("flex-grow", "1");
		layoutRow3.add(btnRicaricaCredito);
	}
	
	private void setLayoutColumn4() {
		layoutColumn4.setHeightFull();
		layoutColumn4.setWidth("100%");
		layoutColumn4.setHeight("min-content");
		layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn4.setAlignItems(Alignment.CENTER);
		layoutColumn4.add(textField3);
		layoutColumn4.add(txtCellulare);
	}
	
	private void setLayoutColumn5() {
		layoutColumn5.setWidth("100%");
		layoutColumn5.setHeight("min-content");
		layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn5.setAlignItems(Alignment.END);
		layoutColumn5.setHeightFull();
		layoutColumn5.add(datePicker);
		layoutColumn5.add(cmbLivello);
		layoutColumn5.add(btnSalva);
		layoutColumn5.setAlignSelf(FlexComponent.Alignment.END, btnSalva);
	}
	
	private void setLayoutColumn6() {
		layoutColumn6.setWidthFull();

		layoutColumn6.setWidth("100%");
		layoutColumn6.getStyle().set("flex-grow", "1");
		layoutColumn6.setFlexGrow(1.0, layoutRow2);
		layoutColumn6.add(txtImporto);
		layoutColumn6.add(layoutRow2);
	}
	
	private void setLayoutColumn7() {
		layoutColumn7.setWidthFull();
		layoutColumn7.setWidth("100%");
		layoutColumn7.getStyle().set("flex-grow", "1");
		layoutColumn7.add(gridPartitePrenotate);
	}
	
	private void setButtonPrimary() {
		btnModfica.setText("Modifica");
		btnModfica.setWidth("min-content");
		btnModfica.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setButtonPrimary2() {
		btnSalva.setText("Salva");
		btnSalva.setWidth("107px");
		btnSalva.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setButtonPrimary3() {
		btnRicaricaCredito.setText("Ricarica");
		btnRicaricaCredito.setWidth("107px");
		btnRicaricaCredito.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setButtonPrimary4() {
		btnDatiPagamento.setText("Dati pagamento");
		btnDatiPagamento.setWidth("min-content");
		btnDatiPagamento.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setTxtNome() {
		txtNome.setLabel("Nome");
		txtNome.setWidth("192px");
	}
	
	private void setTxtMail() {
		txtMail.setLabel("Mail");
		txtMail.setWidth("192px");
	}
	
	private void setTxtCognome() {
		textField3.setLabel("Cognome");
		textField3.setWidth("192px");
	}
	
	private void setTxtCellulare() {
		txtCellulare.setLabel("Cellulare");
		txtCellulare.setWidth("192px");
	}
	
	private void setTxtImporto() {
		txtImporto.setLabel("Importo");
		txtImporto.setWidth("192px");
	}
	
	private void setDtpDataNascita() {
		datePicker.setLabel("Data di nascita");
		datePicker.setWidth("min-content");
	}
	
	private void setCmbLivello() {
		cmbLivello.setLabel("Livello");
		cmbLivello.setWidth("min-content");
		setCmbLivelloData(cmbLivello);
	}
	
	private void setTitoloCredito() {
		titoloCredito.setText("Credito SportMate");
		titoloCredito.setWidth("max-content");
	}
	
	private void setTitoloPartitePrenotate() {
		titoloPartitePrenotate.setText("Partite prenotate");
		titoloPartitePrenotate.setWidth("max-content");
	}
	
	private void setGridPartitePrenotate() {
		gridPartitePrenotate.setWidth("100%");
		gridPartitePrenotate.getStyle().set("flex-grow", "0");
		setGridPartitePrenotateData(gridPartitePrenotate);
	}


	private void setCmbLivelloData(ComboBox<Livello> cmbLivello) {
		List<Livello> livelli = LivelliService.findAll();
		cmbLivello.setItems(livelli);
		cmbLivello.setItemLabelGenerator(item -> item.getNomeLivello());
	}

	private void setGridPartitePrenotateData(Grid grid) {
		
	}

}
