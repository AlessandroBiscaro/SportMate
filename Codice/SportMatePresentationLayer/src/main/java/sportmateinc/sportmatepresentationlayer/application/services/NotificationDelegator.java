package sportmateinc.sportmatepresentationlayer.application.services;

import java.time.LocalDate;
import java.util.Optional;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

import SportMateInc.SportMateBusinessLayer.services.UtentiService;

public class NotificationDelegator {
	public  Notification showErrorNotification(String message) {
		Notification notification = Notification.show(message);
		notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		return notification;
	}
	public Notification showSuccessNotification(String message) {
		Notification notification = Notification.show(message);
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		return notification;
	}
}
