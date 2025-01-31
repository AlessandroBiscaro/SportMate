package sportmateinc.sportmatepresentationlayer.application.views.gestore;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.ServiziAggiuntivi;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.ServiziAggService;
import sportmateinc.sportmatebusinesslayer.services.TipoCampoService;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@PageTitle("Registrazione Gestore")
@Route("registrazioneGestore")
@AnonymousAllowed
public class RegistrazioneGestoreView extends Composite<VerticalLayout> {
	private static final String TEXTFIELD_WIDTH = "192px";
	private static final String TEXTFIELD_ERROR_MESSAGE = "Campo richiesto";
	private static final String WIDTH_STYLE = "min-content";
	private static final long serialVersionUID = 1L;
	H1 h1 = new H1();
     H5 h5 = new H5();
     HorizontalLayout layoutRow = new HorizontalLayout();
     VerticalLayout layoutColumn4 = new VerticalLayout();
     VerticalLayout layoutColumn2 = new VerticalLayout();
     TextField textFieldNome = new TextField();
     DatePicker datePickerDataNascita = new DatePicker();
     EmailField emailField = new EmailField();
     TextField textFieldNomeCommerciale = new TextField();
     MultiSelectComboBox<TipoCampo> multiSelectTipoCampo = new MultiSelectComboBox<>();
     TimePicker timePickerOraApertura = new TimePicker();
     MultiSelectComboBox<ServiziAggiuntivi> multiSelectServAgg = new MultiSelectComboBox<>();
     VerticalLayout layoutColumn5 = new VerticalLayout();
     VerticalLayout layoutColumn3 = new VerticalLayout();
     TextField textFieldCognome = new TextField();
     TextField textFieldCellulare = new TextField();
     PasswordField passwordField = new PasswordField();
     PasswordField passwordFieldConferma = new PasswordField();
     TextField textFieldIndirizzo = new TextField();
     TimePicker timePickerOraChiusura = new TimePicker();
     TextField textFieldAltro = new TextField();
     VerticalLayout layoutColumn6 = new VerticalLayout();
     Button btnRegistrazione = new Button();
	
