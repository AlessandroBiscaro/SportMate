package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatebusinesslayer.entities.InfoPartita;
import sportmateinc.sportmatebusinesslayer.services.PartitaService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Partite Pubbliche")
@Route("disponibilitaPubbliche")
@Menu(order = 3, icon = LineAwesomeIconUrl.CLIPBOARD_LIST_SOLID)
@RolesAllowed({"USER"})

@Uses(Icon.class)
public class DisponibilitaPubblicheView extends Div {

	private static final String VISIBILITY_LEVEL = "visible";

	private static final long serialVersionUID = 1L;

	private Grid<InfoPartita> grid;

	private Filters filters;

	public DisponibilitaPubblicheView() {
		setSizeFull();
		addClassNames("disponibilità-view");

		filters = new Filters(this::refreshGrid);
		VerticalLayout layout = new VerticalLayout(createMobileFilters(), filters, createGrid());
		layout.setSizeFull();
		layout.setPadding(false);
		layout.setSpacing(false);
		add(layout);
	}

	private HorizontalLayout createMobileFilters() {
		// Mobile version
		HorizontalLayout mobileFilters = new HorizontalLayout();
		mobileFilters.setWidthFull();
		mobileFilters.addClassNames(LumoUtility.Padding.MEDIUM, LumoUtility.BoxSizing.BORDER,
				LumoUtility.AlignItems.CENTER);
		mobileFilters.addClassName("mobile-filters");

		Icon mobileIcon = new Icon("lumo", "plus");
		Span filtersHeading = new Span("Filters");
		mobileFilters.add(mobileIcon, filtersHeading);
		mobileFilters.setFlexGrow(1, filtersHeading);
		mobileFilters.addClickListener(e -> {
			if (filters.getClassNames().contains(VISIBILITY_LEVEL)) {
				filters.removeClassName(VISIBILITY_LEVEL);
				mobileIcon.getElement().setAttribute("icon", "lumo:plus");
			} else {
				filters.addClassName(VISIBILITY_LEVEL);
				mobileIcon.getElement().setAttribute("icon", "lumo:minus");
			}
		});
		return mobileFilters;
	}

	public static class Filters extends Div {

		private static final long serialVersionUID = 1L;
		private final TextField filtroCentro = new TextField("Centro Sportivo");
		private final TextField filtroPrezzo = new TextField("Prezzo");
		private final DateTimePicker filtroInzioData = new DateTimePicker("Data e Ora");
		private final DateTimePicker filtroFineData = new DateTimePicker();
		private final CheckboxGroup<String> tipoCampo = new CheckboxGroup<>("Tipologia Campo");

		public Filters(Runnable onSearch) {

			setWidthFull();
			addClassName("filter-layout");
			addClassNames(LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Padding.Vertical.MEDIUM,
					LumoUtility.BoxSizing.BORDER);

			// Configura i filtri visivi
			filtroCentro.setPlaceholder("Nome centro sportivo");

			tipoCampo.setItems("Calcio a 5", "Calcio a 7", "Basket 3vs3");
			tipoCampo.addClassName("double-width");

			// Pulsanti di azione
			Button resetBtn = new Button("Reset");
			resetBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
			resetBtn.addClickListener(e -> {
				// Resetta i filtri
				filtroCentro.clear();
				filtroPrezzo.clear();
				filtroInzioData.clear();
				filtroFineData.clear();
				tipoCampo.clear();
				onSearch.run(); // Esegui la ricerca
			});

			Button searchBtn = new Button("Cerca");
			searchBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			searchBtn.addClickListener(e -> onSearch.run());

			Div actions = new Div(resetBtn, searchBtn);
			actions.addClassName(LumoUtility.Gap.SMALL);
			actions.addClassName("actions");

			add(filtroCentro, filtroPrezzo, createDateRangeFilter(), tipoCampo, actions);
		}

		private Component createDateRangeFilter() {


			filtroInzioData.setDatePlaceholder("Da");
			filtroFineData.setDatePlaceholder("A");

			// Accessibilità per screen readers
			filtroInzioData.setAriaLabel("Dalla data");
			filtroFineData.setAriaLabel("Alla data");

			FlexLayout dateRangeComponent = new FlexLayout(filtroInzioData, new Text(" – "), filtroFineData);
			dateRangeComponent.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
			dateRangeComponent.addClassName(LumoUtility.Gap.XSMALL);
			dateRangeComponent.addClassName("date-range-component");
			dateRangeComponent.setAlignItems(FlexComponent.Alignment.CENTER);
			return dateRangeComponent;
		}

		/**
		 * Applica i filtri manualmente a una lista di `DisponibilitaUtente`.
		 */
		public List<InfoPartita> applyFilters(List<InfoPartita> lista) {
			return lista.stream()
					.filter(disponibilita -> filtroCentro.isEmpty() || 
							disponibilita.getNomecentro().toLowerCase().contains(filtroCentro.getValue().toLowerCase()))
					.filter(disponibilita -> {
						if (filtroPrezzo.isEmpty()) {
							return true;
						}
						try {
							// Confronta il prezzo se è valido
							BigDecimal prezzoFiltro = new BigDecimal(filtroPrezzo.getValue());
							return disponibilita.getPrezzo().compareTo(prezzoFiltro) == 0;
						} catch (NumberFormatException e) {
							return false; // Ignora se il prezzo inserito non è valido
						}
					})
					.filter(disponibilita -> {
						if (filtroInzioData.isEmpty()) {
							return true; // Se non c'è un filtro, non fare nulla (ritorna true)
						}
						// Solo se filtroInzioData ha un valore valido (LocalDateTime)
						LocalDateTime dataFiltro = filtroInzioData.getValue();
						return dataFiltro != null && !disponibilita.getDataOra().isBefore(dataFiltro);
					})
					.filter(disponibilita -> {
						if (filtroFineData.isEmpty()) {
							return true; // Se non c'è un filtro, non fare nulla (ritorna true)
						}
						// Solo se filtroFineData ha un valore valido (LocalDateTime)
						LocalDateTime dataFiltro = filtroFineData.getValue();
						return dataFiltro != null && !disponibilita.getDataOra().isAfter(dataFiltro);
					})
					.filter(disponibilita -> tipoCampo.isEmpty() || 
							tipoCampo.getValue().contains(disponibilita.getTipoCampo()))
					.toList(); // Ritorna i dati filtrati
		}


	}


	private Component createGrid() {
		grid = new Grid<>(InfoPartita.class, false);
		grid.addColumn("idPartita").setAutoWidth(true).setVisible(false);
		grid.addColumn("nomecentro").setAutoWidth(true).setHeader("Nome Centro");
		grid.addColumn("dataOra").setAutoWidth(true).setHeader("Data e Ora");
		grid.addColumn("tipoCampo").setAutoWidth(true);
		grid.addColumn("postiTotali").setAutoWidth(true).setHeader("Posti disponibili");
		try {
			List<InfoPartita> list = PartitaService.findAllPubbliche();
			grid.setItems(list);
		}catch(NullPointerException ex) {
	        grid.setItems(List.of());
		}
		
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
		grid.addClassNames(LumoUtility.Border.TOP, LumoUtility.BorderColor.CONTRAST_10);

		return grid;
	}

	private void refreshGrid() {
		List<InfoPartita> allDisponibilita = PartitaService.findAllPubbliche(); // Lista originale
		List<InfoPartita> filteredDisponibilita = filters.applyFilters(allDisponibilita); // Applica i filtri
		grid.setItems(filteredDisponibilita); // Aggiorna la griglia
	}

}
