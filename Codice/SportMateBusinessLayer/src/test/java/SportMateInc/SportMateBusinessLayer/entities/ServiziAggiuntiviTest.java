package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.ServiziAggiuntivi;

import static org.junit.Assert.*;

public class ServiziAggiuntiviTest {

    private ServiziAggiuntivi servizio;

    @Before
    public void setUp() {
        servizio = new ServiziAggiuntivi(1, "WiFi gratuito", "Servizio di WiFi ad alta velocità disponibile in tutta la struttura");
    }

    @Test
    public void testGetIdServizio() {
        assertEquals(1, servizio.getIdServizio());
    }

    @Test
    public void testGetNomeServizio() {
        assertEquals("WiFi gratuito", servizio.getNomeServizio());
    }

    @Test
    public void testGetDescrizione() {
        assertEquals("Servizio di WiFi ad alta velocità disponibile in tutta la struttura", servizio.getDescrizione());
    }
}
