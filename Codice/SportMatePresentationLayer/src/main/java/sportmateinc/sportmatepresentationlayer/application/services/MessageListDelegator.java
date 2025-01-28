package sportmateinc.sportmatepresentationlayer.application.services;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;

import sportmateinc.sportmatebusinesslayer.entities.Feedback;
import sportmateinc.sportmatebusinesslayer.services.FeedbackService;

public class MessageListDelegator implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public void setMessageList(MessageList messageList) {
		   List<Feedback> feedback = FeedbackService.findAll();
		   List<MessageListItem> lista = new ArrayList<>();
		   int colorId = 0;
		   Random rnd = new Random(10);
		   for(Feedback f : feedback) {
			   MessageListItem message = new MessageListItem(f.getTesto(),
					   LocalDateTime.now().minusMinutes(rnd.nextLong(0,2000)).toInstant(ZoneOffset.UTC),
					   f.getMittente().getNome() + " " +  f.getMittente().getCognome());
			   message.setUserColorIndex(colorId++);
			   lista.add(message);
		   }
		   messageList.setItems(lista);
		   
	    }
	
}
