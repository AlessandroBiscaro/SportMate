package sportmateinc.sportmatepresentationlayer.application.views.comuni;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.messages.MessageList;
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

	MessageList messageList = new MessageList();
	MessageListDelegator delegator = new MessageListDelegator();
	
    public FeedbackView() {
        addClassName("feedback-view");
        setSizeFull();
        messageList.setWidth("100%");
        setMessageListDelegating(messageList);
        add(messageList);
    }
    
	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		delegator.setMessageList(messageList);
	}
	
	public void setMessageListDelegating(MessageList messageList) {
		delegator.setMessageList(messageList);
	}

}
