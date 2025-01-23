package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.theme.lumo.LumoUtility;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
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
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.spring.security.AuthenticationContext;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import SportMateInc.SportMateBusinessLayer.entity.AuthenticatedProfile;
import SportMateInc.SportMateBusinessLayer.entity.Livello;
import SportMateInc.SportMateBusinessLayer.entity.Utente;
import SportMateInc.SportMateBusinessLayer.services.LivelliService;
import SportMateInc.SportMateBusinessLayer.services.UtentiService;
import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatepresentationlayer.application.data.SamplePerson;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("MySportmate")
@Route("myprofile")
@RolesAllowed({"USER"})
@Uses(Icon.class)

public class AccountUtenteView extends Composite<VerticalLayout> {

	Utente utente;
	H1 titoloAccountUtente = new H1();
	VerticalLayout layoutColumn2 = new VerticalLayout();
	H5 titoloDatiPersonali = new H5();
	HorizontalLayout layoutRow = new HorizontalLayout();
	VerticalLayout layoutColumn3 = new VerticalLayout();
	TextField txtNome = new TextField();
	TextField txtMail = new TextField();
	VerticalLayout layoutColumn4 = new VerticalLayout();
	TextField txtCognome = new TextField();
	TextField txtCellulare = new TextField();
	VerticalLayout layoutColumn5 = new VerticalLayout();
	DatePicker dtpDataNascita = new DatePicker();
	ComboBox<Livello> cmbLivello = new ComboBox<>();
	Button btnSalva = new Button();
	H5 titoloCredito = new H5();
	VerticalLayout layoutColumn6 = new VerticalLayout();
	TextField txtImporto = new TextField();
	HorizontalLayout layoutRow2 = new HorizontalLayout();
	HorizontalLayout layoutRow3 = new HorizontalLayout();
	Button btnRicaricaCredito = new Button();
	H5 titoloPartitePrenotate = new H5();
	VerticalLayout layoutColumn7 = new VerticalLayout();
	Grid gridPartitePrenotate = new Grid(SamplePerson.class);

	public AccountUtenteView() {

		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, titoloAccountUtente);
		
		getUtenteInfo();
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
		setBtnSalva();
		setBtnRicarica();
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

	private void getUtenteInfo() {
		String username = VaadinRequest.getCurrent().getUserPrincipal().getName();
		if(username != null) {
			this.utente = UtentiService.findByUsername(username);
		}
	}

	private void setTitoloAccountUtente() {
		titoloAccountUtente.setText("My SportMate");
		titoloAccountUtente.setWidth("max-content");
		getContent().add(titoloAccountUtente);
	}
	
	private void setH5() {
		titoloDatiPersonali.setText("Dati personali");
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
		layoutColumn3.addClassNames(LumoUtility.Padding.MEDIUM);
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
		layoutColumn4.setAlignItems(Alignment.START);
		layoutColumn4.add(txtCognome);
		layoutColumn4.add(txtCellulare);
		layoutColumn4.add(btnSalva);
	}
	
	private void setLayoutColumn5() {
		layoutColumn5.setWidth("100%");
		layoutColumn5.setHeight("min-content");
		layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn5.setAlignItems(Alignment.START);
		layoutColumn5.setHeightFull();
		layoutColumn5.add(dtpDataNascita);
		layoutColumn5.add(cmbLivello);
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
	
	private void setBtnSalva() {
		btnSalva.setText("Salva");
		btnSalva.setWidth("107px");
		btnSalva.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnSalva.addClickListener(event -> validateAndSave());
	}
	
	private void validateAndSave() {
		if(txtCognome.isInvalid() || txtNome.isInvalid() || txtCellulare.isInvalid() || dtpDataNascita.isInvalid()) {
			return;
		}
		Optional<LocalDate> maybeDataNascita = dtpDataNascita.getOptionalValue();
		utente.setCognome(txtCognome.getValue());
		utente.setNome(txtNome.getValue());
		utente.setTelefono(txtCellulare.getValue());
		if(maybeDataNascita.isPresent()) {
			utente.setDataNascita(maybeDataNascita.get());
		}
		utente.setLivello(cmbLivello.getValue());
		UtentiService.aggiornaDatiUtente(utente);
		UI.getCurrent().getPage().reload();
	}

	private void setBtnRicarica() {
		btnRicaricaCredito.setText("Ricarica");
		btnRicaricaCredito.setWidth("107px");
		btnRicaricaCredito.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	}
	
	private void setTxtNome() {
		txtNome.setLabel("Nome");
		txtNome.setWidth("220px");
		txtNome.setValue(utente.getNome());
		txtNome.setRequired(true);
		txtNome.setErrorMessage("Campo richiesto");
	}
	
	private void setTxtMail() {
		txtMail.setLabel("Mail");
		txtMail.setWidth("220px");
		txtMail.setValue(utente.getMail());
		txtMail.setEnabled(false);
	}
	
	private void setTxtCognome() {
		txtCognome.setLabel("Cognome");
		txtCognome.setWidth("220px");
		txtCognome.setValue(utente.getCognome());
		txtCognome.setRequired(true);
		txtCognome.setErrorMessage("Campo richiesto");
	}
	
	private void setTxtCellulare() {
		txtCellulare.setLabel("Telefono");
		txtCellulare.setWidth("220px");
		txtCellulare.setValue(utente.getTelefono());
		txtCellulare.setRequiredIndicatorVisible(true);
		txtCellulare.setAllowedCharPattern("[0-9+-]");
		txtCellulare.setMinLength(5);
		txtCellulare.setMaxLength(18);
		txtCellulare.setErrorMessage("Numero di telefono non valido");
	}
	
	private void setTxtImporto() {
		txtImporto.setLabel("Importo");
		txtImporto.setWidth("220px");
	}
	
	private void setDtpDataNascita() {
		dtpDataNascita.setLabel("Data di nascita");
		dtpDataNascita.setWidth("min-content");
		dtpDataNascita.setValue(utente.getDataNascita());
		dtpDataNascita.setRequired(true);
		dtpDataNascita.setMax(LocalDate.now());
		dtpDataNascita.setErrorMessage("Data non valida");
	}
	
	private void setCmbLivello() {
		cmbLivello.setLabel("Livello");
		cmbLivello.setWidth("min-content");
		cmbLivello.setAllowCustomValue(false);
		setCmbLivelloData(cmbLivello);
		cmbLivello.setValue(utente.getLivello());
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
