package sportmateinc.sportmatepresentationlayer.application.security;

import java.util.List;
import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.jooq.Record;

import SportMateInc.SportMateBusinessLayer.GestoriService;
import SportMateInc.SportMateBusinessLayer.UtentiService;
import sportmateinc.sportmatebusinesslayer.generated.tables.Gestori;
import sportmateinc.sportmatebusinesslayer.generated.tables.Utenti;

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
        		return new org.springframework.security.core.userdetails.User(user.field(Gestori.GESTORI.MAIL).toString(), user.field(Gestori.GESTORI.PASSWORD).toString(),
                        getAuthorities(user, "GESTORE"));
        	}
        } else {
            return new org.springframework.security.core.userdetails.User(user.field(Utenti.UTENTI.MAIL).toString(), user.field(Utenti.UTENTI.PASSWORD).toString(),
                    getAuthorities(user, "UTENTE"));
        }
    }

    private static List<GrantedAuthority> getAuthorities(Record user, String role) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + role));
        }
    }
