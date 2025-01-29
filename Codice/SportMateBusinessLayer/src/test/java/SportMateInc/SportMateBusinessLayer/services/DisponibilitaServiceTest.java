package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Disponibilita.DISPONIBILITA;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.InfoDisponibilita;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.DisponibilitaService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.TipoCampoService;
import sportmateinc.sportmatedblayer.SportMateDB;

public class DisponibilitaServiceTest {

	private SportMateDB db;
	private DSLContext create;
	private CentroSportivo testCentro;
	private TipoCampo testTipoCampo;
	private Disponibilita testDisponibilita;
	private int idDisponibilita;
	private int testGestoreId;
	private int centroId;

	@Before
	public void setUp() {
		BasicConfigurator.configure();
	    Logger.getRootLogger().setLevel(Level.ERROR);
		db = SportMateDB.getInstance();
		db.apriConnessione();
		create = db.getContext();

		Gestore testGestore = new Gestore(
				0, "lorenzo.freddi@example.com", "Lorenzo", "Freddi", 
				LocalDate.of(1985, 07, 20), "4325890900", "password086"
				);

		
		testGestoreId = GestoriService.aggiungiGestore(testGestore);

		testCentro = new CentroSportivo(0, "Centro Test", "Via Test 123", new BigDecimal("45.4642"),new BigDecimal("9.19"), new BigDecimal("100"), "08:00", "22:00", testGestoreId);
		centroId = CentriSportiviService.aggiungiCentro(testCentro);
		testCentro.setIdCentro(centroId);

		testTipoCampo = TipoCampoService.findTipoCampo(1); 

		testDisponibilita = new Disponibilita(0, LocalDateTime.now().plusDays(1), new BigDecimal("20"), testTipoCampo, testCentro, 0);
		idDisponibilita = DisponibilitaService.aggiungiDisponibilita(testDisponibilita);
	}

	@After
	public void tearDown() {
		
		create.deleteFrom(DISPONIBILITA).where(DISPONIBILITA.IDDISPONIBILITA.eq(idDisponibilita)).execute();
		// Elimina il centro sportivo di test
		create.deleteFrom(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(centroId)).execute();

		// Elimina il gestore di test
		create.deleteFrom(GESTORI).where(GESTORI.IDGESTORE.eq(testGestoreId)).execute();

		db.chiudiConnessione();
	}

	@Test
	public void testAggiungiDisponibilita() {
		assertTrue("L'ID della disponibilità aggiunta deve essere maggiore di 0", idDisponibilita > 0);
		Disponibilita result = DisponibilitaService.findById(idDisponibilita);
		assertNotNull("La disponibilità aggiunta deve essere recuperabile", result);
		assertEquals("Il prezzo della disponibilità deve corrispondere", testDisponibilita.getPrezzo(), result.getPrezzo());
	}

	@Test
	public void testFindById() {
		Disponibilita result = DisponibilitaService.findById(idDisponibilita);
		assertNotNull("La disponibilità cercata deve esistere", result);
		assertEquals("Il prezzo deve essere corretto", testDisponibilita.getPrezzo(), result.getPrezzo());
	}

	@Test
	public void testFindAll() {
		List<Disponibilita> disponibilitaList = DisponibilitaService.findAll();
		assertNotNull("La lista di disponibilità non deve essere nulla", disponibilitaList);
		assertFalse("La lista di disponibilità dovrebbe contenere almeno un elemento", disponibilitaList.isEmpty());
	}

	@Test
	public void testAggiornaDisponibilita() {
		Disponibilita disponibilitaAggiornata = new Disponibilita(
				idDisponibilita, 
				testDisponibilita.getDataOra().plusDays(2),  
				new BigDecimal("25"), 
				testTipoCampo,
				testCentro, 
				1 
				);

		int rowsUpdated = DisponibilitaService.aggiornaDisponibilita(disponibilitaAggiornata);
		assertEquals("Deve essere aggiornata una riga", 1, rowsUpdated);

		Disponibilita result = DisponibilitaService.findById(idDisponibilita);
		assertNotNull("La disponibilità aggiornata deve esistere", result);
		assertEquals("La data deve essere aggiornata", disponibilitaAggiornata.getDataOra(), result.getDataOra());
		assertEquals("Il prezzo deve essere aggiornato", disponibilitaAggiornata.getPrezzo(), result.getPrezzo());
		assertEquals("Lo stato di prenotazione deve essere aggiornato", disponibilitaAggiornata.getPrenotato(), result.getPrenotato());
	}

	@Test
	public void testFindAllUtente() {
		List<InfoDisponibilita> disponibilitaList = DisponibilitaService.findAllUtente();
		assertNotNull("La lista di disponibilità per gli utenti non deve essere nulla", disponibilitaList);
		assertFalse("La lista di disponibilità per gli utenti deve contenere almeno un elemento", disponibilitaList.isEmpty());

		InfoDisponibilita info = disponibilitaList.get(0);
		assertNotNull("Il nome del centro sportivo non deve essere nullo", info.getNomecentro());
		assertNotNull("La data e ora devono essere valorizzate", info.getDataOra());
		assertNotNull("Il nome del campo deve essere valorizzato", info.getTipoCampo());
		assertTrue("Il prezzo deve essere positivo", info.getPrezzo().compareTo(BigDecimal.ZERO) > 0);
	}

	@Test
	public void testFindByGestore() {
		List<Disponibilita> disponibilitaList = DisponibilitaService.findByGestore(testCentro.getIdCentro());
		assertNotNull("La lista di disponibilità per il gestore non deve essere nulla", disponibilitaList);
		assertFalse("Il gestore deve avere almeno una disponibilità", disponibilitaList.isEmpty());

		Disponibilita result = disponibilitaList.get(0);
		assertNotNull("Il tipo di campo deve essere valorizzato", result.getTipoCampo());
		assertNotNull("Il centro sportivo deve essere valorizzato", result.getCentro());
		assertEquals("L'ID del centro deve corrispondere", testCentro.getIdCentro(), result.getCentro().getIdCentro());
	}
}
