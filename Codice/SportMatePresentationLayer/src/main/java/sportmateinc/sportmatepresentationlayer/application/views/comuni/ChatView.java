package sportmateinc.sportmatepresentationlayer.application.views.comuni;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;

import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Chat")
@Route("chat")
@Menu(order = 13, icon = LineAwesomeIconUrl.COMMENTS)
@PermitAll

public class ChatView extends HorizontalLayout {

	private static final long serialVersionUID = 1L;

	public ChatView() {
    	UI.getCurrent().getPage().setLocation("/empty");
    }
    
}
