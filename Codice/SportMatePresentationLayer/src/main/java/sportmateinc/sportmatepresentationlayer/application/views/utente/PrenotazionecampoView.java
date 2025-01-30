package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Partita;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.services.DisponibilitaService;
import sportmateinc.sportmatebusinesslayer.services.PartitaService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@PageTitle("Prenotazione campo")
@Route("prenotazioneCampo/:id")
@RolesAllowed({"USER"})
public class PrenotazionecampoView extends Composite<VerticalLayout> implements BeforeEnterObserver{
	private static final String FIELD_WIDTH = "192px";
	private static final String ERROR_MESSAGE = "Posti superati";
	private static final String WIDTH_STYLE = "min-content";
	private static final String GROW_STYLE = "flex-grow";
	private static final long serialVersionUID = 1L;
	private static final String ID_PARAMETER = "id";
	HorizontalLayout layoutRow = new HorizontalLayout();
	VerticalLayout layoutColumn2 = new VerticalLayout();
	H1 titoloPrenotazioneCampo = new H1();
	HorizontalLayout layoutRow2 = new HorizontalLayout();
	VerticalLayout layoutColumn3 = new VerticalLayout();
	RadioButtonGroup<String> rdbTipoPartita = new RadioButtonGroup<>();
	TextField txtNumPartecipanti = new TextField();
	TextField txtTipoCampo = new TextField();
	VerticalLayout layoutColumn4 = new VerticalLayout();
	TextField txtCentro = new TextField();
	DatePicker dtpData = new DatePicker();
	TextField txtOrario = new TextField();
	ComboBox<String> cmbModPag = new ComboBox<>();
	Button btnProcedi = new Button();
	VerticalLayout layoutColumn5 = new VerticalLayout();
	int idDisp;
	Disponibilita disponibilita;

