package SportMateInc.SportMateBusinessLayer.entities;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Utente;

public class UtenteTest {
    
    private Utente utente;
    private Livello livelloPrincipiante;
    private Livello livelloEsordiente;

    @Before
    public void setUp() {
        
        livelloPrincipiante = new Livello(1, "Principiante");
        livelloEsordiente = new Livello(2, "Esordiente");

        utente = new Utente(1, "test@mail.com", "Mario", "Rossi", LocalDate.of(1990, 5, 20), 
                            "1234567890", "password123", BigDecimal.valueOf(100), livelloPrincipiante);
    }
    
    @Test
    public void testGetCredito() {
        assertEquals(BigDecimal.valueOf(100), utente.getCredito());
    }
    
    @Test
    public void testSetCredito() {
        utente.setCredito(BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(200), utente.getCredito());
    }
    
    @Test
    public void testGetLivello() {
        assertEquals(livelloPrincipiante, utente.getLivello());
    }
    
    @Test
    public void testSetLivello() {
        utente.setLivello(livelloEsordiente);
        assertEquals(livelloEsordiente, utente.getLivello());
    }
}