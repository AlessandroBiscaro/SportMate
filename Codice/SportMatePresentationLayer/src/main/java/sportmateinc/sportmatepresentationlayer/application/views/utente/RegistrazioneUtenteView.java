package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@PageTitle("Registrazione Utente")
@Route("registrazioneUtente")
@AnonymousAllowed

public class RegistrazioneUtenteView extends Composite<VerticalLayout> {
	
	private static final String HEIGHT_STYLE = "min-content";

	private static final String ERROR_MESSAGE = "Campo richiesto";

	private static final String TEXTFIELD_WIDTH = "192px";

	private static final String LAYOUT_ROW_HEIGHT = "360px";

	private static final long serialVersionUID = 1L;

	private static final int NUMBER_FIELD = 8;
	
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

	private String[] savedFields;
    
    
    public RegistrazioneUtenteView() {
        savedFields = new String[NUMBER_FIELD];
        getContent().setWidth("100%");
        getContent().setHeight(HEIGHT_STYLE);
        h1.setText("SportMate");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");
        h5.setText("Inserisci i tuoi dati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight(LAYOUT_ROW_HEIGHT);
        layoutColumn5.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setWidth("135px");
        layoutColumn5.setHeight("100%");
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth(LAYOUT_ROW_HEIGHT);
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
        layoutColumn6.setHeight(LAYOUT_ROW_HEIGHT);
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Gap.XSMALL);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth(LAYOUT_ROW_HEIGHT);
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
        passwordFieldConferma.setWidth(TEXTFIELD_WIDTH);
        passwordFieldConferma.setRequired(true);
        savedFields[7] = "";
        passwordFieldConferma.addBlurListener(e -> {
        	if(!savedFields[7].equals(passwordFieldConferma.getValue())) {
        		
				if(!passwordFieldConferma.getValue().equals(passwordField.getValue())) {
					passwordFieldConferma.setErrorMessage("Le password non coincidono");
					passwordFieldConferma.setInvalid(true);
						decrementProgressBar();
					}
				else {	
					passwordFieldConferma.setInvalid(false);
					incrementProgressBar();
				}
				savedFields[7] = passwordFieldConferma.getValue();
			}
		});
	}

	private void decrementProgressBar() {
		double progress = progressBar.getValue();
		if(progress > 0) {
			progress -= (double) 1/NUMBER_FIELD;
			progressBar.setValue(progress);
		}
	}
	
	private void incrementProgressBar() {
		double progress = progressBar.getValue() + ((double) 1/NUMBER_FIELD);
		progressBar.setValue(progress);
	}

	private void setPasswordField() {
		passwordField.setLabel("Password");
        passwordField.setWidth(TEXTFIELD_WIDTH);
        passwordField.setRequired(true);
        savedFields[6] = "";
        passwordField.setErrorMessage(ERROR_MESSAGE);
        passwordField.addBlurListener(e -> {
        	if(!savedFields[6].equals(passwordField.getValue())) {
        		
	        	if(passwordField.isEmpty()) {
	        		decrementProgressBar();
	        	}
	        	else {
	        		incrementProgressBar();
	        	}
        	}
        	savedFields[6] = passwordField.getValue();
        });
	}

	private void setTextFieldCognome() {
		savedFields[1] = "";
		textFieldCognome.setLabel("Cognome");
        textFieldCognome.setWidth(TEXTFIELD_WIDTH);
        textFieldCognome.setRequired(true);
		textFieldCognome.setErrorMessage(ERROR_MESSAGE);
		textFieldCognome.addBlurListener(e -> {
			if(!savedFields[1].equals(textFieldCognome.getValue())) {
				
	        	if(textFieldCognome.isInvalid()) {
	        		decrementProgressBar();
	        	}
	        	else {
	        		incrementProgressBar();
	        	}
			}
			savedFields[1] = textFieldCognome.getValue();
        });
	}
	
	private void setTextFieldCellulare() {
		savedFields[3] = "";
		textFieldCellulare.setLabel("Cellulare");
        textFieldCellulare.setWidth(TEXTFIELD_WIDTH);
        textFieldCellulare.setRequiredIndicatorVisible(true);
		textFieldCellulare.setAllowedCharPattern("[0-9+-]");
		textFieldCellulare.setMinLength(5);
		textFieldCellulare.setMaxLength(18);
        textFieldCellulare.addBlurListener(e -> {
        	if(!savedFields[3].equals(textFieldCellulare.getValue())) {
        		
				if(!UtentiService.isCellulareUnique(textFieldCellulare.getValue())) {
					textFieldCellulare.setErrorMessage("Telefono già registrato");
					textFieldCellulare.setInvalid(true);
					decrementProgressBar();
				}
				else {
					textFieldCellulare.setInvalid(false);
					incrementProgressBar();
				}
        	}
        	savedFields[3] = textFieldCellulare.getValue();
		});
	}

