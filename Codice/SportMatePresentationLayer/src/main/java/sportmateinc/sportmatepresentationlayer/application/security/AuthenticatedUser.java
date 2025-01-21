package sportmateinc.sportmatepresentationlayer.application.security;

import com.vaadin.flow.spring.security.AuthenticationContext;

import SportMateInc.SportMateBusinessLayer.services.UtentiService;
import sportmateinc.sportmatepresentationlayer.application.data.User;
import sportmateinc.sportmatepresentationlayer.application.data.UserRepository;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthenticatedUser {

	//private final UserRepository userRepository;
    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext) {
        //this.userRepository = userRepository;
        this.authenticationContext = authenticationContext;
    }

    @Transactional
    public Optional<Object> get() {
    	return authenticationContext.getAuthenticatedUser(UserDetails.class).map(userDetails -> UtentiService.findByUsername(userDetails.getUsername()));
    }

    public void logout() {
        authenticationContext.logout();
    }

}
