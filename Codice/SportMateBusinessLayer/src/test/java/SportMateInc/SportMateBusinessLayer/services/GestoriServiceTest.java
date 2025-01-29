package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;

import java.time.LocalDate;
import java.util.Random;

import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatedblayer.SportMateDB;

public class GestoriServiceTest {

	private Gestore testGestore;
	private SportMateDB db;
	private DSLContext create;

	@Before
	public void setUp() {
		db = SportMateDB.getInstance();
		db.apriConnessione();
		create = db.getContext();

		testGestore = new Gestore(0, "testadmin" + new Random().nextInt(9999) + "@mail.com", "Giuseppe", "Verdi",
				LocalDate.of(1978, 2, 9), "123456789", "password1234"

		);

		int result = GestoriService.aggiungiGestore(testGestore);
		
		testGestore.setId(result);
	}

	@Test
	public void testFindByUsernameExistingAdmin() {
		Gestore foundAdmin = GestoriService.findByUsername(testGestore.getMail());

		assertNotNull("Il gestore non dovrebbe essere null", foundAdmin);
		assertEquals("L'email non corrisponde", testGestore.getMail(), foundAdmin.getMail());
		assertEquals("Il nome non corrisponde", testGestore.getNome(), foundAdmin.getNome());
		assertEquals("Il cognome non corrisponde", testGestore.getCognome(), foundAdmin.getCognome());
		assertEquals("La data di nascita non corrisponde", testGestore.getDataNascita(), foundAdmin.getDataNascita());
	}

	@Test
	public void testFindByUsernameNonExistingAdmin() {
		Gestore foundAdmin = null;
		try {
			foundAdmin = GestoriService.findByUsername("nonexistentuser@mail.com");
			fail("NullPointerException dovrebbe essere sollevata!");
		} catch (NullPointerException e) {
		}
		assertNull("Il gestore inesistente dovrebbe essere null", foundAdmin);
	}

	@Test
	public void testAggiornaDatiUtente() {
		
		testGestore.setNome("Matteo");
		testGestore.setCognome("Bianchi");
		testGestore.setTelefono("1357908642");
		testGestore.setPassword("SportMate1");

		int updateResult = GestoriService.aggiornaDatiGestore(testGestore);
		assertEquals("Aggiornamento gestore fallito", 1, updateResult);

		
		Gestore updatedAdmin = GestoriService.findByUsername(testGestore.getMail());
		assertEquals("Il nome aggiornato non corrisponde", "Matteo", updatedAdmin.getNome());
		assertEquals("Il cognome aggiornato non corrisponde", "Bianchi", updatedAdmin.getCognome());
		assertEquals("Il telefono aggiornato non corrisponde", "1357908642", updatedAdmin.getTelefono());
		assertEquals("La password aggiornata non corrisponde", "SportMate1", updatedAdmin.getPassword());
	}

	@Test
	public void testAggiungiGestore() {
		Gestore gestoreInserito = GestoriService.findByUsername(testGestore.getMail());
		
		assertNotNull("Il gestore non è stato trovato nel database dopo l'inserimento", gestoreInserito);

		
		assertEquals("Il nome del gestore non corrisponde", testGestore.getNome(), gestoreInserito.getNome());
		assertEquals("Il cognome del gestore non corrisponde", testGestore.getCognome(), gestoreInserito.getCognome());
		assertEquals("La data di nascita del gestore non corrisponde", testGestore.getDataNascita().toString(),
				gestoreInserito.getDataNascita().toString());
		assertEquals("L'email del gestore non corrisponde", testGestore.getMail(), gestoreInserito.getMail());
		assertEquals("Il telefono del gestore non corrisponde", testGestore.getTelefono(),
				gestoreInserito.getTelefono());
		assertEquals("La password del gestore non corrisponde", testGestore.getPassword(),
				gestoreInserito.getPassword());
	}

	@Test
	public void testIsCellulareUnique() {
		
		boolean isUnique = GestoriService.isCellulareUnique("123456789");
		assertFalse("Il metodo isCellulareUnique ha restituito true per un cellulare già esistente", isUnique);

		
		isUnique = GestoriService.isCellulareUnique("4449876543");
		assertTrue("Il metodo isCellulareUnique ha restituito false per un cellulare unico", isUnique);
	}

	public void testIsMailUnique() {

		
		boolean isUnique = GestoriService.isMailUnique(testGestore.getMail());
		assertFalse("Il metodo isMailUnique ha restituito true per una mail già esistente", isUnique);

		
		isUnique = GestoriService.isMailUnique("alessandro.manzoni@testUnique.com");
		assertTrue("Il metodo isMailUnique ha restituito false per una mail unica", isUnique);
	}

	@After
	public void tearDown() {
		
		int deleteResult = create.deleteFrom(GESTORI).where(GESTORI.IDGESTORE.eq(testGestore.getId())).execute();
		assertEquals("Eliminazione gestore fallita", 1, deleteResult);

		db.chiudiConnessione();
	}

}
