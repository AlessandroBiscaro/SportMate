package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import SportMateInc.SportMateBusinessLayer.entity.Livello;
import SportMateInc.SportMateBusinessLayer.services.LivelliService;
import SportMateInc.SportMateBusinessLayer.services.UtentiService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;
import SportMateInc.SportMateBusinessLayer.entity.Utente;

import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Registrazione Utente")
@Route("registrazioneUtente")
@AnonymousAllowed



public class RegistrazioneUtenteView extends Composite<VerticalLayout> {
	
	private static int NUM_FIELD = 8;
	
	H1 h1 = new H1();
    H5 h5 = new H5();
    HorizontalLayout layoutRow = new HorizontalLayout();
    VerticalLayout layoutColumn5 = new VerticalLayout();
    VerticalLayout layoutColumn2 = new VerticalLayout();
    TextField textFieldNome = new TextField();
    DatePicker datePickerDataNascita = new DatePicker();
    EmailField emailField = new EmailField();
    ComboBox<Livello> comboBoxLivello = new ComboBox<>();
    VerticalLayout layoutColumn3 = new VerticalLayout();
    VerticalLayout layoutColumn6 = new VerticalLayout();
    VerticalLayout layoutColumn4 = new VerticalLayout();
    TextField textFieldCognome = new TextField();
    TextField textFieldCellulare = new TextField();
    PasswordField passwordField = new PasswordField();
    PasswordField passwordFieldConferma = new PasswordField();
    VerticalLayout layoutColumn7 = new VerticalLayout();
    Button btnRegistrazione = new Button();
    ProgressBar progressBar = new ProgressBar();
    
    
    public RegistrazioneUtenteView() {
        
        getContent().setWidth("100%");
        getContent().setHeight("min-content");
        h1.setText("SportMate");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");
        h5.setText("Inserisci i tuoi dati:");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("360px");
        layoutColumn5.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setWidth("135px");
        layoutColumn5.setHeight("100%");
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth("360px");
        layoutColumn2.setHeight("450px");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.END);
        
        setTextFieldNome();
        
        setDatePickerDataNascita();
        
        setEmailField();
        
        setComboBoxLivello();
        
