package SportMateInc.SportMateBusinessLayer.entities;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;

import static org.junit.Assert.*;
import java.math.BigDecimal;

public class CentroSportivoTest {

    private CentroSportivo centroSportivo;

    
    @Before
    public void setUp() {
        
        centroSportivo = new CentroSportivo(
            1, 
            "Centro Sportivo Esempio", 
            "Via Roma 123", 
            new BigDecimal("41.9028"),
            new BigDecimal("12.4964"),
            new BigDecimal("1000.00"), 
            "08:00", 
            "22:00", 
            101 
        );
    }

    
    @Test
    public void testGetIdCentro() {
        assertEquals(1, centroSportivo.getIdCentro());
    }

    
    @Test
    public void testGetNomeComm() {
        assertEquals("Centro Sportivo Esempio", centroSportivo.getNomeComm());
    }

    
    @Test
    public void testGetIndirizzo() {
        assertEquals("Via Roma 123", centroSportivo.getIndirizzo());
    }

    
    @Test
    public void testGetLatitudine() {
        assertEquals(new BigDecimal("41.9028"), centroSportivo.getLatitudine());
    }

    
    @Test
    public void testGetLongitudine() {
        assertEquals(new BigDecimal("12.4964"), centroSportivo.getLongitudine());
    }

    
    @Test
    public void testGetCredito() {
        assertEquals(new BigDecimal("1000.00"), centroSportivo.getCredito());
    }

    @Test
    public void testGetOrarioApertura() {
        assertEquals("08:00", centroSportivo.getOrarioApertura());
    }

    @Test
    public void testGetOrarioChiusura() {
        assertEquals("22:00", centroSportivo.getOrarioChiusura());
    }

    @Test
    public void testGetIdGestore() {
        assertEquals(101, centroSportivo.getIdGestore());
    }

    @Test
    public void testSetNomeComm() {
        centroSportivo.setNomeComm("Centro Sportivo Nuovo");
        assertEquals("Centro Sportivo Nuovo", centroSportivo.getNomeComm());
    }

    @Test
    public void testSetIndirizzo() {
        centroSportivo.setIndirizzo("Via Milano 456");
        assertEquals("Via Milano 456", centroSportivo.getIndirizzo());
    }

    @Test
    public void testSetLatitudine() {
        centroSportivo.setLatitudine(new BigDecimal("40.7128"));
        assertEquals(new BigDecimal("40.7128"), centroSportivo.getLatitudine());
    }

    @Test
    public void testSetLongitudine() {
        centroSportivo.setLongitudine(new BigDecimal("74.0060"));
        assertEquals(new BigDecimal("74.0060"), centroSportivo.getLongitudine());
    }

    @Test
    public void testSetCredito() {
        centroSportivo.setCredito(new BigDecimal("2000.00"));
        assertEquals(new BigDecimal("2000.00"), centroSportivo.getCredito());
    }

    
    @Test
    public void testSetOrarioApertura() {
        centroSportivo.setOrarioApertura("07:00");
        assertEquals("07:00", centroSportivo.getOrarioApertura());
    }

    @Test
    public void testSetOrarioChiusura() {
        centroSportivo.setOrarioChiusura("23:00");
        assertEquals("23:00", centroSportivo.getOrarioChiusura());
    }

    @Test
    public void testSetIdGestore() {
        centroSportivo.setIdGestore(102);
        assertEquals(102, centroSportivo.getIdGestore());
    }
}
