package SportMateInc.SportMateBusinessLayer;
import static org.junit.Assert.*;
import static SportMateInc.SportMateBusinessLayer.tables.Utenti.UTENTI;
import static SportMateInc.SportMateBusinessLayer.tables.Gestori.GESTORI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import SportMateInc.SportMateBusinessLayer.entity.AuthenticatedProfile;
import SportMateInc.SportMateBusinessLayer.services.AuthenticatedProfileService;
import sportmateinc.sportmatedblayer.SportMateDB;

public class AuthenticatedProfileServiceTest {

    private SportMateDB db;

    @Before
    public void setUp() {
        db = SportMateDB.getInstance();
        db.apriConnessione();
        
        // Popolamento del database con dati di test
        db.getContext().insertInto(UTENTI)
            .set(UTENTI.MAIL, "user@test.com")
            .set(UTENTI.NOME, "Test")
            .set(UTENTI.COGNOME, "User")
            .set(UTENTI.DATANASCITA, "1977-01-01")
            .set(UTENTI.TELEFONO, "000000000")
            .set(UTENTI.PASSWORD, "password123")
            .execute();
        
        db.getContext().insertInto(GESTORI)
            .set(GESTORI.MAIL, "manager@test.com")
            .set(GESTORI.NOME, "Test")
            .set(GESTORI.COGNOME, "Manager")
            .set(GESTORI.DATANASCITA, "1977-01-01")
            .set(GESTORI.TELEFONO, "111111111")
            .set(GESTORI.PASSWORD, "managerpass")
            .execute();
    }

    @After
    public void tearDown() {
        // Pulizia dei dati di test
    	db.apriConnessione();
        db.getContext()
            .deleteFrom(UTENTI)
            .where(UTENTI.MAIL.eq("user@test.com"))
            .execute();

        db.getContext()
            .deleteFrom(GESTORI)
            .where(GESTORI.MAIL.eq("manager@test.com"))
            .execute();

        db.chiudiConnessione();
    }

    @Test
    public void testFindUserByUsernameFound() {
        AuthenticatedProfile profile = AuthenticatedProfileService.findUserByUsername("user@test.com");
        
        assertNotNull("Il profilo utente non dovrebbe essere nullo", profile);
        assertEquals("L'email dovrebbe corrispondere", "user@test.com", profile.getUsername());
        assertEquals("Il nome dovrebbe corrispondere", "Test", profile.getNome());
        assertEquals("La password dovrebbe corrispondere", "password123", profile.getPassword());
    }

    @Test
    public void testFindUserByUsernameNotFound() {
        AuthenticatedProfile profile = AuthenticatedProfileService.findUserByUsername("notfound@test.com");
        
        assertNull("Il profilo utente dovrebbe essere nullo per email non esistente", profile);
    }

    @Test
    public void testFindManagerByUsernameFound() {
        AuthenticatedProfile profile = AuthenticatedProfileService.findManagerByUsername("manager@test.com");
        
        assertNotNull("Il profilo del gestore non dovrebbe essere nullo", profile);
        assertEquals("L'email dovrebbe corrispondere", "manager@test.com", profile.getUsername());
        assertEquals("Il nome dovrebbe corrispondere", "Test", profile.getNome());
        assertEquals("La password dovrebbe corrispondere", "managerpass", profile.getPassword());
    }

    @Test
    public void testFindManagerByUsernameNotFound() {
        AuthenticatedProfile profile = AuthenticatedProfileService.findManagerByUsername("notfound@test.com");
        
        assertNull("Il profilo gestore dovrebbe essere nullo per email non esistente", profile);
    }

    @Test
    public void testFindProfileByUsernameUser() {
        AuthenticatedProfile profile = AuthenticatedProfileService.findProfileByUsername("user@test.com");
        
        assertNotNull("Il profilo utente dovrebbe essere trovato", profile);
        assertEquals("L'email dovrebbe corrispondere", "user@test.com", profile.getUsername());
    }

    @Test
    public void testFindProfileByUsernameManager() {
        AuthenticatedProfile profile = AuthenticatedProfileService.findProfileByUsername("manager@test.com");
        
        assertNotNull("Il profilo gestore dovrebbe essere trovato", profile);
        assertEquals("L'email dovrebbe corrispondere", "manager@test.com", profile.getUsername());
    }

    public void testFindProfileByUsernameNotFound() {
    	 AuthenticatedProfile profile = null;
    	try {
    		 profile = AuthenticatedProfileService.findProfileByUsername("notfound@test.com");
    		 fail("NullPointerException dovrebbe essere sollevata");
    	}
    	catch(NullPointerException e) {}
        assertNull("Il profilo non dovrebbe essere trovato per email inesistente", profile);
    }
}
