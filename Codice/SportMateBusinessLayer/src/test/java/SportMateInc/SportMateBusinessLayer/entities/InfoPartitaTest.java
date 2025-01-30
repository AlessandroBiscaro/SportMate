package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.InfoPartita;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class InfoPartitaTest {

    private InfoPartita infoPartita;
    private LocalDateTime dataOra;
    private BigDecimal prezzo;

    @Before
    public void setUp() {
        dataOra = LocalDateTime.of(2025, 1, 30, 15, 30);
        prezzo = new BigDecimal("20.50"); 
        infoPartita = new InfoPartita(1, "Centro Sportivo Roma", dataOra, "Sintetico", prezzo, 100);
    }

    
    @Test
    public void testGetDataOra() {
        assertEquals(dataOra, infoPartita.getDataOra());
    }

    @Test
    public void testGetPrezzo() {
        assertEquals(prezzo, infoPartita.getPrezzo());
    }

    
    @Test
    public void testGetTipoCampo() {
        assertEquals("Sintetico", infoPartita.getTipoCampo());
    }

    
    @Test
    public void testGetNomecentro() {
        assertEquals("Centro Sportivo Roma", infoPartita.getNomecentro());
    }

    
    @Test
    public void testGetIdPartita() {
        assertEquals(1, infoPartita.getIdPartita());
    }

    @Test
    public void testGetPostiTotali() {
        assertEquals(100, infoPartita.getPostiTotali());
    }

    @Test
    public void testSetDataOra() {
        LocalDateTime newDataOra = LocalDateTime.of(2025, 2, 10, 18, 00);
        infoPartita.setDataOra(newDataOra);
        assertEquals(newDataOra, infoPartita.getDataOra());
    }

    @Test
    public void testSetPrezzo() {
        BigDecimal newPrezzo = new BigDecimal("25.00");
        infoPartita.setPrezzo(newPrezzo);
        assertEquals(newPrezzo, infoPartita.getPrezzo());
    }

    
    @Test
    public void testSetTipoCampo() {
        infoPartita.setTipoCampo("Erba");
        assertEquals("Erba", infoPartita.getTipoCampo());
    }

    
    @Test
    public void testSetNomecentro() {
        infoPartita.setNomecentro("Centro Sportivo Milano");
        assertEquals("Centro Sportivo Milano", infoPartita.getNomecentro());
    }

    
    @Test
    public void testSetIdPartita() {
        infoPartita.setIdPartita(2);
        assertEquals(2, infoPartita.getIdPartita());
    }

    
    @Test
    public void testSetPostiTotali() {
        infoPartita.setPostiTotali(200);
        assertEquals(200, infoPartita.getPostiTotali());
    }
}
