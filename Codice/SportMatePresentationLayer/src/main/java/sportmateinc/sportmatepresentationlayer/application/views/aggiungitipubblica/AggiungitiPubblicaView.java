package sportmateinc.sportmatepresentationlayer.application.views.aggiungitipubblica;

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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("AggiungitiPubblica")
@Route("aggiungitiPubblica")
@Menu(order = 12, icon = LineAwesomeIconUrl.PLUS_SOLID)
@AnonymousAllowed
public class AggiungitiPubblicaView extends Composite<VerticalLayout> {

    public AggiungitiPubblicaView() {
        H1 h1 = new H1();
        H5 h5 = new H5();
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        ComboBox comboBox = new ComboBox();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        TextField textField3 = new TextField();
        DatePicker datePicker = new DatePicker();
        TimePicker timePicker = new TimePicker();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("SportMate");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h1);
        h1.setWidth("max-content");
        h5.setText("Dati partita:");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, h5);
        h5.setWidth("max-content");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutColumn2.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.END);
        textField.setLabel("Nome organizzatore:");
        textField.setWidth("192px");
        textField2.setLabel("Indirizzo:");
        textField2.setWidth("192px");
        comboBox.setLabel("Numero partecipanti:");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        layoutColumn4.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("55px");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutRow3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutColumn3.setHeightFull();
        layoutRow3.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth("min-content");
        layoutColumn3.getStyle().set("flex-grow", "1");
        textField3.setLabel("Nome centro:");
        textField3.setWidth("192px");
        datePicker.setLabel("Data:");
        datePicker.setWidth("min-content");
        timePicker.setLabel("Ora:");
        timePicker.setWidth("min-content");
        buttonPrimary.setText("Prenotati");
        layoutColumn3.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary);
        buttonPrimary.setWidth("112px");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(h1);
        getContent().add(h5);
        getContent().add(layoutRow);
        layoutRow.add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(textField);
        layoutColumn2.add(textField2);
        layoutColumn2.add(comboBox);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutRow3);
        layoutRow3.add(layoutColumn3);
        layoutColumn3.add(textField3);
        layoutColumn3.add(datePicker);
        layoutColumn3.add(timePicker);
        layoutColumn3.add(buttonPrimary);
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
