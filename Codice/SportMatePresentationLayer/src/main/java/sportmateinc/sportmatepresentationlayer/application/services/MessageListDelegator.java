package sportmateinc.sportmatepresentationlayer.application.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;

import sportmateinc.sportmatebusinesslayer.entity.Feedback;
import sportmateinc.sportmatebusinesslayer.services.FeedbackService;

public class MessageListDelegator {
	
	public void setMessageList(MessageList messageList) {
		   List<Feedback> feedback = FeedbackService.findAll();
		   List<MessageListItem> lista = new ArrayList<>();
		   int colorId = 0;
		   
		   for(Feedback f : feedback) {
			   MessageListItem message = new MessageListItem(f.getTesto(),
					   LocalDateTime.now().minusMinutes(new Random().nextLong(0,2000)).toInstant(ZoneOffset.UTC),
					   f.getMittente().getNome() + " " +  f.getMittente().getCognome());
			   message.setUserColorIndex(colorId++);
			   lista.add(message);
		   }
		   messageList.setItems(lista);
		   
	    }
	
}
