package SportMateInc.SportMateBusinessLayer.services;


import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;

import java.time.LocalDate;
import java.util.List;

import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.Location;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.LocationService;
import sportmateinc.sportmatedblayer.SportMateDB;

public class LocationServiceTest {
	
	private int testGestoreId;
	private DSLContext create;
	private SportMateDB db ;
	@Before
	public void setUp() {
		// Aggiunta di dati di test nel database
		db = SportMateDB.getInstance();
		
		
		

		Gestore testGestore = new Gestore(
				0, "lorenzo.freddi@example.com", "Lorenzo", "Freddi", 
				LocalDate.of(1985, 07, 20), "4325890900", "password086"
				);

		
		testGestoreId = GestoriService.aggiungiGestore(testGestore);

		db.apriConnessione();
		try {
			db.getConnectionDetails().createStatement().executeUpdate(
					"INSERT INTO CENTRISPORTIVI (IDCENTRO, NOMECOMMERCIALE, INDIRIZZO, LATITUDINE, LONGITUDINE, CREDITO, ORARIOAPERTURA, ORARIOCHIUSURA, IDGESTORE) " +
							"VALUES (999, 'Centro Test', 'Via Colombera,1,Mozzo,(BG),Italia', 45.4642, 9.1900, 2, '08:00', '12:00', " + testGestoreId + " )"
					);
		} catch (Exception e) {
			fail("Errore nell'inserimento dei dati di test: " + e.getMessage());
		} finally {
			db.chiudiConnessione();
		}
	}

	@After
	public void tearDown() {
		// Rimozione dei dati di test
		db.apriConnessione();
		create = db.getContext();
		try {
			db.getConnectionDetails().createStatement().executeUpdate(
					"DELETE FROM CENTRISPORTIVI WHERE IDCENTRO = 999"
					);
			create.deleteFrom(GESTORI).where(GESTORI.IDGESTORE.eq(testGestoreId)).execute();

		} catch (Exception e) {
			fail("Errore nella rimozione dei dati di test: " + e.getMessage());
		} finally {
			db.chiudiConnessione();
		}
	}

	@Test
	public void testFindAll() {
		List<Location> locations = LocationService.findAll();
		assertNotNull("La lista delle location non deve essere nulla", locations);
		assertFalse("La lista delle location non deve essere vuota", locations.isEmpty());

		boolean found = false;
		for (Location loc : locations) {
			if (loc.getId() == 999) {
				found = true;
				assertEquals("Il nome del centro deve essere corretto", "Centro Test", loc.getPlace());
				assertEquals("L'indirizzo deve essere corretto", "Via Colombera, 1 Mozzo,(BG) Italia", (loc.getCity()+ "," + loc.getCountry()));
				assertEquals("La latitudine deve essere corretta", 45.4642, loc.getLatitude(), 0.0001);
				assertEquals("La longitudine deve essere corretta", 9.1900, loc.getLongitude(), 0.0001);
				break;
			}
		}

		assertTrue("Il centro di test deve essere presente nei risultati", found);
	}
}

