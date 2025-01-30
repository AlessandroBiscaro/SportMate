package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DisponibilitaTest {

    private Disponibilita disponibilita;
    private TipoCampo tipoCampo;
    private CentroSportivo centroSportivo;
    private TipoCampo tipoCampo2;

    @Before
    public void setUp() {
    	
        tipoCampo = new TipoCampo(2, "Calcio a 7");
    	tipoCampo2 = new TipoCampo(1, "Calcio a 5"); 
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

        disponibilita = new Disponibilita(1, LocalDateTime.of(2025, 1, 30, 10, 0), 
                                          new BigDecimal("30.00"), tipoCampo2, centroSportivo, 0);
    }

    @Test
    public void testGetIdDisp() {
        assertEquals(1, disponibilita.getIdDisp());
    }

    @Test
    public void testSetIdDisp() {
        disponibilita.setIdDisp(2);
        assertEquals(2, disponibilita.getIdDisp());
    }

    @Test
    public void testGetDataOra() {
        assertEquals(LocalDateTime.of(2025, 1, 30, 10, 0), disponibilita.getDataOra());
    }

    @Test
    public void testSetDataOra() {
        LocalDateTime newData = LocalDateTime.of(2025, 2, 15, 12, 0);
        disponibilita.setDataOra(newData);
        assertEquals(newData, disponibilita.getDataOra());
    }

    @Test
    public void testGetPrezzo() {
        assertEquals(new BigDecimal("30.00"), disponibilita.getPrezzo());
    }

    
    @Test
    public void testSetPrezzo() {
        disponibilita.setPrezzo(new BigDecimal("35.00"));
        assertEquals(new BigDecimal("35.00"), disponibilita.getPrezzo());
    }

    
    @Test
    public void testGetTipoCampo() {
        assertEquals(tipoCampo2, disponibilita.getTipoCampo());
    }

    @Test
    public void testSetTipoCampo() {
        disponibilita.setTipoCampo(tipoCampo); 
        assertEquals(tipoCampo, disponibilita.getTipoCampo());
    }

    
    @Test
    public void testGetCentro() {
        assertEquals(centroSportivo, disponibilita.getCentro());
    }

    @Test
    public void testSetCentro() {
        CentroSportivo nuovoCentro = new CentroSportivo(2, "Centro Sportivo Nuovo", "Via Milano 456",new BigDecimal("41.9028"),   
        	    new BigDecimal("14.4964"),  
        	    new BigDecimal("1340.00"),   
        	    "09:00",                     
        	    "21:00",                     
        	    109    );
        disponibilita.setCentro(nuovoCentro);
        assertEquals(nuovoCentro, disponibilita.getCentro());
    }

    
    @Test
    public void testGetPrenotato() {
        assertEquals(0, disponibilita.getPrenotato());
    }

    
    @Test
    public void testSetPrenotato() {
        disponibilita.setPrenotato(1);
        assertEquals(1, disponibilita.getPrenotato());
    }

    
    @Test
    public void testGetPrenotatoBoolean() {
        assertFalse(disponibilita.getPrenotatoBoolean()); 
    }

    
    @Test
    public void testSetPrenotatoBooleanTrue() {
        disponibilita.setPrenotatoBoolean(true);
        assertEquals(1, disponibilita.getPrenotato());
    }

    @Test
    public void testSetPrenotatoBooleanFalse() {
        disponibilita.setPrenotatoBoolean(false);
        assertEquals(0, disponibilita.getPrenotato());
    }
}
