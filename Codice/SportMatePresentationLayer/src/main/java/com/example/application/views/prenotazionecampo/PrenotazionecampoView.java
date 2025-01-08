package com.example.application.views.prenotazionecampo;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Prenotazione campo")
@Route("prenotazione")
@Menu(order = 5, icon = LineAwesomeIconUrl.EDIT)
@AnonymousAllowed
public class PrenotazionecampoView extends Composite<VerticalLayout> {

    public PrenotazionecampoView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        RadioButtonGroup radioGroup = new RadioButtonGroup();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        TextField textField3 = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField textField4 = new TextField();
        ComboBox comboBox = new ComboBox();
        Button buttonPrimary2 = new Button();
        VerticalLayout layoutColumn5 = new VerticalLayout();
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
        radioGroup.setLabel("Seleziona tipologia partita:");
        radioGroup.setWidth("192px");
        radioGroup.setHeight("158px");
        radioGroup.setItems("Order ID", "Product Name", "Customer", "Status");
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        textField.setLabel("Numero di partecipanti:");
        textField.setWidth("192px");
        textField2.setLabel("Tipologia Campo:");
        textField2.setWidth("192px");
        buttonPrimary.setText("Indietro");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.START, buttonPrimary);
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn4.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn4.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        textField3.setLabel("Centro Sportivo");
        textField3.setWidth("192px");
        datePicker.setLabel("Data prenotazione:");
        datePicker.setWidth("min-content");
        textField4.setLabel("Orario prenotazione:");
        textField4.setWidth("192px");
        comboBox.setLabel("Modalità pagamento");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        buttonPrimary2.setText("Procedi");
        layoutColumn4.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary2);
        buttonPrimary2.setWidth("101px");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn5.getStyle().set("flex-grow", "1");
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(h1);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(radioGroup);
        layoutColumn3.add(textField);
        layoutColumn3.add(textField2);
        layoutColumn3.add(buttonPrimary);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(textField3);
        layoutColumn4.add(datePicker);
        layoutColumn4.add(textField4);
        layoutColumn4.add(comboBox);
        layoutColumn4.add(buttonPrimary2);
        layoutRow2.add(layoutColumn5);
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
