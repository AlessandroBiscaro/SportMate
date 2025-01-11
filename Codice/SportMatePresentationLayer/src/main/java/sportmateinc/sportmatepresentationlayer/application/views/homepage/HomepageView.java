package sportmateinc.sportmatepresentationlayer.application.views.homepage;

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
	 HorizontalLayout layoutRow = new HorizontalLayout();
     H1 titoloHomePage;
     HorizontalLayout layoutRow2 = new HorizontalLayout();
     VerticalLayout layoutColumn2 = new VerticalLayout();
     Paragraph textSmall = new Paragraph();
     HorizontalLayout layoutRow3 = new HorizontalLayout();
     Button btnCalcio5 = new Button();
     Button btnCalcio7 = new Button();
     Button btnBasket3v3 = new Button();
     MessageList messageList = new MessageList();
     Button btnFeedback = new Button();
     HorizontalLayout layoutRow4 = new HorizontalLayout();

    public HomepageView() {
        getContent().addClassName(Gap.XSMALL);
        getContent().addClassName(Padding.XSMALL);
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        messageList.setWidth("100%");
        setMessageListSampleData(messageList);
        setTitolo();
        setLayoutRow();
        setLayoutRow2();
        setLayoutColumn2();
        setLayoutRow3();
        setBtnCalcio5();
        setBtnCalcio7();
        setBtnBasket3v3();
        setBtnFeedback();
        setLayoutRow4();
        
    }
    
    private void setTitolo() {
    	 titoloHomePage = new H1();
    	 titoloHomePage.setText("SportMate");
         titoloHomePage.setWidth("max-content");
         titoloHomePage.setHeight("80px");
    }
    
    private void setLayoutRow() {
    	layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        layoutRow.setAlignItems(Alignment.CENTER);
        layoutRow.setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().add(layoutRow);
        layoutRow.add(titoloHomePage);
    }
    
    private void setLayoutRow2() {
    	layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        layoutRow2.setAlignItems(Alignment.CENTER);
        layoutRow2.setJustifyContentMode(JustifyContentMode.CENTER);
        getContent().add(layoutRow2);
        layoutRow2.add(layoutColumn2);
    }
    
    private void setLayoutColumn2() {
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
         layoutColumn2.setFlexGrow(1.0, layoutRow3);
         layoutColumn2.setAlignSelf(FlexComponent.Alignment.START, messageList);
         layoutColumn2.setAlignSelf(FlexComponent.Alignment.END, btnFeedback);
         layoutColumn2.add(textSmall);
         layoutColumn2.add(layoutRow3);
         layoutColumn2.add(messageList);
         layoutColumn2.add(btnFeedback);
    }
    
    private void setLayoutRow3() {
    	layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        layoutRow3.setAlignItems(Alignment.START);
        layoutRow3.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutRow3.add(btnCalcio5);
        layoutRow3.add(btnCalcio7);
        layoutRow3.add(btnBasket3v3);
    }
    
    private void setBtnCalcio5() {
    	 btnCalcio5.setText("Calcio a 5");
         btnCalcio5.setWidth("127px");
         btnCalcio5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    private void setBtnCalcio7() {
    	 btnCalcio7.setText("Calcio a 7");
         btnCalcio7.setWidth("127px");
         btnCalcio7.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
    
    private void setBtnBasket3v3() {
    	btnBasket3v3.setText("Basket 3v3");
        btnBasket3v3.setWidth("min-content");
        btnBasket3v3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
    
    private void setBtnFeedback() {
    	 btnFeedback.setText("Feedback");
         btnFeedback.setWidth("min-content");
         btnFeedback.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }
    
    private void setLayoutRow4() {
    	 layoutRow4.addClassName(Gap.MEDIUM);
         layoutRow4.setWidth("100%");
         layoutRow4.setHeight("min-content");     
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
