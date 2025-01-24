package sportmateinc.sportmatepresentationlayer.application.views.gestore;

import com.vaadin.flow.component.Composite;
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
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import SportMateInc.SportMateBusinessLayer.entity.CentriSportivi;
import SportMateInc.SportMateBusinessLayer.entity.Gestore;
import SportMateInc.SportMateBusinessLayer.entity.Livello;
import SportMateInc.SportMateBusinessLayer.entity.ServiziAgg;
import SportMateInc.SportMateBusinessLayer.entity.TipoCampo;
import SportMateInc.SportMateBusinessLayer.services.LivelliService;
import SportMateInc.SportMateBusinessLayer.services.ServiziAggService;
import SportMateInc.SportMateBusinessLayer.services.TipoCampoService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Registrazione Gestore")
@Route("registrazioneGestore")
@AnonymousAllowed
public class RegistrazioneGestoreView extends Composite<VerticalLayout> {

	 H1 h1 = new H1();
     H5 h5 = new H5();
     HorizontalLayout layoutRow = new HorizontalLayout();
     VerticalLayout layoutColumn4 = new VerticalLayout();
     VerticalLayout layoutColumn2 = new VerticalLayout();
     TextField txtNome = new TextField();
     DatePicker dtpNascita = new DatePicker();
     EmailField emailField = new EmailField();
     TextField txtNomeCom = new TextField();
     MultiSelectComboBox cmbTipoCampo = new MultiSelectComboBox();
     TimePicker tpOpen = new TimePicker();
     MultiSelectComboBox cmbServAgg = new MultiSelectComboBox();
     VerticalLayout layoutColumn5 = new VerticalLayout();
     VerticalLayout layoutColumn3 = new VerticalLayout();
     TextField txtCognome = new TextField();
     TextField txtCell = new TextField();
     PasswordField txtPsw = new PasswordField();
     PasswordField txtPswConf = new PasswordField();
     TextField txtIndirizzo = new TextField();
     TimePicker tpClose = new TimePicker();
     TextField txtAltro = new TextField();
     VerticalLayout layoutColumn6 = new VerticalLayout();
     Button btnRegistrazione = new Button();
     ProgressBar progressBar = new ProgressBar();
	
    public RegistrazioneGestoreView() {
       
        getContent().setHeightFull();
        getContent().setWidthFull();
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
        txtNome.setLabel("Nome:");
        txtNome.setWidth("192px");
        dtpNascita.setLabel("Data di nascita:");
        dtpNascita.setWidth("min-content");
        emailField.setLabel("Email:");
        emailField.setWidth("192px");
        txtNomeCom.setLabel("Nome commerciale:");
        txtNomeCom.setWidth("192px");
        cmbTipoCampo.setLabel("Tipologie campi:");
        cmbTipoCampo.setWidth("min-content");
        setCmbTipoCampo(cmbTipoCampo);
        tpOpen.setLabel("Orario di apertura:");
        tpOpen.setWidth("min-content");
        cmbServAgg.setLabel("Servizi aggiuntivi:");
        cmbServAgg.setWidth("min-content");
        setCmbServizi(cmbServAgg);
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
        txtCognome.setLabel("Cognome:");
        txtCognome.setWidth("192px");
        txtCell.setLabel("Cellulare:");
        txtCell.setWidth("192px");
        txtPsw.setLabel("Password:");
        txtPsw.setWidth("192px");
        txtPswConf.setLabel("Conferma password:");
        txtPswConf.setWidth("192px");
        txtIndirizzo.setLabel("Indirizzo:");
        txtIndirizzo.setWidth("192px");
        tpClose.setLabel("Orario di chiusura:");
        tpClose.setWidth("min-content");
        txtAltro.setLabel("Altro:");
        txtAltro.setWidth("192px");
        layoutColumn6.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("135px");
        layoutColumn6.setHeight("528px");
        progressBar.setValue(0.5);
        progressBar.setHeight("15px");
        getContent().add(h1);
        getContent().add(h5);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(txtNome);
        layoutColumn2.add(dtpNascita);
        layoutColumn2.add(emailField);
        layoutColumn2.add(txtNomeCom);
        layoutColumn2.add(cmbTipoCampo);
        layoutColumn2.add(tpOpen);
        layoutColumn2.add(cmbServAgg);
        layoutRow.add(layoutColumn5);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(txtCognome);
        layoutColumn3.add(txtCell);
        layoutColumn3.add(txtPsw);
        layoutColumn3.add(txtPswConf);
        layoutColumn3.add(txtIndirizzo);
        layoutColumn3.add(tpClose);
        layoutColumn3.add(txtAltro);
        layoutRow.add(layoutColumn6);
        setButtonRegistrazione();
        getContent().add(progressBar);
    }

    private void setButtonRegistrazione() {
    	
        btnRegistrazione.setText("Registrati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, btnRegistrazione);
        btnRegistrazione.setWidth("min-content");
        btnRegistrazione.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    	getContent().add(btnRegistrazione);
    	btnRegistrazione.addClickListener(e ->{
    		
    		String nome = txtNome.getValue();
        	String cognome = txtCognome.getValue();
        	String mail = emailField.getValue();
        	String telefono = txtCell.getValue();
        	String psw = txtPsw.getValue();
        	String nomeComm =txtNomeCom.getValue();
        	String indirizzo = txtIndirizzo.getValue();
        	String confermaPsw = txtPswConf.getValue();
        	LocalDate dataNascita = dtpNascita.getValue();
        	TipoCampo tipo = (TipoCampo) cmbTipoCampo.getValue();
        	String OraApertura = tpOpen.getValue().toString();
        	String OraChiusura = tpClose.getValue().toString();
			List<ServiziAgg> servizi = (List<ServiziAgg>) cmbServAgg.getValue();
			//inserimento controlli e invio query
			Gestore gestore = new Gestore(0,mail,nome,cognome,dataNascita,telefono,psw);
			//creazione centri e poi richiamo inserimento query 
			//CentriSportivi centro = new CentriSportivi();
			
        	
        	
    		
    	});
    }
    
    
    
    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setCmbTipoCampo(MultiSelectComboBox<TipoCampo> cmbTipo) {
    	List<TipoCampo> tipo = TipoCampoService.findAll();
		cmbTipo.setItems(tipo);
		cmbTipo.setItemLabelGenerator(item -> item.getNomeCampo());
    }
    
    private void setCmbServizi(MultiSelectComboBox<ServiziAgg> cmbServizi) {
    	List<ServiziAgg> servizi = ServiziAggService.findAll();
		cmbServizi.setItems(servizi);
		cmbServizi.setItemLabelGenerator(item -> item.getNomeServizio());
    }
}
