package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
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
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility;

import SportMateInc.SportMateBusinessLayer.entity.Disponibilita;
import SportMateInc.SportMateBusinessLayer.entity.DisponibilitaUtente;
import SportMateInc.SportMateBusinessLayer.services.DisponibilitaService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import sportmateinc.sportmatepresentationlayer.application.data.SamplePerson;
import sportmateinc.sportmatepresentationlayer.application.services.SamplePersonService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.jooq.Record4;
import org.jooq.Record6;
import org.jooq.Result;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Partite Private")
@Route("disponibilitaPrivate")
@Menu(order = 2, icon = LineAwesomeIconUrl.CLIPBOARD_LIST_SOLID)
@RolesAllowed({"USER"})

@Uses(Icon.class)
public class DisponibilitàPrivateView extends Div {

	private Grid<DisponibilitaUtente> grid;

	private Filters filters;
	
	public DisponibilitàPrivateView() {
		setSizeFull();
		addClassNames("disponibilità-view");

		filters = new Filters(() -> refreshGrid());
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
			if (filters.getClassNames().contains("visible")) {
				filters.removeClassName("visible");
				mobileIcon.getElement().setAttribute("icon", "lumo:plus");
			} else {
				filters.addClassName("visible");
				mobileIcon.getElement().setAttribute("icon", "lumo:minus");
			}
		});
		return mobileFilters;
	}

	public static class Filters extends Div implements Specification<SamplePerson> {

		private final TextField filtroCentro = new TextField("Centro Sportivo");
		private final TextField filtroPrezzo = new TextField("Prezzo");
		private final DatePicker filtroInzioData = new DatePicker("Data e Ora");
		private final DatePicker filtroFineData = new DatePicker();
		private final CheckboxGroup<String> tipoCampo = new CheckboxGroup<>("Tipologia Campo");

		public Filters(Runnable onSearch) {

			setWidthFull();
			addClassName("filter-layout");
			addClassNames(LumoUtility.Padding.Horizontal.LARGE, LumoUtility.Padding.Vertical.MEDIUM,
					LumoUtility.BoxSizing.BORDER);
			filtroCentro.setPlaceholder("Nome centro sportivo");



			tipoCampo.setItems("Calcio a 5", "Calcio a 7", "Basket 3vs3");
			tipoCampo.addClassName("double-width");

			// Action buttons
			Button resetBtn = new Button("Reset");
			resetBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
			resetBtn.addClickListener(e -> {
				filtroCentro.clear();
				filtroPrezzo.clear();
				filtroInzioData.clear();
				filtroFineData.clear();
				tipoCampo.clear();
				onSearch.run();
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
			filtroInzioData.setPlaceholder("Da");

			filtroFineData.setPlaceholder("A");

			// For screen readers
			filtroInzioData.setAriaLabel("Dalla data");
			filtroFineData.setAriaLabel("Alla data");

			FlexLayout dateRangeComponent = new FlexLayout(filtroInzioData, new Text(" – "), filtroFineData);
			dateRangeComponent.setAlignItems(FlexComponent.Alignment.BASELINE);
			dateRangeComponent.addClassName(LumoUtility.Gap.XSMALL);

			return dateRangeComponent;
		}

		@Override
		public Predicate toPredicate(Root<SamplePerson> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
			List<Predicate> predicates = new ArrayList<>();

			if (!filtroCentro.isEmpty()) {
				String lowerCaseFilter = filtroCentro.getValue().toLowerCase();
				Predicate firstNameMatch = criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")),
						lowerCaseFilter + "%");
				Predicate lastNameMatch = criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")),
						lowerCaseFilter + "%");
				predicates.add(criteriaBuilder.or(firstNameMatch, lastNameMatch));
			}
			if (!filtroPrezzo.isEmpty()) {
				String databaseColumn = "phone";
				String ignore = "- ()";

				String lowerCaseFilter = ignoreCharacters(ignore, filtroPrezzo.getValue().toLowerCase());
				Predicate phoneMatch = criteriaBuilder.like(
						ignoreCharacters(ignore, criteriaBuilder, criteriaBuilder.lower(root.get(databaseColumn))),
						"%" + lowerCaseFilter + "%");
				predicates.add(phoneMatch);

			}
			if (filtroInzioData.getValue() != null) {
				String databaseColumn = "dateOfBirth";
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(databaseColumn),
						criteriaBuilder.literal(filtroInzioData.getValue())));
			}
			if (filtroFineData.getValue() != null) {
				String databaseColumn = "dateOfBirth";
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(criteriaBuilder.literal(filtroFineData.getValue()),
						root.get(databaseColumn)));
			}
			if (!tipoCampo.isEmpty()) {
				String databaseColumn = "role";
				List<Predicate> rolePredicates = new ArrayList<>();
				for (String role : tipoCampo.getValue()) {
					rolePredicates.add(criteriaBuilder.equal(criteriaBuilder.literal(role), root.get(databaseColumn)));
				}
				predicates.add(criteriaBuilder.or(rolePredicates.toArray(Predicate[]::new)));
			}
			return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
		}

		private String ignoreCharacters(String characters, String in) {
			String result = in;
			for (int i = 0; i < characters.length(); i++) {
				result = result.replace("" + characters.charAt(i), "");
			}
			return result;
		}

		private Expression<String> ignoreCharacters(String characters, CriteriaBuilder criteriaBuilder,
				Expression<String> inExpression) {
			Expression<String> expression = inExpression;
			for (int i = 0; i < characters.length(); i++) {
				expression = criteriaBuilder.function("replace", String.class, expression,
						criteriaBuilder.literal(characters.charAt(i)), criteriaBuilder.literal(""));
			}
			return expression;
		}

	}

	private Component createGrid() {
		grid = new Grid<>(DisponibilitaUtente.class, false);
		grid.addColumn("nomecentro").setAutoWidth(true);
		grid.addColumn("dataOra").setAutoWidth(true);
		grid.addColumn("prezzo").setAutoWidth(true);
		grid.addColumn("tipoCampo").setAutoWidth(true);
		List<DisponibilitaUtente> list = DisponibilitaService.findAllUtente();
	
		grid.setItems(list);
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
		grid.addClassNames(LumoUtility.Border.TOP, LumoUtility.BorderColor.CONTRAST_10);

		return grid;
	}

	private void refreshGrid() {
		grid.getDataProvider().refreshAll();
	}

}