	public PrenotazionecampoView() {
		getContent().setWidth("100%");
		getContent().getStyle().set(GROW_STYLE, "1");
		setTitoloPrenotazioneCampo();
		setRdbTipoPartita();
		setTxtNumPartecipanti();
		setTxtTipoCampo();
		setTxtCentro();
		setDtpData();
		setTxtOrario();
		setCmbModPag();
		setBtnProcedi();
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.getStyle().set(GROW_STYLE, "1");
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set(GROW_STYLE, "1");
		layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn2.setAlignItems(Alignment.START);
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, titoloPrenotazioneCampo);
		layoutRow2.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set(GROW_STYLE, "1");
		layoutRow2.setAlignItems(Alignment.START);
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn3.setHeightFull();
		layoutRow2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set(GROW_STYLE, "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn3.setAlignItems(Alignment.CENTER);
		layoutColumn4.setHeightFull();
		layoutRow2.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.getStyle().set(GROW_STYLE, "1");
		layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn4.setAlignItems(Alignment.CENTER);
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.END, btnProcedi);
		layoutColumn5.getStyle().set(GROW_STYLE, "1");
		layoutColumn5.add(layoutColumn4);
		getContent().add(layoutRow);
		layoutRow.add(layoutColumn2);
		layoutColumn2.add(titoloPrenotazioneCampo);
		layoutColumn2.add(layoutRow2);
		layoutRow2.add(layoutColumn3);
		layoutColumn3.add(rdbTipoPartita);
		layoutColumn3.add(txtNumPartecipanti);
		layoutColumn3.add(txtTipoCampo);
		layoutColumn4.add(txtCentro);
		layoutColumn4.add(dtpData);
		layoutColumn4.add(txtOrario);
		layoutColumn4.add(cmbModPag);
		layoutColumn4.add(btnProcedi);
		layoutRow2.add(layoutColumn5);
	}

	private void setBtnProcedi() {
		NotificationDelegator delegator = new NotificationDelegator();
		btnProcedi.setText("Procedi");
		btnProcedi.setWidth("101px");
		btnProcedi.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnProcedi.addClickListener(event -> {
			int numPart= 0;
			if (!txtNumPartecipanti.isEmpty()) {
				numPart= Integer.parseInt(txtNumPartecipanti.getValue());
			}
			String tipoPart = rdbTipoPartita.getValue();
			String modPag = cmbModPag.getValue();
			int postiLiberi = getPostiTotali(disponibilita.getTipoCampo().getIdCampo()) - numPart;
			Utente utente = getUtenteInfo();
			if(tipoPart.equals("Pubblica")) {
				Partita partita = new Partita(0,postiLiberi,1,0,modPag,utente.getId(),idDisp);
				PartitaService.aggiungiPartita(partita);
				disponibilita.setPrenotatoBoolean(true);
				if(cmbModPag.getValue().equals("Credito")) {
					UtentiService.ricaricaCredito(utente, disponibilita.getPrezzo().negate().doubleValue());
				}
				DisponibilitaService.aggiornaDisponibilita(disponibilita);
				delegator.showSuccessNotification("Partita prenotata correttamente!");
				UI.getCurrent().navigate("/myprofile");
			}else {
				Partita partita = new Partita(0,postiLiberi,0,1,modPag,utente.getId(),idDisp);
				PartitaService.aggiungiPartita(partita);
				disponibilita.setPrenotatoBoolean(true);
				if(cmbModPag.getValue().equals("Credito")) {
					UtentiService.ricaricaCredito(utente, disponibilita.getPrezzo().negate().doubleValue());
				}
				DisponibilitaService.aggiornaDisponibilita(disponibilita);
				delegator.showSuccessNotification("Partita prenotata correttamente!");
				UI.getCurrent().navigate("/myprofile");
			}
		});
	}

	private void setCmbModPag() {
		cmbModPag.setLabel("Modalità pagamento");
		cmbModPag.setWidth(WIDTH_STYLE);
		setComboBox(cmbModPag);
		cmbModPag.addBlurListener(e ->{
			if(cmbModPag.getValue().equals("Credito")) {
				Utente utente = getUtenteInfo();
				if(utente.getCredito().doubleValue() < disponibilita.getPrezzo().doubleValue()) {
					cmbModPag.setErrorMessage("Credito insufficiente");
					cmbModPag.setInvalid(true);
				}
			}
			else {
				cmbModPag.setInvalid(false);
			}
		});
	}

	private void setTxtOrario() {
		txtOrario.setLabel("Orario prenotazione:");
		txtOrario.setWidth(FIELD_WIDTH);
		txtOrario.setReadOnly(true);
	}

	private void setDtpData() {
		dtpData.setLabel("Data prenotazione:");
		dtpData.setWidth(WIDTH_STYLE);
		dtpData.setReadOnly(true);
	}

	private void setTxtCentro() {
		txtCentro.setLabel("Centro Sportivo");
		txtCentro.setWidth(FIELD_WIDTH);
		txtCentro.setReadOnly(true);
	}

	private void setTitoloPrenotazioneCampo() {
		titoloPrenotazioneCampo.setText("SportMate");
		titoloPrenotazioneCampo.setWidth("max-content");
	}
	private void setTxtTipoCampo() {
		txtTipoCampo.setLabel("Tipologia Campo");
		txtTipoCampo.setWidth(FIELD_WIDTH);
		txtTipoCampo.setReadOnly(true);
	}
	private void setTxtNumPartecipanti() {
		txtNumPartecipanti.setLabel("Numero di partecipanti:");
		txtNumPartecipanti.setWidth(FIELD_WIDTH);
		txtNumPartecipanti.setReadOnly(true);
		txtNumPartecipanti.setErrorMessage(ERROR_MESSAGE);

		txtNumPartecipanti.addBlurListener(event -> {
			if(!txtNumPartecipanti.isEmpty()) {
				int value = Integer.parseInt(txtNumPartecipanti.getValue());
				boolean condizioneCalcio7 = value > 13 && disponibilita.getTipoCampo().getIdCampo()==2;
				boolean condizioneCalcio5 = value > 9 && disponibilita.getTipoCampo().getIdCampo()== 1;
				boolean condizioneBasket3 = value > 5 && disponibilita.getTipoCampo().getIdCampo()== 3;
				boolean expression = condizioneCalcio7 || condizioneCalcio5 || condizioneBasket3;
				txtNumPartecipanti.setInvalid(expression);
			}
		});
	}
	private void setRdbTipoPartita() {
		rdbTipoPartita.setLabel("Seleziona tipologia partita");
		rdbTipoPartita.setWidth(FIELD_WIDTH);
		rdbTipoPartita.setHeight("158px");
		rdbTipoPartita.setItems("Privata", "Pubblica");
		rdbTipoPartita.setValue("Privata");
		rdbTipoPartita.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		rdbTipoPartita.addValueChangeListener(event -> {
			String selectedValue = event.getValue();
			txtNumPartecipanti.setReadOnly(!selectedValue.equals("Pubblica"));
		});
	}
	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		Optional<String> disponibilitaId = event.getRouteParameters().get(ID_PARAMETER);
		if (disponibilitaId.isPresent()) {
			String id = disponibilitaId.get();
			idDisp = Integer.parseInt(id);

		} else {
			Notification.show("ID non fornito!", 3000, Notification.Position.BOTTOM_START);
		}
		disponibilita = DisponibilitaService.findById(idDisp);
		txtTipoCampo.setValue(disponibilita.getTipoCampo().getNomeCampo());
		txtCentro.setValue(disponibilita.getCentro().getNomeComm());
		dtpData.setValue(disponibilita.getDataOra().toLocalDate());
		txtOrario.setValue(disponibilita.getDataOra().getHour() + ".00");
	}
	private void setComboBox(ComboBox<String> comboBox) {
		List<String> list = Arrays.asList("Credito","Contanti");
		comboBox.setItems(list);
		comboBox.setValue(list.get(0));

	}
	private int getPostiTotali(int idTipoCampo) {
		if(idTipoCampo==1) {
			return 10;
		}else if(idTipoCampo==2){
			return 14;
		}else if(idTipoCampo==3){
			return 6;
		}
		return -1;
	}
	private Utente getUtenteInfo() {
		String username = VaadinRequest.getCurrent().getUserPrincipal().getName();
		if (username != null) {

			return UtentiService.findByUsername(username);

		}else {
			Notification.show("Username non trovato", 2000, Position.BOTTOM_START);
			return null ;
		}
	}
}
