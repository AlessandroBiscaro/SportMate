package SportMateInc.SportMateBusinessLayer.entities;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.AuthenticatedProfile;

import static org.junit.Assert.*;

public class AuthenticatedProfileTest {

    private AuthenticatedProfile profile;

    @Before
    public void setUp() {
        
        profile = new AuthenticatedProfile("user123", "password123", "Mario Rossi");
    }

   
    @Test
    public void testGetUsername() {
        assertEquals("user123", profile.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", profile.getPassword());
    }

    
    @Test
    public void testGetNome() {
        assertEquals("Mario Rossi", profile.getNome());
    }

}
