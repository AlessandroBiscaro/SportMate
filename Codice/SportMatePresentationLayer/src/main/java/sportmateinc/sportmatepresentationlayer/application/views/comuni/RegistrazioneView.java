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
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;

import org.vaadin.lineawesome.LineAwesomeIconUrl;


@PageTitle("Registrazione")
@Route("registrazione")
@AnonymousAllowed
@Menu(order = 1, icon = LineAwesomeIconUrl.USER_EDIT_SOLID)


public class RegistrazioneView extends Composite<VerticalLayout> {

	H1 sportMateH1;
	VerticalLayout verticalLayout;
	H5 tipoRegistrazioneTitolo;
	Button btnUtente;
	Button btnGestore;

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
		
		getContent().setFlexGrow(1.0, verticalLayout);
		verticalLayout.add(tipoRegistrazioneTitolo);
		verticalLayout.add(btnUtente);
		verticalLayout.add(btnGestore);
	}

	private void setSubtitle() {
		tipoRegistrazioneTitolo = new H5();
		tipoRegistrazioneTitolo.setText("Seleziona tipologia di registrazione:");
		tipoRegistrazioneTitolo.setWidth("max-content");
	}

	private void setButtons() {
		btnUtente = new Button();
		btnGestore = new Button();
		btnUtente.setText("Utente");
		btnUtente.setWidth("max-content");
		btnUtente.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnGestore.setText("Gestore");
		btnGestore.setWidth("max-content");
		btnGestore.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		
		btnUtente.addClickListener(e -> UI.getCurrent().getPage().setLocation("/regitrazioneUtente"));
		btnGestore.addClickListener(e -> UI.getCurrent().getPage().setLocation("/regitrazioneGestore"));
	}

	private void setSportMateTitle() {
		sportMateH1 = new H1();
		sportMateH1.setText("SportMate");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, sportMateH1);
		sportMateH1.setWidth("max-content");
	}
}