        layoutColumn3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("55px");
        layoutColumn3.setHeight("100%");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn3.setAlignItems(Alignment.CENTER);
        layoutColumn6.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("100%");
        layoutColumn6.setHeight("360px");
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Gap.XSMALL);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth("360px");
        layoutColumn4.setHeight("450px");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.START);
        
        setTextFieldCognome();
        setTextFieldCellulare();
        setPasswordField();
        setPasswordConfermaField();
        
        layoutColumn7.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.setWidth("135px");
        layoutColumn7.getStyle().set("flex-grow", "1");
        
        setProgressBar();
        
        getContent().add(h1);
        getContent().add(h5);
        getContent().add(layoutRow);
        setButtonRegistrazione();
        layoutRow.add(layoutColumn5);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(textFieldNome);
        layoutColumn2.add(datePickerDataNascita);
        layoutColumn2.add(emailField);
        layoutColumn2.add(comboBoxLivello);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(layoutColumn6);
        layoutRow.add(layoutColumn4);
        layoutColumn4.add(textFieldCognome);
        layoutColumn4.add(textFieldCellulare);
        layoutColumn4.add(passwordField);
        layoutColumn4.add(passwordFieldConferma);
        layoutRow.add(layoutColumn7);
        
        getContent().add(progressBar);
    }

	private void setProgressBar() {
		progressBar.setValue(0);
		progressBar.setMin(0);
		progressBar.setMax(1);
        progressBar.setWidth("100%");
        progressBar.setHeight("15px");
	}

	private void setPasswordConfermaField() {
		passwordFieldConferma.setLabel("Conferma password");
        passwordFieldConferma.setWidth("192px");
        passwordFieldConferma.setRequired(true);
        passwordFieldConferma.addBlurListener(e -> {
			if(!passwordFieldConferma.getValue().equals(passwordField.getValue())) {
				passwordFieldConferma.setErrorMessage("Le password non coincidono");
				passwordFieldConferma.setInvalid(true);
				decrementProgressBar();
			}
			else {	
				passwordFieldConferma.setInvalid(false);
				incrementProgressBar();
			}
		});
	}

	private void decrementProgressBar() {
		double progress = progressBar.getValue();
		if(progress > 0) {
			progress -= (double) 1/NUM_FIELD;
			progressBar.setValue(progress);
		}
	}
	
	private void incrementProgressBar() {
		double progress = progressBar.getValue() + ((double) 1/NUM_FIELD);
		progressBar.setValue(progress);
	}

	private void setPasswordField() {
		passwordField.setLabel("Password");
        passwordField.setWidth("192px");
        passwordField.setRequired(true);
        passwordField.setErrorMessage("Campo richiesto");
        passwordField.addBlurListener(e -> {
        	if(passwordField.isEmpty()) {
        		decrementProgressBar();
        	}
        	else {
        		incrementProgressBar();
        	}
        });
	}

	private void setTextFieldCognome() {
		textFieldCognome.setLabel("Cognome");
        textFieldCognome.setWidth("192px");
        textFieldCognome.setRequired(true);
		textFieldCognome.setErrorMessage("Campo richiesto");
		textFieldCognome.addBlurListener(e -> {
	        	if(textFieldCognome.isInvalid()) {
	        		decrementProgressBar();
	        	}
	        	else {
	        		incrementProgressBar();
	        	}
	        });
	}
	
	private void setTextFieldCellulare() {
		textFieldCellulare.setLabel("Cellulare");
        textFieldCellulare.setWidth("192px");
        textFieldCellulare.setRequiredIndicatorVisible(true);
		textFieldCellulare.setAllowedCharPattern("[0-9+-]");
		textFieldCellulare.setMinLength(5);
		textFieldCellulare.setMaxLength(18);
        textFieldCellulare.addBlurListener(e -> {
			if(!UtentiService.isCellulareUnique(textFieldCellulare.getValue())) {
				textFieldCellulare.setErrorMessage("Telefono già registrato");
				textFieldCellulare.setInvalid(true);
				decrementProgressBar();
			}
			else {
				textFieldCellulare.setInvalid(false);
				incrementProgressBar();
			}
		});
	}

	private void setComboBoxLivello() {
		comboBoxLivello.setLabel("Livello giocatore");
        comboBoxLivello.setWidth("min-content");
        comboBoxLivello.setAllowCustomValue(false);
        comboBoxLivello.setRequired(true);
        comboBoxLivello.setErrorMessage("Campo richiesto");
        setCmbLivelloData(comboBoxLivello);
        comboBoxLivello.addBlurListener(e -> {
        	if(comboBoxLivello.isInvalid()) {
        		decrementProgressBar();
        	}
        	else {
        		incrementProgressBar();
        	}
        });
	}

	private void setEmailField() {
		emailField.setLabel("Email");
        emailField.setWidth("192px");
        emailField.setRequired(true);
        emailField.setErrorMessage("Campo richiesto");
        emailField.addBlurListener(e -> {
			if(!UtentiService.isMailUnique(textFieldCellulare.getValue())) {
				emailField.setErrorMessage("Utente già registrato");
				emailField.setInvalid(true);
				decrementProgressBar();
			}
			else {
				emailField.setInvalid(false);
				incrementProgressBar();
			}
		});
	}

	private void setDatePickerDataNascita() {
		datePickerDataNascita.setLabel("Data di nascita");
		datePickerDataNascita.setWidth("min-content");
		datePickerDataNascita.setValue(LocalDate.now());
		datePickerDataNascita.setRequired(true);
		datePickerDataNascita.setMax(LocalDate.now());
		datePickerDataNascita.setErrorMessage("Data non valida");
		datePickerDataNascita.addBlurListener(e -> {
        	if(datePickerDataNascita.isInvalid()) {
        		decrementProgressBar();
        	}
        	else {
        		incrementProgressBar();
        	}
        });
	}

	private void setTextFieldNome() {
		textFieldNome.setLabel("Nome");
        textFieldNome.setWidth("192px");
        textFieldNome.setRequired(true);
		textFieldNome.setErrorMessage("Campo richiesto");
		textFieldNome.addBlurListener(e -> {
        	if(textFieldNome.isInvalid()) {
        		decrementProgressBar();
        	}
        	else {
        		incrementProgressBar();
        	}
        });
	}
    
    private void setButtonRegistrazione() {
    	btnRegistrazione.setText("Registrati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, btnRegistrazione);
        btnRegistrazione.setWidth("min-content");
        btnRegistrazione.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(btnRegistrazione);
        btnRegistrazione.addClickListener(event -> validateAndSave());
    }
    
    private void validateAndSave() {
    	NotificationDelegator notification = new NotificationDelegator();
		if(textFieldCognome.isInvalid() || textFieldNome.isInvalid() || textFieldCellulare.isInvalid() || datePickerDataNascita.isInvalid()) {
			return;
		}
		if(!UtentiService.isCellulareUnique(textFieldCellulare.getValue())) {
    		notification.showErrorNotification("Numero di cellulare già registrato");
		}
		else if(!UtentiService.isMailUnique(emailField.getValue())) {
			notification.showErrorNotification("Utente già registrato");
		}
		else {	
			Optional<LocalDate> maybeDataNascita = datePickerDataNascita.getOptionalValue();
			LocalDate dataNascita = null;
			if(maybeDataNascita.isPresent()) {
				dataNascita = maybeDataNascita.get();
			}
			String nome = textFieldNome.getValue();
        	String cognome = textFieldCognome.getValue();
        	String mail = emailField.getValue();
        	String telefono = textFieldCellulare.getValue();
        	String password = passwordField.getValue();
        	Livello livello = comboBoxLivello.getValue();
        	Utente utente = new Utente(0, mail, nome, cognome, dataNascita, telefono, password, BigDecimal.valueOf(10), livello);
			if(UtentiService.aggiungiUtente(utente) == 1) {
				notification.showSuccessNotification("Utente registrato correttamente!");
			}
		}
	}

    private void setCmbLivelloData(ComboBox<Livello> cmbLivello) {
		List<Livello> livelli = LivelliService.findAll();
		cmbLivello.setItems(livelli);
		cmbLivello.setItemLabelGenerator(item -> item.getNomeLivello());
	}
}
