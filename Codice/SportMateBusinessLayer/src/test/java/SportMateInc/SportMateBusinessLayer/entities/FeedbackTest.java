package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Feedback;
import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Utente;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FeedbackTest {

    private Feedback feedback;
    private Utente mittente;
    private Livello livelloPrincipiante;

    @Before
    public void setUp() {
    	 livelloPrincipiante = new Livello(1, "Principiante");
        
        mittente = new Utente(
            1, 
            "mario@example.com", 
            "Mario", 
            "Rossi", 
            LocalDate.of(1995, 8, 30), 
            "1234567890", 
            "password123", 
            new BigDecimal("50"),
            livelloPrincipiante
            
        );
        
        
        feedback = new Feedback(1, "Feedback positivo", "Ottimo servizio!", 10, mittente);
    }

    
    @Test
    public void testGetIdFeedback() {
        assertEquals(Integer.valueOf(1), feedback.getIdFeedback());
    }

    @Test
    public void testGetOggetto() {
        assertEquals("Feedback positivo", feedback.getOggetto());
    }

    
    @Test(expected = NullPointerException.class)
    public void testSetOggettoNull() {
        feedback.setOggetto(null);
    }

    @Test
    public void testGetTesto() {
        assertEquals("Ottimo servizio!", feedback.getTesto());
    }

    @Test
    public void testGetNumLike() {
        assertEquals(10, feedback.getNumLike());
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testSetNumLikeNegative() {
        feedback.setNumLike(-1);
    }

    @Test
    public void testSetNumLikeValid() {
        feedback.setNumLike(20);
        assertEquals(20, feedback.getNumLike());
    }

    
    @Test
    public void testGetMittente() {
        assertEquals(mittente, feedback.getMittente());
    }

    @Test(expected = NullPointerException.class)
    public void testSetMittenteNull() {
        feedback.setMittente(null);
    }
}