	private void setComboBoxLivello() {
		savedFields[5] = "";
		comboBoxLivello.setLabel("Livello giocatore");
        comboBoxLivello.setWidth(HEIGHT_STYLE);
        comboBoxLivello.setAllowCustomValue(false);
        comboBoxLivello.setRequired(true);
        comboBoxLivello.setErrorMessage(ERROR_MESSAGE);
        setCmbLivelloData(comboBoxLivello);
        comboBoxLivello.addBlurListener(e -> {
        	if(!savedFields[5].equals(comboBoxLivello.getValue().getNomeLivello())) {
	        	if(comboBoxLivello.isInvalid()) {
	        		decrementProgressBar();
	        	}
	        	else {
	        		incrementProgressBar();
	        	}
        	}
        	savedFields[5] = comboBoxLivello.getValue().getNomeLivello();
        });
	}

	private void setEmailField() {
		savedFields[4] = "";
		emailField.setLabel("Email");
        emailField.setWidth(TEXTFIELD_WIDTH);
        emailField.setRequired(true);
        emailField.setErrorMessage(ERROR_MESSAGE);
        emailField.addBlurListener(e -> {
        	if(!savedFields[4].equals(emailField.getValue())) {
				if(!UtentiService.isMailUnique(emailField.getValue())) {
					emailField.setErrorMessage("Utente già registrato");
					emailField.setInvalid(true);
					decrementProgressBar();
				}
				else {
					emailField.setInvalid(false);
					incrementProgressBar();
				}
        	}
        	savedFields[4] = emailField.getValue();
		});
	}

	private void setDatePickerDataNascita() {
		savedFields[2] = "";
		datePickerDataNascita.setLabel("Data di nascita");
		datePickerDataNascita.setWidth(HEIGHT_STYLE);
		datePickerDataNascita.setRequired(true);
		datePickerDataNascita.setMax(LocalDate.now());
		datePickerDataNascita.setErrorMessage("Data non valida");
		datePickerDataNascita.addBlurListener(e -> {
			if(!savedFields[2].equals(datePickerDataNascita.getValue().toString())) {
	        	if(datePickerDataNascita.isInvalid()) {
	        		decrementProgressBar();
	        	}
	        	else {
	        		incrementProgressBar();
	        	}
			}
			if(!datePickerDataNascita.isEmpty()) {
				savedFields[2] = datePickerDataNascita.getValue().toString();
			}
			else {
				savedFields[2] = "";
			}
        });
	}

	private void setTextFieldNome() {
		savedFields[0] = "";
		textFieldNome.setLabel("Nome");
        textFieldNome.setWidth(TEXTFIELD_WIDTH);
        textFieldNome.setRequired(true);
		textFieldNome.setErrorMessage(ERROR_MESSAGE);
		textFieldNome.addBlurListener(e -> {
			if(!savedFields[0].equals(textFieldNome.getValue())) {
	        	if(textFieldNome.isInvalid()) {
	        		decrementProgressBar();
	        	}
	        	else {
	        		incrementProgressBar();
	        	}
			}
			savedFields[0] = textFieldNome.getValue();
		});
	}
    
    private void setButtonRegistrazione() {
    	btnRegistrazione.setText("Registrati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, btnRegistrazione);
        btnRegistrazione.setWidth(HEIGHT_STYLE);
        btnRegistrazione.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(btnRegistrazione);
        btnRegistrazione.addClickListener(event -> validateAndSave());
    }
    
    private void validateAndSave() {
    	NotificationDelegator notification = new NotificationDelegator();
		if(textFieldCognome.isInvalid() || textFieldNome.isInvalid() || textFieldCellulare.isInvalid() || comboBoxLivello.isInvalid() ||datePickerDataNascita.isInvalid() || emailField.isInvalid() || passwordField.isInvalid() || passwordFieldConferma.isInvalid()) {
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
				UI.getCurrent().getPage().executeJs(
					    "setTimeout(function() { window.location.href = $0; }, 5000);", 
					    "http://localhost:8080/"
				);
			}
		}
	}

    private void setCmbLivelloData(ComboBox<Livello> cmbLivello) {
		List<Livello> livelli = LivelliService.findAll();
		cmbLivello.setItems(livelli);
		cmbLivello.setItemLabelGenerator(Livello::getNomeLivello);
	}
}
