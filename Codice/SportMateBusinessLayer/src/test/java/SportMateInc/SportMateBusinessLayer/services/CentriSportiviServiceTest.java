package SportMateInc.SportMateBusinessLayer.services;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatedblayer.SportMateDB;

import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;

public class CentriSportiviServiceTest {

    private SportMateDB db;
    private DSLContext create;
    private int testCentroId;
    private int testGestoreId;

    @Before
    public void setUp()  {
    	BasicConfigurator.configure();
	    Logger.getRootLogger().setLevel(Level.ERROR);
        db = SportMateDB.getInstance();
        db.apriConnessione();
        create = db.getContext();

        
        Gestore testGestore = new Gestore(
            0, "lorenzo.freddi@example.com", "Lorenzo", "Freddi", 
            LocalDate.of(1985, 07, 20), "6478638648", "password086"
        );

       
        testGestoreId = GestoriService.aggiungiGestore(testGestore);
        

       
        CentroSportivo testCentro = new CentroSportivo(
            0, "Sport Center Test", "Via Roma 10", 
            new BigDecimal("45.4642"), new BigDecimal("9.1900"), 
            new BigDecimal("100.00"), "08:00", "22:00", testGestoreId
        );

        
        testCentroId = CentriSportiviService.aggiungiCentro(testCentro);
       
      
    }

    @Test
    public void testFindByIdCentro() {
        CentroSportivo centro = CentriSportiviService.findByIdCentro(testCentroId);
        assertNotNull("Centro sportivo non trovato", centro);
        assertEquals("ID centro non corrisponde", testCentroId, centro.getIdCentro());
        assertEquals("Nome commerciale errato", "Sport Center Test", centro.getNomeComm());
        assertEquals("Indirizzo errato", "Via Roma 10", centro.getIndirizzo());
        assertEquals("Latitudine errata", new BigDecimal("45.4642"), centro.getLatitudine());
        assertEquals("Longitudine errata", new BigDecimal("9.19"), centro.getLongitudine());
        assertEquals("Credito errato", new BigDecimal("100"), centro.getCredito());
        assertEquals("Orario apertura errato", "08:00", centro.getOrarioApertura());
        assertEquals("Orario chiusura errato", "22:00", centro.getOrarioChiusura());
        assertEquals("ID gestore errato", testGestoreId, centro.getIdGestore());
    }

    @Test
    public void testFindByIdGest() {
        CentroSportivo centro = CentriSportiviService.findByIdGest(testGestoreId);
        assertNotNull("Centro sportivo non trovato", centro);
        assertEquals("ID gestore non corrisponde", testGestoreId, centro.getIdGestore());
    }

    @Test
    public void testAggiornaDatiCentro() {
        CentroSportivo centroAggiornato = new CentroSportivo(
            testCentroId, "Nuovo Nome Centro", "Via Milano 20", 
            new BigDecimal("45.5000"), new BigDecimal("9.1800"), 
            new BigDecimal("200.00"), "07:00", "23:00", testGestoreId
        );

        int rowsAffected = CentriSportiviService.aggiornaDatiCentro(centroAggiornato);
        assertEquals("L'aggiornamento non ha modificato alcuna riga", 1, rowsAffected);

        
        CentroSportivo centroRecuperato = CentriSportiviService.findByIdCentro(testCentroId);
        assertEquals("Nome commerciale errato dopo aggiornamento", "Nuovo Nome Centro", centroRecuperato.getNomeComm());
        assertEquals("Indirizzo errato dopo aggiornamento", "Via Milano 20", centroRecuperato.getIndirizzo());
        assertEquals("Latitudine errata dopo aggiornamento", new BigDecimal("45.5"), centroRecuperato.getLatitudine());
        assertEquals("Longitudine errata dopo aggiornamento", new BigDecimal("9.18"), centroRecuperato.getLongitudine());
        assertEquals("Credito errato dopo aggiornamento", new BigDecimal("200"), centroRecuperato.getCredito());
        assertEquals("Orario apertura errato dopo aggiornamento", "07:00", centroRecuperato.getOrarioApertura());
        assertEquals("Orario chiusura errato dopo aggiornamento", "23:00", centroRecuperato.getOrarioChiusura());
        assertEquals("ID gestore errato dopo aggiornamento", testGestoreId, centroRecuperato.getIdGestore());
    }
    
    @After
    public void tearDown() throws Exception {
       
        create.deleteFrom(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(testCentroId)).execute();
        
        
        create.deleteFrom(GESTORI).where(GESTORI.IDGESTORE.eq(testGestoreId)).execute();
        
        db.chiudiConnessione();
    }
}
