package sportmateinc.sportmatepresentationlayer.application.security;

import java.util.Arrays;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.services.GestoriService;
import SportMateInc.SportMateBusinessLayer.services.UtentiService;
import SportMateInc.SportMateBusinessLayer.tables.Gestori;
import SportMateInc.SportMateBusinessLayer.tables.Utenti;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Record user = UtentiService.findByUsername(username);
        if (user == null) {
        	user = GestoriService.findByUsername(username);
        	if(user == null) {
        		 throw new UsernameNotFoundException("No user present with username: " + username);
        	}
        	else {
        		return User.withUsername(user.get(Utenti.UTENTI.MAIL))
                		.password("{noop}" + user.get(Utenti.UTENTI.PASSWORD))
                		.roles("USER")
                		.build();
        	}
           
        } else {
        	return User.withUsername(user.get(Gestori.GESTORI.MAIL))
            		.password("{noop}" + user.get(Gestori.GESTORI.PASSWORD))
            		.roles("ADMIN")
            		.build();      
    	}
    }

    private static List<GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + role));
    }

}
