package sportmateinc.sportmatepresentationlayer.application.views.comuni;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Registrazione")
@Route("registrazione")
@AnonymousAllowed

public class RegistrazioneView extends Composite<VerticalLayout> {

	H1 sportMateH1;
	VerticalLayout verticalLayout;
	H5 tipoRegistrazioneTitolo;
	Button btnUtente;
	Button btnGestore;
	HorizontalLayout layoutRow;

	public RegistrazioneView() {
		getContent().setWidth("100%");
		getContent().getStyle().set("flex-grow", "1");

		setSportMateTitle();
		setVerticalLayout();

		getContent().add(sportMateH1, verticalLayout);
	}

	private void setVerticalLayout() {
		verticalLayout = new VerticalLayout();
		verticalLayout.setWidth("100%");
		verticalLayout.setHeight("min-content");
		verticalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		verticalLayout.setAlignItems(Alignment.CENTER);
		verticalLayout.setWidthFull();
		
		setSubtitle();
		setButtons();
		setLayoutRow();
		
		getContent().setFlexGrow(1.0, verticalLayout);
		verticalLayout.add(tipoRegistrazioneTitolo, layoutRow);
	}
	
	private void setLayoutRow() {
		layoutRow = new HorizontalLayout();
		layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow.setAlignItems(Alignment.START);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutRow.add(btnGestore);
        layoutRow.add(btnUtente);
	}

	private void setSubtitle() {
		tipoRegistrazioneTitolo = new H5();
		tipoRegistrazioneTitolo.setText("Seleziona la tipologia di profilo da creare");
		tipoRegistrazioneTitolo.setWidth("max-content");
	}

	private void setButtons() {
		btnUtente = new Button();
		btnGestore = new Button();
		btnUtente.setText("Utente");
		btnUtente.setWidth("125px");
		btnUtente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnGestore.setText("Gestore");
		btnGestore.setWidth("125px");
		btnGestore.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		btnUtente.addClickListener(e -> UI.getCurrent().getPage().setLocation("/registrazioneUtente"));
		btnGestore.addClickListener(e -> UI.getCurrent().getPage().setLocation("/registrazioneGestore"));
	}

	private void setSportMateTitle() {
		sportMateH1 = new H1();
		sportMateH1.setText("Unisciti a SportMate");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, sportMateH1);
		sportMateH1.setWidth("max-content");
	}
}
