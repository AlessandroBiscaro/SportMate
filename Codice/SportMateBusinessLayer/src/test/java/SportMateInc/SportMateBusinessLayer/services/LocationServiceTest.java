package SportMateInc.SportMateBusinessLayer.services;
import static org.junit.Assert.*;
import org.junit.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.Location;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.LocationService;
import sportmateinc.sportmatedblayer.SportMateDB;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LocationServiceTest {

    Gestore g1;
    Gestore g2;
    CentroSportivo c1;
    CentroSportivo c2;
    
    @Before
    public void setUp() {
    	BasicConfigurator.configure();
	    Logger.getRootLogger().setLevel(Level.ERROR);
        g1 = new Gestore(0, "testg1@test.com", "Luigi", "Gialli", LocalDate.of(1995, 01, 29), null, "prova123");
        g2 = new Gestore(0, "testg2@test.com", "Maria", "De Franco", LocalDate.of(1995, 11, 04), null, "prova456"); 
        g1.setId(GestoriService.aggiungiGestore(g1));
        g2.setId(GestoriService.aggiungiGestore(g2));
        c1 = new CentroSportivo(0, "Centro Sportivo A", "Via Roma,1,Azzano San Paolo,(BG),Italia" , BigDecimal.valueOf(45.0), BigDecimal.valueOf(32.201), BigDecimal.valueOf(150), "08:00", "19:00", g1.getId());
        c2 = new CentroSportivo(0, "Centro Sportivo B", "Via Roma,1 Milano,(MI),Italia" , BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(100), "10:00", "15:00", g2.getId());
        c1.setIdCentro(CentriSportiviService.aggiungiCentro(c1));
        c2.setIdCentro(CentriSportiviService.aggiungiCentro(c2));
	}

    @After
    public void tearDown() {
    	
       SportMateDB db = SportMateDB.getInstance();
       db.apriConnessione();
       DSLContext dsl = db.getContext();
       dsl.delete(GESTORI).where(GESTORI.IDGESTORE.eq(g1.getId())).execute();
       dsl.delete(GESTORI).where(GESTORI.IDGESTORE.eq(g2.getId())).execute();
       dsl.delete(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(c1.getIdCentro())).execute();
       dsl.delete(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(c2.getIdCentro())).execute();
       db.chiudiConnessione();
    }

    @Test
    public void testFindAllLocations() {
        List<Location> locations = LocationService.findAll();
        assertNotNull(locations);
    }
}

