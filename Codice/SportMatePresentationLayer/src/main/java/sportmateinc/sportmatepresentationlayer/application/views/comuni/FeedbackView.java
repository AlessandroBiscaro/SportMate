package sportmateinc.sportmatepresentationlayer.application.views.comuni;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import sportmateinc.sportmatepresentationlayer.application.services.MessageListDelegator;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Feedback")
@Route("feedback")
@Menu(order = 14, icon = LineAwesomeIconUrl.LIST_SOLID)
@AnonymousAllowed
public class FeedbackView extends Div implements AfterNavigationObserver {
	
	private static final long serialVersionUID = 1L;
	H1 title = new H1();
	MessageList messageList = new MessageList();
	MessageListDelegator delegator = new MessageListDelegator();
	private VerticalLayout verticalLayout = new VerticalLayout();
	
    public FeedbackView() {
        addClassName("feedback-view");
        setSizeFull();
        setVerticalLayout(verticalLayout);
        add(verticalLayout);
    }
    
    private void setVerticalLayout(VerticalLayout verticalLayout) {
		verticalLayout.setWidth("100%");
		verticalLayout.setHeight("min-content");
		verticalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
		verticalLayout.setAlignItems(Alignment.CENTER);
		verticalLayout.setWidthFull();
		setSportMateTitle(title);
		setMessageList(messageList);
		verticalLayout.add(title, messageList);
    }
    
	private void setSportMateTitle(H1 title) {
		title.setText("Feedback");
		title.setWidth("max-content");
	}
	
	private void setMessageList(MessageList messageList) {
		messageList.setWidth("100%");
        setMessageListDelegating(messageList);
	}

	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		delegator.setMessageList(messageList);
	}
	
	public void setMessageListDelegating(MessageList messageList) {
		delegator.setMessageList(messageList);
	}

}
