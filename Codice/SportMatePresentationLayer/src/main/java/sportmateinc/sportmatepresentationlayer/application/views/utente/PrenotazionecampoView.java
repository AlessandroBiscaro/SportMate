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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@PageTitle("Prenotazione campo")
@Route("prenotazioneCampo/:id")
@RolesAllowed({"USER"})
public class PrenotazionecampoView extends Composite<VerticalLayout> implements BeforeEnterObserver{

	HorizontalLayout layoutRow = new HorizontalLayout();
	VerticalLayout layoutColumn2 = new VerticalLayout();
	H1 h1 = new H1();
	HorizontalLayout layoutRow2 = new HorizontalLayout();
	VerticalLayout layoutColumn3 = new VerticalLayout();
	RadioButtonGroup<String> rdbTipoPartita = new RadioButtonGroup<>();
	TextField txtNumPartecipanti = new TextField();
	TextField txtTipoCampo = new TextField();
	Button btnIndietro = new Button();
	VerticalLayout layoutColumn4 = new VerticalLayout();
	TextField txtCentro = new TextField();
	DatePicker dtpData = new DatePicker();
	TextField txtOrario = new TextField();
	ComboBox<String> cmbModPag = new ComboBox<>();
	Button btnProcedi = new Button();
	VerticalLayout layoutColumn5 = new VerticalLayout();
	private final String ID_PARAMETER = "id";
	int idDisp;
	Disponibilita disponibilita;
	public PrenotazionecampoView() {
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.getStyle().set("flex-grow", "1");
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set("flex-grow", "1");
		layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn2.setAlignItems(Alignment.START);
		h1.setText("SportMate");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, h1);
		h1.setWidth("max-content");
		layoutRow2.setWidthFull();
		layoutColumn2.setFlexGrow(1.0, layoutRow2);
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set("flex-grow", "1");
		layoutRow2.setAlignItems(Alignment.START);
		layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
		layoutColumn3.setHeightFull();
		layoutRow2.setFlexGrow(1.0, layoutColumn3);
		layoutColumn3.setWidth("100%");
		layoutColumn3.getStyle().set("flex-grow", "1");
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn3.setAlignItems(Alignment.CENTER);
		rdbTipoPartita.setLabel("Seleziona tipologia partita:");
		rdbTipoPartita.setWidth("192px");
		rdbTipoPartita.setHeight("158px");
		rdbTipoPartita.setItems("Privata", "Pubblica");
		rdbTipoPartita.setValue("Privata");
		rdbTipoPartita.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		txtNumPartecipanti.setLabel("Numero di partecipanti:");
		txtNumPartecipanti.setWidth("192px");
		txtNumPartecipanti.setReadOnly(true);
		txtNumPartecipanti.setErrorMessage("Posti superati");
		txtNumPartecipanti.addBlurListener(event -> {
			if(!txtNumPartecipanti.isEmpty()) {
				int value= Integer.parseInt(txtNumPartecipanti.getValue());
				if(value > 13 && (disponibilita.getTipoCampo().getIdCampo()==2)) {
					txtNumPartecipanti.setErrorMessage("Posti superati");
					txtNumPartecipanti.setInvalid(true);
				}else {
					txtNumPartecipanti.setInvalid(false);
				}
				if(value > 9 && disponibilita.getTipoCampo().getIdCampo()== 1) {
					txtNumPartecipanti.setErrorMessage("Posti superati");
					txtNumPartecipanti.setInvalid(true);
				}else {
					txtNumPartecipanti.setInvalid(false);
				}
				if(value > 5 && disponibilita.getTipoCampo().getIdCampo()== 3) {
					txtNumPartecipanti.setErrorMessage("Posti superati");
					txtNumPartecipanti.setInvalid(true);
				}else {
					txtNumPartecipanti.setInvalid(false);
				}
			}
		});
		rdbTipoPartita.addValueChangeListener(event -> {
			String selectedValue = event.getValue();
			if(selectedValue.equals("Pubblica")) {
				txtNumPartecipanti.setReadOnly(false);
			}else {
				txtNumPartecipanti.setReadOnly(true);
			}
		});
		txtTipoCampo.setLabel("Tipologia Campo:");
		txtTipoCampo.setWidth("192px");
		txtTipoCampo.setReadOnly(true);
		btnIndietro.setText("Indietro");
		layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, btnIndietro);
		btnIndietro.setWidth("min-content");
		btnIndietro.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn4.setHeightFull();
		layoutRow2.setFlexGrow(1.0, layoutColumn4);
		layoutColumn4.setWidth("100%");
		layoutColumn4.getStyle().set("flex-grow", "1");
		layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn4.setAlignItems(Alignment.CENTER);
		txtCentro.setLabel("Centro Sportivo");
		txtCentro.setWidth("192px");
		txtCentro.setReadOnly(true);
		dtpData.setLabel("Data prenotazione:");
		dtpData.setWidth("min-content");
		dtpData.setReadOnly(true);
		txtOrario.setLabel("Orario prenotazione:");
		txtOrario.setWidth("192px");
		txtOrario.setReadOnly(true);
		cmbModPag.setLabel("Modalità pagamento");
		cmbModPag.setWidth("min-content");
		setComboBox(cmbModPag);
		btnProcedi.setText("Procedi");
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
				Partita partita = new Partita(0,postiLiberi,1,0,modPag,utente.getIdUtente(),idDisp,0,0);
				if(PartitaService.aggiungiPartita(partita)==1){
					disponibilita.setPrenotatoBoolean(true);
					DisponibilitaService.aggiornaDisponibilita(disponibilita);
					Notification.show("Partita prenotata correttamente", 2000, Position.BOTTOM_START);
					UI.getCurrent().navigate("/myprofile");
				} else {
					Notification.show("Errore nella prenotazione", 2000, Position.BOTTOM_START);
				}
			}else {
				Partita partita = new Partita(0,postiLiberi,0,1,modPag,utente.getIdUtente(),idDisp,0,0);
				if(PartitaService.aggiungiPartita(partita)==1){
					disponibilita.setPrenotatoBoolean(true);
					DisponibilitaService.aggiornaDisponibilita(disponibilita);
					Notification.show("Partita prenotata correttamente", 2000, Position.BOTTOM_START);
					UI.getCurrent().navigate("/myprofile");
				} else {
					Notification.show("Errore nella prenotazione", 2000, Position.BOTTOM_START);
				}
			}
		});
		layoutColumn4.setAlignSelf(FlexComponent.Alignment.END, btnProcedi);
		btnProcedi.setWidth("101px");
		btnProcedi.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		layoutColumn5.getStyle().set("flex-grow", "1");
		layoutColumn5.add(layoutColumn4);
		getContent().add(layoutRow);
		layoutRow.add(layoutColumn2);
		layoutColumn2.add(h1);
		layoutColumn2.add(layoutRow2);
		layoutRow2.add(layoutColumn3);
		layoutColumn3.add(rdbTipoPartita);
		layoutColumn3.add(txtNumPartecipanti);
		layoutColumn3.add(txtTipoCampo);
		layoutColumn3.add(btnIndietro);
		layoutColumn4.add(txtCentro);
		layoutColumn4.add(dtpData);
		layoutColumn4.add(txtOrario);
		layoutColumn4.add(cmbModPag);
		layoutColumn4.add(btnProcedi);
		layoutRow2.add(layoutColumn5);
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
