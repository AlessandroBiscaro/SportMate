package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.InfoDisponibilita;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class InfoDisponibilitaTest {

    private InfoDisponibilita infoDisponibilita;
    private LocalDateTime dataOra;
    private BigDecimal prezzo;

    @Before
    public void setUp() {
        dataOra = LocalDateTime.of(2025, 1, 30, 15, 30); 
        prezzo = new BigDecimal("20.50");
        infoDisponibilita = new InfoDisponibilita(1, "Centro Sportivo Roma", dataOra, "Sintetico", prezzo);
    }

    @Test
    public void testGetDataOra() {
        assertEquals(dataOra, infoDisponibilita.getDataOra());
    }

    @Test
    public void testGetPrezzo() {
        assertEquals(prezzo, infoDisponibilita.getPrezzo());
    }

    
    @Test
    public void testGetTipoCampo() {
        assertEquals("Sintetico", infoDisponibilita.getTipoCampo());
    }

    
    @Test
    public void testGetNomecentro() {
        assertEquals("Centro Sportivo Roma", infoDisponibilita.getNomecentro());
    }

    
    @Test
    public void testGetIdDisp() {
        assertEquals(1, infoDisponibilita.getIdDisp());
    }

    
    @Test
    public void testSetDataOra() {
        LocalDateTime newDataOra = LocalDateTime.of(2025, 2, 10, 18, 00); // Nuova data
        infoDisponibilita.setDataOra(newDataOra);
        assertEquals(newDataOra, infoDisponibilita.getDataOra());
    }

    
    @Test
    public void testSetPrezzo() {
        BigDecimal newPrezzo = new BigDecimal("25.00");
        infoDisponibilita.setPrezzo(newPrezzo);
        assertEquals(newPrezzo, infoDisponibilita.getPrezzo());
    }

    
    @Test
    public void testSetTipoCampo() {
        infoDisponibilita.setTipoCampo("Erba");
        assertEquals("Erba", infoDisponibilita.getTipoCampo());
    }

    
    @Test
    public void testSetNomecentro() {
        infoDisponibilita.setNomecentro("Centro Sportivo Milano");
        assertEquals("Centro Sportivo Milano", infoDisponibilita.getNomecentro());
    }

    
    @Test
    public void testSetIdDisp() {
        infoDisponibilita.setIdDisp(2);
        assertEquals(2, infoDisponibilita.getIdDisp());
    }
}
