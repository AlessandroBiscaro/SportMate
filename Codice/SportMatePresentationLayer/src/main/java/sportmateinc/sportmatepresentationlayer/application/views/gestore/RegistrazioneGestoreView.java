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

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

import java.util.ArrayList;
import java.util.List;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Registrazione Gestore")
@Route("registrazioneGestore")
@AnonymousAllowed
public class RegistrazioneGestoreView extends Composite<VerticalLayout> {

    public RegistrazioneGestoreView() {
        H1 h1 = new H1();
        H5 h5 = new H5();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        TextField textField = new TextField();
        DatePicker datePicker = new DatePicker();
        EmailField emailField = new EmailField();
        TextField textField2 = new TextField();
        MultiSelectComboBox multiSelectComboBox = new MultiSelectComboBox();
        TimePicker timePicker = new TimePicker();
        MultiSelectComboBox multiSelectComboBox2 = new MultiSelectComboBox();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordField2 = new PasswordField();
        TextField textField5 = new TextField();
        TimePicker timePicker2 = new TimePicker();
        TextField textField6 = new TextField();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        Button buttonPrimary = new Button();
        ProgressBar progressBar = new ProgressBar();
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
        textField.setLabel("Nome:");
        textField.setWidth("192px");
        datePicker.setLabel("Data di nascita:");
        datePicker.setWidth("min-content");
        emailField.setLabel("Email:");
        emailField.setWidth("192px");
        textField2.setLabel("Nome commerciale:");
        textField2.setWidth("192px");
        multiSelectComboBox.setLabel("Tipologie campi:");
        multiSelectComboBox.setWidth("min-content");
        setMultiSelectComboBoxSampleData(multiSelectComboBox);
        timePicker.setLabel("Orario di apertura:");
        timePicker.setWidth("min-content");
        multiSelectComboBox2.setLabel("Servizi aggiuntivi:");
        multiSelectComboBox2.setWidth("min-content");
        setMultiSelectComboBoxSampleData(multiSelectComboBox2);
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
        textField3.setLabel("Cognome:");
        textField3.setWidth("192px");
        textField4.setLabel("Cellulare:");
        textField4.setWidth("192px");
        passwordField.setLabel("Password:");
        passwordField.setWidth("192px");
        passwordField2.setLabel("Conferma password:");
        passwordField2.setWidth("192px");
        textField5.setLabel("Indirizzo:");
        textField5.setWidth("192px");
        timePicker2.setLabel("Orario di chiusura:");
        timePicker2.setWidth("min-content");
        textField6.setLabel("Altro:");
        textField6.setWidth("192px");
        layoutColumn6.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("135px");
        layoutColumn6.setHeight("528px");
        buttonPrimary.setText("Registrati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        progressBar.setValue(0.5);
        progressBar.setHeight("15px");
        getContent().add(h1);
        getContent().add(h5);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(textField);
        layoutColumn2.add(datePicker);
        layoutColumn2.add(emailField);
        layoutColumn2.add(textField2);
        layoutColumn2.add(multiSelectComboBox);
        layoutColumn2.add(timePicker);
        layoutColumn2.add(multiSelectComboBox2);
        layoutRow.add(layoutColumn5);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(textField3);
        layoutColumn3.add(textField4);
        layoutColumn3.add(passwordField);
        layoutColumn3.add(passwordField2);
        layoutColumn3.add(textField5);
        layoutColumn3.add(timePicker2);
        layoutColumn3.add(textField6);
        layoutRow.add(layoutColumn6);
        getContent().add(buttonPrimary);
        getContent().add(progressBar);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setMultiSelectComboBoxSampleData(MultiSelectComboBox multiSelectComboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        multiSelectComboBox.setItems(sampleItems);
        multiSelectComboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
