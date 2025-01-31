package sportmateinc.sportmatepresentationlayer.application.views.utente;

import com.vaadin.flow.theme.lumo.LumoUtility;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import jakarta.annotation.security.RolesAllowed;
import sportmateinc.sportmatebusinesslayer.entities.InfoDisponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.PrenotazioneService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatepresentationlayer.application.services.NotificationDelegator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@PageTitle("MySportmate")
@Route("myprofile")
@RolesAllowed({"USER"})
@Uses(Icon.class)

public class AccountUtenteView extends Composite<VerticalLayout> {
	private static final String TEXTFIELD_WIDTH = "220px";
	private static final String TEXTFIELD_ERROR_MESSAGE = "Campo richiesto";
	private static final String HEIGHT_STYLE = "min-content";
	private static final String TITLE_WIDTH = "max-content";
	private static final String GROW_STYLE = "flex-grow";
	private static final long serialVersionUID = 1L;
	
	Utente utente;
	H1 titoloAccountUtente = new H1();
	VerticalLayout layoutColumn2 = new VerticalLayout();
	H5 titoloDatiPersonali = new H5();
	HorizontalLayout layoutRow = new HorizontalLayout();
	VerticalLayout layoutColumn3 = new VerticalLayout();
	TextField txtNome = new TextField();
	TextField txtMail = new TextField();
	VerticalLayout layoutColumn4 = new VerticalLayout();
	TextField txtCognome = new TextField();
	TextField txtCellulare = new TextField();
	VerticalLayout layoutColumn5 = new VerticalLayout();
	DatePicker dtpDataNascita = new DatePicker();
	ComboBox<Livello> cmbLivello = new ComboBox<>();
	Button btnSalva = new Button();
	H5 titoloCredito = new H5();
	VerticalLayout layoutColumn6 = new VerticalLayout();
	NumberField txtRicarica = new NumberField();
	NumberField txtCredito = new NumberField();
	HorizontalLayout layoutRow2 = new HorizontalLayout();
	HorizontalLayout layoutRow3 = new HorizontalLayout();
	Button btnRicaricaCredito = new Button();
	H5 titoloPartitePrenotate = new H5();
	VerticalLayout layoutColumn7 = new VerticalLayout();
	Grid<InfoDisponibilita> gridPartitePrenotate = new Grid<>(InfoDisponibilita.class, false);

	public AccountUtenteView() {

		getContent().setWidth("100%");
		getContent().getStyle().set(GROW_STYLE, "1");
		getContent().setAlignSelf(FlexComponent.Alignment.CENTER, titoloAccountUtente);
		setTitoloAccountUtente();
		titoloDatiPersonali = setSottotitolo("Dati personali");
		titoloCredito = setSottotitolo("Credito SportMate");
		titoloPartitePrenotate = setSottotitolo("Partite prenotate");
		getUtenteInfo();
		setLayoutColumn2();
		setLayoutRow();
		setLayoutRow2();
		setLayoutColumn3();
		setLayoutRow3();
		setLayoutColumn4();
		setLayoutColumn5();
		setLayoutColumn6();
		setLayoutColumn7();
		setBtnSalva();
		setBtnRicarica();
		setTxtNome();
		setTxtMail();
		setTxtCognome();
		setTxtCellulare();
		setTxtImporto();
		setTxtCredito();
		setDtpDataNascita();
		setCmbLivello();
		setGridPartitePrenotate();
	}

	private void getUtenteInfo() {
		String username = VaadinRequest.getCurrent().getUserPrincipal().getName();
		this.utente = UtentiService.findByUsername(username);
	}

	private void setTitoloAccountUtente() {
		titoloAccountUtente.setText("My SportMate");
		titoloAccountUtente.setWidth(TITLE_WIDTH);
		getContent().add(titoloAccountUtente);
	}
	
