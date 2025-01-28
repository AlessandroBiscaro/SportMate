package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatedblayer.SportMateDB;

public class UtentiServiceTest {

	private Utente testUtente;
	private SportMateDB db;
	private DSLContext create;

	@Before
	public void setUp() {
		db = SportMateDB.getInstance();
		db.apriConnessione();
		create = db.getContext();

		// Creazione di un livello di test esistente
		Livello livelloBase = LivelliService.findLivello(1);

		// Creazione di un utente di test con valori casuali
		testUtente = new Utente(0, "testuser" + new Random().nextInt(10000) + "@mail.com", "Mario", "Rossi",
				LocalDate.of(1990, 5, 20), "1234567890", "password123", BigDecimal.valueOf(100.0), livelloBase);

		int result = UtentiService.aggiungiUtente(testUtente);
		assertEquals("Inserimento utente fallito", 1, result);

		// Recuperiamo l'utente inserito per ottenere il suo ID
		Record record = create.select().from(UTENTI).where(UTENTI.MAIL.eq(testUtente.getMail())).fetchOne();
		testUtente.setIdUtente(record.get(UTENTI.IDUTENTE));
	}

	@Test
	public void testFindByUsernameExistingUser() {
		Utente foundUser = UtentiService.findByUsername(testUtente.getMail());

		assertNotNull("L'utente non dovrebbe essere null", foundUser);
		assertEquals("L'email non corrisponde", testUtente.getMail(), foundUser.getMail());
		assertEquals("Il nome non corrisponde", testUtente.getNome(), foundUser.getNome());
		assertEquals("Il cognome non corrisponde", testUtente.getCognome(), foundUser.getCognome());
		assertEquals("La data di nascita non corrisponde", testUtente.getDataNascita(), foundUser.getDataNascita());
	}

	@Test
	public void testAggiornaDatiUtente() {
		// Modifica di alcuni dati dell'utente
		testUtente.setNome("Luca");
		testUtente.setCognome("Bianchi");
		testUtente.setTelefono("0987654321");

		int updateResult = UtentiService.aggiornaDatiUtente(testUtente);
		assertEquals("Aggiornamento utente fallito", 1, updateResult);

		// Recuperiamo l'utente aggiornato e verifichiamo i nuovi dati
		Utente updatedUser = UtentiService.findByUsername(testUtente.getMail());
		assertEquals("Il nome aggiornato non corrisponde", "Luca", updatedUser.getNome());
		assertEquals("Il cognome aggiornato non corrisponde", "Bianchi", updatedUser.getCognome());
		assertEquals("Il telefono aggiornato non corrisponde", "0987654321", updatedUser.getTelefono());
	}

	@Test
	public void testFindByUsernameNonExistingUser() {
		Utente foundUser = null;
		try {
			foundUser = UtentiService.findByUsername("nonexistentuser@mail.com");
			fail("NullPointerException dovrebbe essere sollevata!");
		} catch (NullPointerException e) {
		}
		assertNull("L'utente inesistente dovrebbe essere null", foundUser);
	}

	@Test
	public void testFindById() {
		Utente utenteRecuperato = UtentiService.findById(testUtente.getIdUtente());

		// Verifica che l'utente recuperato non sia null
		assertNotNull("Utente non trovato nel database", utenteRecuperato);

		assertEquals("L'ID dell'utente non corrisponde", testUtente.getIdUtente(), utenteRecuperato.getIdUtente());
		assertEquals("La mail dell'utente non corrisponde", testUtente.getMail(), utenteRecuperato.getMail());
		assertEquals("Il nome dell'utente non corrisponde", testUtente.getNome(), utenteRecuperato.getNome());
		assertEquals("Il cognome dell'utente non corrisponde", testUtente.getCognome(), utenteRecuperato.getCognome());
		assertEquals("La data di nascita dell'utente non corrisponde", testUtente.getDataNascita(),
				utenteRecuperato.getDataNascita());
		assertEquals("Il telefono dell'utente non corrisponde", testUtente.getTelefono(),
				utenteRecuperato.getTelefono());
		assertEquals("La password dell'utente non corrisponde", testUtente.getPassword(),
				utenteRecuperato.getPassword());
		assertEquals("Il livello dell'utente non corrisponde", testUtente.getLivello().getIdLivello(),
				utenteRecuperato.getLivello().getIdLivello());
	}

	@Test
	public void testIsCellulareUnique() {
		// Testa il metodo isCellulareUnique con un numero di telefono già esistente
		boolean isUnique = UtentiService.isCellulareUnique("1234567890");
		assertFalse("Il metodo isCellulareUnique ha restituito true per un cellulare già esistente", isUnique);

		// Testa il metodo isCellulareUnique con un numero di telefono non presente nel
		// database
		isUnique = UtentiService.isCellulareUnique("4449876543");
		assertTrue("Il metodo isCellulareUnique ha restituito false per un cellulare unico", isUnique);
	}

	public void testIsMailUnique() {
		// Testa il metodo isCellulareUnique con una mail già esistente
		boolean isUnique = UtentiService.isMailUnique(testUtente.getMail());
		assertFalse("Il metodo isMailUnique ha restituito true per una mail già esistente", isUnique);

		// Testa il metodo isCellulareUnique con un numero di telefono non presente nel
		// database
		isUnique = UtentiService.isCellulareUnique("alessandro.manzoni@testUnique.com");
		assertTrue("Il metodo isMailUnique ha restituito false per una mail unica", isUnique);
	}

	@After
	public void tearDown() {
		// Eliminazione utente di test
		int deleteResult = create.deleteFrom(UTENTI).where(UTENTI.IDUTENTE.eq(testUtente.getIdUtente())).execute();
		assertEquals("Eliminazione utente fallita", 1, deleteResult);

		db.chiudiConnessione();
	}
}
