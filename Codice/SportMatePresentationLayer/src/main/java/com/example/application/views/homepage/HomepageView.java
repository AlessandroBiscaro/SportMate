package com.example.application.views.homepage;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Homepage")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.HOME_SOLID)
@AnonymousAllowed
public class HomepageView extends Composite<VerticalLayout> {

    public HomepageView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        Paragraph textSmall = new Paragraph();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Button buttonPrimary3 = new Button();
        MessageList messageList = new MessageList();
        Button buttonPrimary4 = new Button();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        getContent().addClassName(Gap.XSMALL);
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        h1.setText("SportMate");
        h1.setWidth("max-content");
        h1.setHeight("80px");
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn2.addClassName(Gap.XSMALL);
        layoutColumn2.addClassName(Padding.SMALL);
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutColumn2.setJustifyContentMode(JustifyContentMode.START);
        layoutColumn2.setAlignItems(Alignment.CENTER);
        textSmall.setText(
                "Benvenuto su SportMate! SportMate rivoluziona il modo di vivere lo sport con un sistema innovativo per la prenotazione di campi sportivi dedicati al calcio a 5, calcio a 7 e basket 3v3. La nostra piattaforma consente di consultare facilmente la disponibilità delle strutture sportive, organizzare partite pubbliche o private e semplificare la ricerca di giocatori, anche all’ultimo minuto. Dimentica le lunghe telefonate per prenotare un campo: con SportMate, tutto è a portata di click, rendendo il tuo sport ancora più accessibile e divertente. Scopri un nuovo modo di giocare!");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.CENTER, textSmall);
        textSmall.setWidth("100%");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutRow3.setAlignItems(Alignment.START);
        layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonPrimary.setText("Calcio a 5");
        buttonPrimary.setWidth("127px");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Calcio a 7");
        buttonPrimary2.setWidth("127px");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("Basket 3v3");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, messageList);
        messageList.setWidth("100%");
        setMessageListSampleData(messageList);
        buttonPrimary4.setText("Feedback");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.END, buttonPrimary4);
        buttonPrimary4.setWidth("min-content");
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.setHeight("min-content");
        getContent().add(layoutRow);
        layoutRow.add(h1);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
        layoutColumn2.add(textSmall);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(buttonPrimary);
        layoutRow3.add(buttonPrimary2);
        layoutRow3.add(buttonPrimary3);
        layoutColumn2.add(messageList);
        layoutColumn2.add(buttonPrimary4);
        getContent().add(layoutRow4);
    }

    private void setMessageListSampleData(MessageList messageList) {
        MessageListItem message1 = new MessageListItem("Nature does not hurry, yet everything gets accomplished.",
                LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), "Matt Mambo");
        message1.setUserColorIndex(1);
        MessageListItem message2 = new MessageListItem(
                "Using your talent, hobby or profession in a way that makes you contribute with something good to this world is truly the way to go.",
                LocalDateTime.now().minusMinutes(55).toInstant(ZoneOffset.UTC), "Linsey Listy");
        message2.setUserColorIndex(2);
        messageList.setItems(message1, message2);
    }
}
