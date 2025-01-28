package sportmateinc.sportmatepresentationlayer.application.views.gestore;

import com.vaadin.flow.theme.lumo.LumoUtility;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;

import java.time.LocalDate;
import java.util.Optional;


@PageTitle("MySportmate")
@Route("mygestore")
@RolesAllowed({"ADMIN"})
@Uses(Icon.class)

public class AccountGestoreView extends Composite<VerticalLayout> {

	private static final long serialVersionUID = 1L;
	private static final String STANDARD_HEIGHT = "220px";
	private static final String HEIGHT_STYLE = "min-content";
	Gestore gestore;
	H1 titoloAccountGestore = new H1();
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
	Button btnSalva = new Button();
	
	public AccountGestoreView() {

		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, titoloAccountGestore);
		
		getUtenteInfo();
		setTitoloAccountUtente();
		setH5();
		setLayoutColumn2();
		setLayoutRow();
		setLayoutColumn3();
		setLayoutColumn4();
		setLayoutColumn5();
		setBtnSalva();
		setTxtNome();
		setTxtMail();
		setTxtCognome();
		setTxtCellulare();
		setDtpDataNascita();
	}

	private void getUtenteInfo() {
		String username = VaadinRequest.getCurrent().getUserPrincipal().getName();
		if(username != null) {
			this.gestore = GestoriService.findByUsername(username);
		}
	}

	private void setTitoloAccountUtente() {
		titoloAccountGestore.setText("My SportMate");
		titoloAccountGestore.setWidth("max-content");
		getContent().add(titoloAccountGestore);
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
		getContent().add(layoutColumn2);
		layoutColumn2.add(titoloDatiPersonali);
		layoutColumn2.add(layoutRow);
	}

	private void setLayoutRow() {
		layoutRow.setWidthFull();
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.setHeight(HEIGHT_STYLE);
		layoutRow.setFlexGrow(1.0, layoutColumn3);
		layoutRow.setFlexGrow(1.0, layoutColumn4);
		layoutRow.setFlexGrow(1.0, layoutColumn5);
		layoutRow.add(layoutColumn4);
		layoutRow.add(layoutColumn3);
		layoutRow.add(layoutColumn5);
	}

	
	private void setLayoutColumn3() {
		layoutColumn3.setWidth("100%");
		layoutColumn3.setHeight(HEIGHT_STYLE);
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn3.setAlignItems(Alignment.START);
		layoutColumn3.setHeightFull();
		layoutColumn3.add(txtNome);
		layoutColumn3.add(txtMail);
		layoutColumn3.addClassNames(LumoUtility.Padding.MEDIUM);
	}
	
	private void setLayoutColumn4() {
		layoutColumn4.setHeightFull();
		layoutColumn4.setWidth("100%");
		layoutColumn4.setHeight(HEIGHT_STYLE);
		layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn4.setAlignItems(Alignment.START);
		layoutColumn4.add(txtCognome);
		layoutColumn4.add(txtCellulare);
		layoutColumn4.add(btnSalva);
	}
	
	private void setLayoutColumn5() {
		layoutColumn5.setWidth("100%");
		layoutColumn5.setHeight(HEIGHT_STYLE);
		layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn5.setAlignItems(Alignment.START);
		layoutColumn5.setHeightFull();
		layoutColumn5.add(dtpDataNascita);
	}
	
	
	private void setBtnSalva() {
		btnSalva.setText("Salva");
		btnSalva.setWidth("107px");
		btnSalva.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnSalva.addClickListener(event -> validateAndSave());
	}
	
	private void validateAndSave() {
		NotificationDelegator notification = new NotificationDelegator();
		if(! (txtCognome.isInvalid() && txtNome.isInvalid() && txtCellulare.isInvalid() && dtpDataNascita.isInvalid())) {
			Optional<LocalDate> maybeDataNascita = dtpDataNascita.getOptionalValue();
			gestore.setCognome(txtCognome.getValue());
			gestore.setNome(txtNome.getValue());
			gestore.setTelefono(txtCellulare.getValue());
			if(maybeDataNascita.isPresent()) {
				gestore.setDataNascita(maybeDataNascita.get());
			}
			if(GestoriService.aggiornaDatiGestore(gestore) == 1) {
				notification.showSuccessNotification("Dati modificati correttamente!");
			}
		}
	}
	
	private void setTxtNome() {
		txtNome.setLabel("Nome");
		txtNome.setWidth(STANDARD_HEIGHT);
		txtNome.setValue(gestore.getNome());
		txtNome.setRequired(true);
		txtNome.setErrorMessage("Campo richiesto");
	}
	
	private void setTxtMail() {
		txtMail.setLabel("Mail");
		txtMail.setWidth(STANDARD_HEIGHT);
		txtMail.setValue(gestore.getMail());
		txtMail.setEnabled(false);
	}
	
	private void setTxtCognome() {
		txtCognome.setLabel("Cognome");
		txtCognome.setWidth(STANDARD_HEIGHT);
		txtCognome.setValue(gestore.getCognome());
		txtCognome.setRequired(true);
		txtCognome.setErrorMessage("Campo richiesto");
	}
	
	private void setTxtCellulare() {
		txtCellulare.setLabel("Telefono");
		txtCellulare.setWidth(STANDARD_HEIGHT);
		txtCellulare.setValue(gestore.getTelefono());
		txtCellulare.setRequiredIndicatorVisible(true);
		txtCellulare.setAllowedCharPattern("[0-9+-]");
		txtCellulare.setMinLength(5);
		txtCellulare.setMaxLength(18);
		txtCellulare.setErrorMessage("Numero di telefono non valido");
		txtCellulare.addFocusListener(e -> {
			if(!UtentiService.isCellulareUnique(txtCellulare.getValue())) {
				txtCellulare.setErrorMessage("Telefono già registrato");
				txtCellulare.setInvalid(true);
			}
			else {
				txtCellulare.setInvalid(false);
			}
		});
	}
	
	private void setDtpDataNascita() {
		dtpDataNascita.setLabel("Data di nascita");
		dtpDataNascita.setWidth(HEIGHT_STYLE);
		dtpDataNascita.setValue(gestore.getDataNascita());
		dtpDataNascita.setRequired(true);
		dtpDataNascita.setMax(LocalDate.now());
		dtpDataNascita.setErrorMessage("Data non valida");
	}
	
}
