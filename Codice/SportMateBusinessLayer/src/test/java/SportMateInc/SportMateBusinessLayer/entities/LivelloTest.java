package SportMateInc.SportMateBusinessLayer.entities;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Livello;

public class LivelloTest {
    
    @Test
    public void testGetIdLivello() {
        Livello livello = new Livello(1, "Principiante");
        assertEquals(1, livello.getIdLivello());
    }
    
    @Test
    public void testGetNomeLivello() {
        Livello livello = new Livello(2, "Esordiente");
        assertEquals("Esordiente", livello.getNomeLivello());
    }
}