    public RegistrazioneGestoreView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
        h1.setText("SportMate");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");
        h5.setText("Inserisci i tuoi dati e quelli del tuo centro");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("135px");
        layoutColumn4.setHeight("528px");
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth("360px");
        layoutColumn2.setHeight("100%");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.END);
        
        setTextFieldNome();
        
        setDatePickerDataNascita();
        
        setEmailField();
        
        setTextFieldNomeCommerciale();
    
        setMultiSelectTipoCampo();
        
        setTimePickerOraApertura();
        
        setTimePickerOraChiusura();
        
        setMultiSelectServAgg();
        
        layoutColumn5.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.addClassName(Gap.XSMALL);
        layoutColumn5.addClassName(Padding.XSMALL);
        layoutColumn5.setWidth("55px");
        layoutColumn5.setHeight("160px");
        layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn5.setAlignItems(Alignment.CENTER);
        layoutColumn3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("360px");
        layoutColumn3.setHeight("100%");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn3.setAlignItems(Alignment.START);
        
        setTextFieldCognome();
        
        setTextFieldCellulare();
        
        setPasswordField();
        
        setPasswordFieldConferma();
        
        setTextFieldIndirizzo();
        
        setTextFieldAltro();
        
        layoutColumn6.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("135px");
        layoutColumn6.setHeight("528px");
        getContent().add(h1);
        getContent().add(h5);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(textFieldNome);
        layoutColumn2.add(datePickerDataNascita);
        layoutColumn2.add(emailField);
        layoutColumn2.add(textFieldNomeCommerciale);
        layoutColumn2.add(multiSelectTipoCampo);
        layoutColumn2.add(timePickerOraApertura);
        layoutColumn2.add(multiSelectServAgg);
        layoutRow.add(layoutColumn5);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(textFieldCognome);
        layoutColumn3.add(textFieldCellulare);
        layoutColumn3.add(passwordField);
        layoutColumn3.add(passwordFieldConferma);
        layoutColumn3.add(textFieldIndirizzo);
        layoutColumn3.add(timePickerOraChiusura);
        layoutColumn3.add(textFieldAltro);
        layoutRow.add(layoutColumn6);
        setButtonRegistrazione();
    }

    private void setMultiSelectServAgg() {
    	 multiSelectServAgg.setLabel("Servizi aggiuntivi");
         multiSelectServAgg.setWidth(WIDTH_STYLE);
		setMultiSelectServAggData(multiSelectServAgg);
	}

	private void setTimePickerOraChiusura() {
		timePickerOraChiusura.setLabel("Orario chiusura");
        timePickerOraChiusura.setWidth(WIDTH_STYLE);
        timePickerOraChiusura.setRequired(true);
        timePickerOraChiusura.addBlurListener(e -> {
        	if(timePickerOraChiusura.getValue().isBefore(timePickerOraApertura.getValue())) {
        		timePickerOraChiusura.setErrorMessage("Orario chiusura non valido");
        		timePickerOraChiusura.setInvalid(true);
        	}
        });
	}

	private void setTimePickerOraApertura() {
		timePickerOraApertura.setLabel("Orario apertura");
        timePickerOraApertura.setWidth(WIDTH_STYLE);
        timePickerOraApertura.setRequired(true);
	}

	private void setMultiSelectTipoCampo() {
		multiSelectTipoCampo.setLabel("Tipologie campi");
        multiSelectTipoCampo.setWidth(WIDTH_STYLE);
		setMultiSelectTipoCampoData(multiSelectTipoCampo);
	}

	private void setTextFieldAltro() {
    	textFieldAltro.setLabel("Altro");
        textFieldAltro.setWidth(TEXTFIELD_WIDTH);
        textFieldAltro.setRequired(true);
		textFieldAltro.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}

	private void setTextFieldIndirizzo() {
		textFieldIndirizzo.setLabel("Indirizzo");
        textFieldIndirizzo.setWidth(TEXTFIELD_WIDTH);
        textFieldIndirizzo.setRequired(true);
		textFieldIndirizzo.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}

	private void setTextFieldNomeCommerciale() {
		textFieldNomeCommerciale.setLabel("Nome commerciale");
        textFieldNomeCommerciale.setWidth(TEXTFIELD_WIDTH);
        textFieldNomeCommerciale.setRequired(true);
		textFieldNomeCommerciale.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}

	private void setButtonRegistrazione() {
    	
        btnRegistrazione.setText("Registrati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, btnRegistrazione);
        btnRegistrazione.setWidth(WIDTH_STYLE);
        btnRegistrazione.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    	getContent().add(btnRegistrazione);
    	btnRegistrazione.addClickListener(e ->{
    		if(textFieldCognome.isInvalid() || datePickerDataNascita.isInvalid() || emailField.isInvalid()|| textFieldNome.isInvalid() || textFieldCellulare.isInvalid() || datePickerDataNascita.isInvalid() || textFieldNomeCommerciale.isInvalid() || textFieldIndirizzo.isInvalid() || textFieldAltro.isInvalid() || multiSelectTipoCampo.isInvalid() || multiSelectServAgg.isInvalid() || timePickerOraApertura.isInvalid() || timePickerOraChiusura.isInvalid()) {
    			return;
    		}
    		NotificationDelegator notification = new NotificationDelegator();
    		String nome = textFieldNome.getValue();
        	String cognome = textFieldCognome.getValue();
        	String mail = emailField.getValue();
        	String telefono = textFieldCellulare.getValue();
        	String psw = passwordField.getValue();
        	String nomeComm =textFieldNomeCommerciale.getValue();
        	String indirizzo = textFieldIndirizzo.getValue();
        	LocalDate dataNascita = datePickerDataNascita.getValue();
        	Set<TipoCampo> tipologieCampo = multiSelectTipoCampo.getValue();
        	String oraApertura = timePickerOraApertura.getValue().toString();
        	String oraChiusura = timePickerOraChiusura.getValue().toString();
			Set<ServiziAggiuntivi> servizi = multiSelectServAgg.getValue();
			Gestore gestore = new Gestore(0,mail,nome,cognome,dataNascita,telefono,psw);
			GestoriService.aggiungiGestore(gestore);
			int idGestore = GestoriService.findByUsername(mail).getId();
			CentroSportivo centro = new CentroSportivo(0, nomeComm, indirizzo, BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0), oraApertura, oraChiusura, idGestore);
			CentriSportiviService.aggiungiCentro(centro);
			int idCentro = CentriSportiviService.findByIdGest(idGestore).getIdCentro();
			for(TipoCampo tipo : tipologieCampo) {
				TipoCampoService.aggiungiTipoCampo(idCentro, tipo.getIdCampo());
			}
			for(ServiziAggiuntivi servizio : servizi) {
				ServiziAggService.aggiungiServizioAgg(idCentro, servizio.getIdServizio());
			}
			notification.showSuccessNotification("Gestore registrato correttamente!");
			UI.getCurrent().getPage().executeJs(
				    "setTimeout(function() { window.location.href = $0; }, 5000);", 
				    "http://localhost:8080/"
			);
    	});
    }

    private void setMultiSelectTipoCampoData(MultiSelectComboBox<TipoCampo> cmbTipo) {
    	List<TipoCampo> tipo = TipoCampoService.findAll();
		cmbTipo.setItems(tipo);
		cmbTipo.setItemLabelGenerator(TipoCampo::getNomeCampo);
    }
    
    private void setMultiSelectServAggData(MultiSelectComboBox<ServiziAggiuntivi> cmbServizi) {
    	List<ServiziAggiuntivi> servizi = ServiziAggService.findAll();
		cmbServizi.setItems(servizi);
		cmbServizi.setItemLabelGenerator(item -> item.getNomeServizio());
    }
    
    private void setPasswordFieldConferma() {
		passwordFieldConferma.setLabel("Conferma password");
        passwordFieldConferma.setWidth(TEXTFIELD_WIDTH);
        passwordFieldConferma.setRequired(true);
        passwordFieldConferma.addBlurListener(e -> {
			if(!passwordFieldConferma.getValue().equals(passwordField.getValue())) {
				passwordFieldConferma.setErrorMessage("Le password non coincidono");
				passwordFieldConferma.setInvalid(true);
				}
			else {	
				passwordFieldConferma.setInvalid(false);
			}
		});
	}


	private void setPasswordField() {
		passwordField.setLabel("Password");
        passwordField.setWidth(TEXTFIELD_WIDTH);
        passwordField.setRequired(true);
        passwordField.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}

	private void setTextFieldCognome() {
		textFieldCognome.setLabel("Cognome");
        textFieldCognome.setWidth(TEXTFIELD_WIDTH);
        textFieldCognome.setRequired(true);
		textFieldCognome.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}
	
	private void setTextFieldCellulare() {
		textFieldCellulare.setLabel("Cellulare");
        textFieldCellulare.setWidth(TEXTFIELD_WIDTH);
        textFieldCellulare.setRequiredIndicatorVisible(true);
		textFieldCellulare.setAllowedCharPattern("[0-9+-]");
		textFieldCellulare.setMinLength(5);
		textFieldCellulare.setMaxLength(18);
        textFieldCellulare.addBlurListener(e -> {
			if(!GestoriService.isCellulareUnique(textFieldCellulare.getValue())) {
				textFieldCellulare.setErrorMessage("Telefono già registrato");
				textFieldCellulare.setInvalid(true);
			}
			else {
				textFieldCellulare.setInvalid(false);
			}
		});
	}

	private void setEmailField() {
		emailField.setLabel("Email");
        emailField.setWidth(TEXTFIELD_WIDTH);
        emailField.setRequired(true);
        emailField.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
        emailField.addBlurListener(e -> {
			if(!GestoriService.isMailUnique(emailField.getValue())) {
				emailField.setErrorMessage("Utente già registrato");
				emailField.setInvalid(true);
			}
			else {
				emailField.setInvalid(false);
			}
		});
	}

	private void setDatePickerDataNascita() {
		datePickerDataNascita.setLabel("Data di nascita");
		datePickerDataNascita.setWidth(WIDTH_STYLE);
		datePickerDataNascita.setRequired(true);
		datePickerDataNascita.setMax(LocalDate.now());
		datePickerDataNascita.setErrorMessage("Data non valida");
	}

	private void setTextFieldNome() {
		textFieldNome.setLabel("Nome");
        textFieldNome.setWidth(TEXTFIELD_WIDTH);
        textFieldNome.setRequired(true);
		textFieldNome.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}
    
}
