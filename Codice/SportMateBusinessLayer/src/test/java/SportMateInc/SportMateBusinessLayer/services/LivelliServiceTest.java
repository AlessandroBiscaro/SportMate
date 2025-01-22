package SportMateInc.SportMateBusinessLayer.services;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import SportMateInc.SportMateBusinessLayer.entity.Livello;
import java.util.List;

public class LivelliServiceTest {

    @Test
    public void testFindLivelloExistingId() {
        Livello livello = LivelliService.findLivello(1);
        assertNotNull("Il livello con ID 1 dovrebbe esistere", livello);
        assertEquals("Principiante", livello.getNomeLivello());
        assertEquals(1, livello.getIdLivello());
    }

    @Test
    public void testFindLivelloNonExistingId() {
       //Livello non esistente nel database
        Livello livello = null; 
        try {
        	  livello = LivelliService.findLivello(999);
        	  Assert.fail("NullPointerException dovrebbe essere sollevata");
        }
        catch(NullPointerException e) {}
        assertNull("Il livello non dovrebbe essere trovato", livello);
    }

    @Test
    public void testFindAll_ContainsExpectedLevels() {
        List<Livello> livelli = LivelliService.findAll();
        
        assertNotNull("La lista dei livelli non dovrebbe essere null", livelli);
        assertFalse("La lista non dovrebbe essere vuota", livelli.isEmpty());
        
        assertEquals(5, livelli.size());
        assertEquals("Principiante", livelli.get(0).getNomeLivello());
        assertEquals("Esordiente", livelli.get(1).getNomeLivello());
        assertEquals("Dilettante", livelli.get(2).getNomeLivello());
        assertEquals("Esperto", livelli.get(3).getNomeLivello());
        assertEquals("Professionista", livelli.get(4).getNomeLivello());
    }
}
