package sportmateinc.sportmatepresentationlayer.application.security;

import com.vaadin.flow.spring.security.AuthenticationContext;

import sportmateinc.sportmatebusinesslayer.entity.AuthenticatedProfile;
import sportmateinc.sportmatebusinesslayer.services.AuthenticatedProfileService;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AuthenticatedUser {

    private final AuthenticationContext authenticationContext;

    public AuthenticatedUser(AuthenticationContext authenticationContext) {
        this.authenticationContext = authenticationContext;
    }

    @Transactional
    public Optional<AuthenticatedProfile> get() {
    	return authenticationContext.getAuthenticatedUser(UserDetails.class).map(userDetails -> AuthenticatedProfileService.findProfileByUsername(userDetails.getUsername()));
    }

    public void logout() {
        authenticationContext.logout();
    }

}