	private void setLayoutColumn2() {
		layoutColumn2.setWidthFull();
		getContent().setFlexGrow(1.0, layoutColumn2);
		layoutColumn2.addClassName(Gap.XSMALL);
		layoutColumn2.addClassName(Padding.XSMALL);
		layoutColumn2.setWidth("100%");
		layoutColumn2.getStyle().set(GROW_STYLE, "1");
		layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, titoloDatiPersonali);
		layoutColumn2.setFlexGrow(1.0, layoutRow);
		layoutColumn2.setFlexGrow(1.0, layoutColumn6);
		getContent().add(layoutColumn2);
		layoutColumn2.add(titoloDatiPersonali);
		layoutColumn2.add(layoutRow);
		layoutColumn2.add(titoloCredito);
		layoutColumn2.add(layoutColumn6);
		layoutColumn2.add(titoloPartitePrenotate);
		layoutColumn2.add(layoutColumn7);
		layoutColumn2.setFlexGrow(1.0, layoutColumn7);
	}

	private void setLayoutRow() {
		layoutRow.setWidthFull();
		layoutRow.addClassName(Gap.MEDIUM);
		layoutRow.setWidth("100%");
		layoutRow.setHeight(HEIGHT_STYLE);
		layoutRow.setFlexGrow(1.0, layoutColumn3);
		layoutRow.setFlexGrow(1.0, layoutColumn4);
		layoutRow.setFlexGrow(1.0, layoutColumn5);
		layoutRow.add(layoutColumn4);
		layoutRow.add(layoutColumn3);
		layoutRow.add(layoutColumn5);
		layoutRow2.setWidthFull();
		layoutRow2.add(layoutRow3);
	}

	private void setLayoutRow2() {
		layoutRow2.addClassName(Gap.MEDIUM);
		layoutRow2.setWidth("100%");
		layoutRow2.getStyle().set(GROW_STYLE, "1");
		layoutRow2.setFlexGrow(1.0, layoutRow3);
	}
	
	private void setLayoutColumn3() {
		layoutColumn3.setWidth("100%");
		layoutColumn3.setHeight(HEIGHT_STYLE);
		layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn3.setAlignItems(Alignment.START);
		layoutColumn3.setHeightFull();
		layoutColumn3.add(txtNome);
		layoutColumn3.add(txtMail);
		layoutColumn3.addClassNames(LumoUtility.Padding.MEDIUM);
	}
	
	private void setLayoutRow3() {
		layoutRow3.setHeightFull();
		layoutRow3.addClassName(Gap.MEDIUM);
		layoutRow3.setWidth("100%");
		layoutRow3.getStyle().set(GROW_STYLE, "1");
		HorizontalLayout rowLayout = new HorizontalLayout(txtCredito, txtRicarica);
		rowLayout.setWidthFull();
		rowLayout.setSpacing(true);
		layoutRow3.add(rowLayout);
	}
	
	private void setLayoutColumn4() {
		layoutColumn4.setHeightFull();
		layoutColumn4.setWidth("100%");
		layoutColumn4.setHeight(HEIGHT_STYLE);
		layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn4.setAlignItems(Alignment.START);
		layoutColumn4.add(txtCognome);
		layoutColumn4.add(txtCellulare);
		layoutColumn4.add(btnSalva);
	}
	
	private void setLayoutColumn5() {
		layoutColumn5.setWidth("100%");
		layoutColumn5.setHeight(HEIGHT_STYLE);
		layoutColumn5.setJustifyContentMode(JustifyContentMode.START);
		layoutColumn5.setAlignItems(Alignment.START);
		layoutColumn5.setHeightFull();
		layoutColumn5.add(dtpDataNascita);
		layoutColumn5.add(cmbLivello);
	}
	
	private void setLayoutColumn6() {
		layoutColumn6.setWidthFull();
		layoutColumn6.setWidth("100%");
		layoutColumn6.getStyle().set(GROW_STYLE, "1");
		layoutColumn6.setFlexGrow(1.0, layoutRow2);
		layoutColumn6.add(layoutRow2);
		layoutColumn6.add(btnRicaricaCredito);
	}
	
	private void setLayoutColumn7() {
		layoutColumn7.setWidthFull();
		layoutColumn7.setWidth("100%");
		layoutColumn7.getStyle().set(GROW_STYLE, "1");
		layoutColumn7.add(gridPartitePrenotate);
	}
	
	private void setBtnSalva() {
		btnSalva.setText("Salva");
		btnSalva.setWidth("107px");
		btnSalva.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnSalva.addClickListener(event -> validateAndSave());
	}
	
	private void validateAndSave() {
		NotificationDelegator notification = new NotificationDelegator();
		if(!(txtCognome.isInvalid() && txtNome.isInvalid() && txtCellulare.isInvalid() && dtpDataNascita.isInvalid())) {
			Optional<LocalDate> maybeDataNascita = dtpDataNascita.getOptionalValue();
			utente.setCognome(txtCognome.getValue());
			utente.setNome(txtNome.getValue());
			utente.setTelefono(txtCellulare.getValue());
			if(maybeDataNascita.isPresent()) {
				utente.setDataNascita(maybeDataNascita.get());
			}
			utente.setLivello(cmbLivello.getValue());
			UtentiService.aggiornaDatiUtente(utente);
			notification.showSuccessNotification("Dati modificati correttamente!");
		}
	}
	

	private void setBtnRicarica() {
		NotificationDelegator delegator = new NotificationDelegator();
		btnRicaricaCredito.setText("Ricarica");
		btnRicaricaCredito.setWidth("107px");
		btnRicaricaCredito.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		btnRicaricaCredito.addClickListener(e -> {
			if(!(txtRicarica.isEmpty() && txtRicarica.isInvalid() && txtRicarica.getValue() < 0.0)) {
				UtentiService.ricaricaCredito(utente, txtRicarica.getValue());
				utente.setCredito(BigDecimal.valueOf(txtRicarica.getValue()).add(utente.getCredito()).setScale(2));
				txtCredito.setValue(utente.getCredito().doubleValue());
				delegator.showSuccessNotification("Ricarica eseguita correttamente!");
				txtRicarica.clear();
			}
			
		});
	}
	
	private void setTxtNome() {
		txtNome.setLabel("Nome");
		txtNome.setWidth(TEXTFIELD_WIDTH);
		txtNome.setValue(utente.getNome());
		txtNome.setRequired(true);
		txtNome.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}
	
	private void setTxtMail() {
		txtMail.setLabel("Mail");
		txtMail.setWidth(TEXTFIELD_WIDTH);
		txtMail.setValue(utente.getMail());
		txtMail.setEnabled(false);
	}
	
	private void setTxtCognome() {
		txtCognome.setLabel("Cognome");
		txtCognome.setWidth(TEXTFIELD_WIDTH);
		txtCognome.setValue(utente.getCognome());
		txtCognome.setRequired(true);
		txtCognome.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
	}
	
	private void setTxtCellulare() {
		txtCellulare.setLabel("Telefono");
		txtCellulare.setWidth(TEXTFIELD_WIDTH);
		txtCellulare.setValue(utente.getTelefono());
		txtCellulare.setRequiredIndicatorVisible(true);
		txtCellulare.setAllowedCharPattern("[0-9+-]");
		txtCellulare.setMinLength(5);
		txtCellulare.setMaxLength(18);
		txtCellulare.setErrorMessage("Numero di telefono non valido");
		txtCellulare.addFocusListener(e -> {
			if(!UtentiService.isCellulareUnique(txtCellulare.getValue())) {
				txtCellulare.setErrorMessage("Telefono già registrato");
				txtCellulare.setInvalid(true);
			}
			else {
				txtCellulare.setInvalid(false);
			}
		});
	}
	
	private void setTxtImporto() {
		txtRicarica.setWidth(TEXTFIELD_WIDTH);
		txtRicarica.setLabel("Importo");
		txtRicarica.setRequired(true);
		txtRicarica.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
		Div sportMatePrefix = new Div();
		sportMatePrefix.setText("$M");
		txtRicarica.setPrefixComponent(sportMatePrefix);
	}
	
	private void setDtpDataNascita() {
		dtpDataNascita.setLabel("Data di nascita");
		dtpDataNascita.setWidth(HEIGHT_STYLE);
		dtpDataNascita.setValue(utente.getDataNascita());
		dtpDataNascita.setRequired(true);
		dtpDataNascita.setMax(LocalDate.now());
		dtpDataNascita.setErrorMessage("Data non valida");
	}
	
	private void setCmbLivello() {
		cmbLivello.setLabel("Livello");
		cmbLivello.setWidth(HEIGHT_STYLE);
		cmbLivello.setAllowCustomValue(false);
		cmbLivello.setRequired(true);
		cmbLivello.setErrorMessage(TEXTFIELD_ERROR_MESSAGE);
		setCmbLivelloData(cmbLivello);
		cmbLivello.setValue(utente.getLivello());
	}
	
	
	private H5 setSottotitolo(String testo) {
		H5 titolo = new H5();
		titolo.setText(testo);
		titolo.setWidth(TITLE_WIDTH);
		return titolo;
	}
	
	private void setGridPartitePrenotate() {
		gridPartitePrenotate.setWidth("100%");
		gridPartitePrenotate.getStyle().set(GROW_STYLE, "0");
		setGridPartitePrenotateData(gridPartitePrenotate);
	}
	
	private void setTxtCredito() {
		txtCredito.setWidth(TEXTFIELD_WIDTH);
		txtCredito.setLabel("Credito");
		txtCredito.setValue(utente.getCredito().doubleValue());
		txtCredito.setReadOnly(true);
		Div sportMatePrefix = new Div();
		sportMatePrefix.setText("$M");
		txtCredito.setPrefixComponent(sportMatePrefix);
	}

	private void setCmbLivelloData(ComboBox<Livello> cmbLivello) {
		List<Livello> livelli = LivelliService.findAll();
		cmbLivello.setItems(livelli);
		cmbLivello.setItemLabelGenerator(Livello::getNomeLivello);
	}

	private void setGridPartitePrenotateData(Grid<InfoDisponibilita> grid) {
		grid.addColumn("idDisp").setAutoWidth(true).setVisible(false);
		grid.addColumn("nomecentro").setAutoWidth(true).setHeader("Nome Centro");
		grid.addColumn("dataOra").setAutoWidth(true).setHeader("Data e Ora");
		grid.addColumn("prezzo").setAutoWidth(true);
		grid.addColumn("tipoCampo").setAutoWidth(true);
		List<InfoDisponibilita> list = PrenotazioneService.findByUtente(utente);
		grid.setItems(list);
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
		grid.addClassNames(LumoUtility.Border.TOP, LumoUtility.BorderColor.CONTRAST_10);
	}
	
}
