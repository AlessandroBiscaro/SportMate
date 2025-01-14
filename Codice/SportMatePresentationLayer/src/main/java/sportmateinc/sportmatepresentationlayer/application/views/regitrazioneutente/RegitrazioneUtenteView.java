package sportmateinc.sportmatepresentationlayer.application.views.regitrazioneutente;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Regitrazione Utente")
@Route("regitrazioneUtente")
@Menu(order = 2, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@AnonymousAllowed
public class RegitrazioneUtenteView extends Composite<VerticalLayout> {

    public RegitrazioneUtenteView() {
        H1 h1 = new H1();
        H5 h5 = new H5();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        TextField textField = new TextField();
        DatePicker datePicker = new DatePicker();
        EmailField emailField = new EmailField();
        ComboBox comboBox = new ComboBox();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField passwordField2 = new PasswordField();
        VerticalLayout layoutColumn7 = new VerticalLayout();
        Button buttonPrimary = new Button();
        ProgressBar progressBar = new ProgressBar();
        getContent().setWidth("100%");
        getContent().setHeight("min-content");
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
        layoutRow.setHeight("360px");
        layoutColumn5.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setWidth("135px");
        layoutColumn5.setHeight("100%");
        layoutColumn2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.XSMALL);
        layoutColumn2.setWidth("360px");
        layoutColumn2.setHeight("450px");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.END);
        textField.setLabel("Nome:");
        textField.setWidth("192px");
        datePicker.setLabel("Data di nascita:");
        datePicker.setWidth("min-content");
        emailField.setLabel("Email:");
        emailField.setWidth("192px");
        comboBox.setLabel("Livello giocatore:");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        layoutColumn3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.addClassName(Gap.XSMALL);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutColumn3.setWidth("55px");
        layoutColumn3.setHeight("100%");
        layoutColumn3.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn3.setAlignItems(Alignment.CENTER);
        layoutColumn6.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.setWidth("100%");
        layoutColumn6.setHeight("360px");
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.addClassName(Gap.XSMALL);
        layoutColumn4.addClassName(Padding.XSMALL);
        layoutColumn4.setWidth("360px");
        layoutColumn4.setHeight("450px");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.START);
        textField2.setLabel("Cognome:");
        textField2.setWidth("192px");
        textField3.setLabel("Cellulare:");
        textField3.setWidth("192px");
        passwordField.setLabel("Password:");
        passwordField.setWidth("192px");
        passwordField2.setLabel("Conferma password:");
        passwordField2.setWidth("192px");
        layoutColumn7.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.setWidth("135px");
        layoutColumn7.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Registrati");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        progressBar.setValue(0.5);
        progressBar.setWidth("100%");
        progressBar.setHeight("15px");
        getContent().add(h1);
        getContent().add(h5);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn5);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(textField);
        layoutColumn2.add(datePicker);
        layoutColumn2.add(emailField);
        layoutColumn2.add(comboBox);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(layoutColumn6);
        layoutRow.add(layoutColumn4);
        layoutColumn4.add(textField2);
        layoutColumn4.add(textField3);
        layoutColumn4.add(passwordField);
        layoutColumn4.add(passwordField2);
        layoutRow.add(layoutColumn7);
        getContent().add(buttonPrimary);
        getContent().add(progressBar);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("first", "First", null));
        sampleItems.add(new SampleItem("second", "Second", null));
        sampleItems.add(new SampleItem("third", "Third", Boolean.TRUE));
        sampleItems.add(new SampleItem("fourth", "Fourth", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
