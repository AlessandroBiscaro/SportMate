package sportmateinc.sportmatepresentationlayer.application.views.gestore;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.DisponibilitaService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.TipoCampoService;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Gestione disponibilità")
@Route("gestDisp/:typeDispID?/:action?(edit)")
@Menu(order = 8, icon = LineAwesomeIconUrl.ADDRESS_BOOK_SOLID)
@RolesAllowed({ "ADMIN" })

@Uses(Icon.class)
@Uses(Icon.class)
public class GestioneDisponibilitaView extends Div implements BeforeEnterObserver {

	private static final long serialVersionUID = 1L;
	private static final String TYPEDISP_ID = "typeDispID";
	private final Grid<Disponibilita> grid = new Grid<>(Disponibilita.class, false);

	private Checkbox prenotato;
	private DateTimePicker dataOra;
	private ComboBox<TipoCampo> tipologiaCampo;
	private TextField prezzo;

	private final Button cancel = new Button("Reset");
	private final Button save = new Button("Aggiorna");
	private final Button insert = new Button("Inserisci");

	private Disponibilita currentDisponibilita;
	private List<Disponibilita> disponibilitaList = new ArrayList<>();
	private NotificationDelegator delegator = new NotificationDelegator();

	public GestioneDisponibilitaView() {
		addClassNames("gestionedisponibilità-view");

		SplitLayout splitLayout = new SplitLayout();
		createGridLayout(splitLayout);
		createEditorLayout(splitLayout);

		add(splitLayout);

		grid.addColumn(d -> d.getPrenotatoBoolean() ? "✔" : "✖").setHeader("Prenotato").setAutoWidth(true);
		grid.addColumn(Disponibilita::getDataOra).setHeader("Data e Ora").setAutoWidth(true);
		grid.addColumn(d -> d.getTipoCampo().getNomeCampo()).setHeader("Tipologia Campo").setAutoWidth(true);
		grid.addColumn(Disponibilita::getPrezzo).setHeader("Prezzo").setAutoWidth(true);

		CentroSportivo centroSportivo = getCentroSportivoInfo();

		if(centroSportivo == null) {
			return;
		}
		int idCentro  = centroSportivo.getIdCentro();
		try {
			disponibilitaList = DisponibilitaService.findByGestore(idCentro);
			grid.setItems(disponibilitaList);
		}catch(NullPointerException ex) {
			grid.setItems(List.of());
		}

		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

		grid.asSingleSelect().addValueChangeListener(event -> {
			if (event.getValue() != null) {
				populateForm(event.getValue());
			} else {
				clearForm();
			}
		});

		cancel.addClickListener(e -> clearForm());
		save.addClickListener(e -> saveDisponibilita());
		insert.addClickListener(e -> inserisciDisponibilita());
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		Optional<String> typeDispId = event.getRouteParameters().get(TYPEDISP_ID);
		if (typeDispId.isPresent()) {
			int id = Integer.parseInt(typeDispId.get());
			Optional<Disponibilita> matchingDisponibilita = disponibilitaList.stream().filter(d -> d.getIdDisp() == id)
					.findFirst();
			if (matchingDisponibilita.isPresent()) {
				populateForm(matchingDisponibilita.get());
			} else {
				delegator.showErrorNotification("Disponibilità richiesta non trovata!");
				clearForm();
			}
		}
	}

	private void createEditorLayout(SplitLayout splitLayout) {
		Div editorLayoutDiv = new Div();
		editorLayoutDiv.setClassName("editor-layout");

		Div editorDiv = new Div();
		editorDiv.setClassName("editor");
		editorLayoutDiv.add(editorDiv);

		FormLayout formLayout = new FormLayout();
		prenotato = new Checkbox("Prenotato");
		dataOra = new DateTimePicker("Data Ora");
		dataOra.setErrorMessage("Orario fuori apertura");
		dataOra.setStep(Duration.ofMinutes(60));
		dataOra.setMin(LocalDateTime.now().withMinute(0).withSecond(0).plusHours(1));
		tipologiaCampo = new ComboBox<>("Tipologia Campo");
		tipologiaCampo.setPlaceholder("Selezionare una tipologia");
		setCmbTipiCampo();
		prezzo = new TextField("Prezzo");
		formLayout.add(prenotato, dataOra, tipologiaCampo, prezzo);

		editorDiv.add(formLayout);
		createButtonLayout(editorLayoutDiv);

		splitLayout.addToSecondary(editorLayoutDiv);
	}

