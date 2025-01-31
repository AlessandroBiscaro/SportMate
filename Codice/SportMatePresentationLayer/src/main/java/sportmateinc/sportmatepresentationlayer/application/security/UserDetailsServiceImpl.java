package sportmateinc.sportmatepresentationlayer.application.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sportmateinc.sportmatebusinesslayer.entities.AuthenticatedProfile;
import sportmateinc.sportmatebusinesslayer.services.AuthenticatedProfileService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	AuthenticatedProfile user = AuthenticatedProfileService.findUserByUsername(username);
        if (user == null) {
        	user = AuthenticatedProfileService.findManagerByUsername(username);
        	if(user == null) {
        		 throw new UsernameNotFoundException("No user present with username: " + username);
        	}
        	else {
        		return User.withUsername(user.getUsername())
                		.password("{noop}" + user.getPassword())
                		.roles("ADMIN")
                		.build();
        	}
        } else {
        	return User.withUsername(user.getUsername())
            		.password("{noop}" + user.getPassword())
            		.roles("USER")
            		.build();      
    	}
    }
}
