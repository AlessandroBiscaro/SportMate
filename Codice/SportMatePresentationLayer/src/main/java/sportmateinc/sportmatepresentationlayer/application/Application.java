package sportmateinc.sportmatepresentationlayer.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Theme(value = "sportmatepresentationlayer")
@PWA(name = "SportMate", shortName = "SportMate", offlinePath = "offline.html", offlineResources = {"images/offline.png"})
public class Application implements AppShellConfigurator {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