	private void createButtonLayout(Div editorLayoutDiv) {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setClassName("button-layout");
		cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		insert.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		buttonLayout.add(save, cancel, insert);
		editorLayoutDiv.add(buttonLayout);
	}

	private void createGridLayout(SplitLayout splitLayout) {
		Div wrapper = new Div();
		wrapper.setClassName("grid-wrapper");
		splitLayout.addToPrimary(wrapper);
		wrapper.add(grid);
	}

	private void inserisciDisponibilita() {

		if (currentDisponibilita == null) {
			currentDisponibilita = new Disponibilita();
			disponibilitaList.add(currentDisponibilita);
		}
		currentDisponibilita.setCentro(getCentroSportivoInfo());
		currentDisponibilita.setPrenotatoBoolean(prenotato.getValue());
		currentDisponibilita.setDataOra(dataOra.getValue());
		currentDisponibilita.setTipoCampo(TipoCampoService.findTipoCampo(tipologiaCampo.getValue().getIdCampo()));
		currentDisponibilita.setPrezzo(new BigDecimal(prezzo.getValue()));
		if(getCentroSportivoInfo()==null) {
			return;
		}
		LocalTime minTime = LocalTime.parse(getCentroSportivoInfo().getOrarioApertura(), DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime maxTime = LocalTime.parse(getCentroSportivoInfo().getOrarioChiusura(), DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime currentTime = dataOra.getValue().toLocalTime();
		if(currentTime.isAfter(maxTime) || currentTime.isBefore(minTime)) {
			delegator.showErrorNotification("Orario fuori fascia apertura");
			return;
		}
		if (DisponibilitaService.aggiungiDisponibilita(currentDisponibilita) > 0) {
			delegator.showSuccessNotification("Disponibilità aggiunta correttamente");
			clearForm();
			refreshGrid();
		} else {
			delegator.showErrorNotification("Errore durante l'inserimento della disponibilità");
		}

	}

	private void saveDisponibilita() {
		if (currentDisponibilita == null) {
			currentDisponibilita = new Disponibilita();
			disponibilitaList.add(currentDisponibilita);
		}
		currentDisponibilita.setPrenotatoBoolean(prenotato.getValue());
		currentDisponibilita.setDataOra(dataOra.getValue());
		currentDisponibilita.setTipoCampo(TipoCampoService.findTipoCampo(tipologiaCampo.getValue().getIdCampo()));
		currentDisponibilita.setPrezzo(new BigDecimal(prezzo.getValue()));
		try {
			if (DisponibilitaService.aggiornaDisponibilita(currentDisponibilita) > 0) {
				delegator.showSuccessNotification("Disponibilità aggiornata correttamente!");
				clearForm();
				refreshGrid();
			} else {
				delegator.showErrorNotification("Disponibilità non salvata correttamente");
			}
		}catch(Exception e){
			delegator.showErrorNotification("Aggiornamneto fallito, disponibilità nuova");
		}
	}

	private void refreshGrid() {
		grid.setItems(disponibilitaList);
		grid.getDataProvider().refreshAll();
	}

	private void clearForm() {
		currentDisponibilita = null;
		prenotato.setValue(false);
		dataOra.setValue(null);
		setCmbTipiCampo();
		prezzo.setValue("");
	}

	private void populateForm(Disponibilita value) {
		currentDisponibilita = value;
		prenotato.setValue(value.getPrenotatoBoolean());
		dataOra.setValue(value.getDataOra());
		tipologiaCampo.setValue(value.getTipoCampo());
		prezzo.setValue(value.getPrezzo().toString());
	}

	private CentroSportivo getCentroSportivoInfo() {
		String username = VaadinRequest.getCurrent().getUserPrincipal().getName();
		if (username != null) {

			return CentriSportiviService.findByIdGest(GestoriService.findByUsername(username).getId());

		} else {
			Notification.show("Username non trovato", 2000, Position.BOTTOM_START);
			return null;
		}

	}

	private void setCmbTipiCampo() {
		List<TipoCampo> tipiCampoList = TipoCampoService.findAll();
		tipologiaCampo.setItems(tipiCampoList);
		tipologiaCampo.setItemLabelGenerator(TipoCampo::getNomeCampo);
	}

}
