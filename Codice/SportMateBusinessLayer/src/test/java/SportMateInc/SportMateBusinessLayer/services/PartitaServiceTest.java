package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Disponibilita.DISPONIBILITA;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Partite.PARTITE;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;

import org.junit.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Partita;
import sportmateinc.sportmatebusinesslayer.entities.InfoPartita;
import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.services.PartitaService;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.TipoCampoService;
import sportmateinc.sportmatebusinesslayer.services.DisponibilitaService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatedblayer.SportMateDB;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;

public class PartitaServiceTest {

	private CentroSportivo centroProva;
	private Gestore gestoreProva;
	private Utente utenteProva;
	private Livello livello;
	private TipoCampo tipoCampo;
	private Disponibilita disponibilitaPrivataProva;
	private Disponibilita disponibilitaPubblicaProva;
	private Partita partitaPrivataProva;
	private Partita partitaPubblicaProva;

	@Before
	public void setUp() {
		// Configurazione di base per il logger
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.ERROR);
		// Creazione di un gestore di prova
		gestoreProva = new Gestore(0, "gestoretest@test.com", "Giovanni", "Verdi", LocalDate.of(1985, 07, 20), null,
				"password123");
		gestoreProva.setId(GestoriService.aggiungiGestore(gestoreProva)); // Aggiungi il gestore al database

		// Creazione di un centro sportivo di prova associato al gestore
		centroProva = new CentroSportivo(0, "Centro Sportivo di Prova", "Via Test, 1, Milano, Italia",
				BigDecimal.valueOf(45.0), BigDecimal.valueOf(32.201), BigDecimal.valueOf(200), "09:00", "20:00",
				gestoreProva.getId());
		centroProva.setIdCentro(CentriSportiviService.aggiungiCentro(centroProva)); // Aggiungi il centro sportivo al
																					// database

		// Associazione di un tipo di campo esistente (ID 1)
		tipoCampo = TipoCampoService.findTipoCampo(1);

		livello = LivelliService.findLivello(1);

		// Creazione di un utente di prova
		utenteProva = new Utente(0, "utentest@test.com", "Test", "Utente", LocalDate.of(1990, 01, 01), null,
				"passwordTest", livello);
		utenteProva.setId(UtentiService.aggiungiUtente(utenteProva)); // Aggiungi l'utente al database

		// Aggiungi una disponibilità per la partita privata
		LocalDateTime dataOraPrivata = LocalDateTime.now().plusDays(1);
		BigDecimal prezzo = BigDecimal.valueOf(50.0);
		disponibilitaPrivataProva = new Disponibilita(0, dataOraPrivata, prezzo, tipoCampo, centroProva, 0);
		disponibilitaPrivataProva.setIdDisp(DisponibilitaService.aggiungiDisponibilita(disponibilitaPrivataProva));
		
		LocalDateTime dataOraPubblica = LocalDateTime.now().plusDays(1);
		// Aggiungi una disponibilità per la partita pubblica
		disponibilitaPubblicaProva = new Disponibilita(0, dataOraPubblica, prezzo, tipoCampo, centroProva, 0);
		disponibilitaPubblicaProva.setIdDisp(DisponibilitaService.aggiungiDisponibilita(disponibilitaPrivataProva));

		// Crea una nuova partita privata
		partitaPrivataProva = new Partita(10, 0, 1, "Contanti", utenteProva.getId(), disponibilitaPrivataProva.getIdDisp());
		partitaPrivataProva.setIdPartita(PartitaService.aggiungiPartita(partitaPrivataProva));
		disponibilitaPrivataProva.setPrenotato(1);
		
		// Crea una nuova partita pubblica
		partitaPubblicaProva = new Partita(10, 1, 0, "Credito", utenteProva.getId(), disponibilitaPubblicaProva.getIdDisp());
		partitaPubblicaProva.setIdPartita(PartitaService.aggiungiPartita(partitaPubblicaProva));
		disponibilitaPrivataProva.setPrenotato(1);
	}

	@After
	public void tearDown() {
		// Rimuovi il centro sportivo e il gestore di prova
		SportMateDB db = SportMateDB.getInstance();
		db.apriConnessione();
		DSLContext dsl = db.getContext();

		// Elimina le partite, disponibilità, e la relazione tra centro sportivo e tipo
		// di campo
		dsl.delete(PARTITE).where(PARTITE.IDPARTITA.eq(partitaPubblicaProva.getIdPartita())).execute();
		dsl.delete(DISPONIBILITA).where(DISPONIBILITA.IDCENTRO.eq(disponibilitaPubblicaProva.getIdDisp())).execute();
		dsl.delete(PARTITE).where(PARTITE.IDPARTITA.eq(partitaPrivataProva.getIdPartita())).execute();
		dsl.delete(DISPONIBILITA).where(DISPONIBILITA.IDCENTRO.eq(disponibilitaPrivataProva.getIdDisp())).execute();
		dsl.delete(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(centroProva.getIdCentro())).execute();
		dsl.delete(GESTORI).where(GESTORI.IDGESTORE.eq(gestoreProva.getId())).execute();

		// Rimuovi l'utente
		dsl.delete(UTENTI).where(UTENTI.IDUTENTE.eq(utenteProva.getId())).execute();

		db.chiudiConnessione();
	}

	@Test
	public void testAggiungiPartita() {
		// Verifica che la partita sia stata correttamente aggiunta
		Partita partitaRecuperata = PartitaService.findByDisponibilita(disponibilitaPrivataProva.getIdDisp());
		assertNotNull("La partita non è stata aggiunta correttamente", partitaRecuperata);
		assertEquals("ID partita non corrisponde", partitaPrivataProva.getIdPartita(), partitaRecuperata.getIdPartita());
	}

	@Test
	public void testAggiornaPartita() {
		// Aggiorna la partita
		Partita partitaAggiornata =  new Partita(10, 0, 1, "Credito", utenteProva.getId(), disponibilitaPrivataProva.getIdDisp());
		int result = PartitaService.aggiornaPartita(partitaAggiornata);

		// Verifica che l'aggiornamento sia stato eseguito correttamente
		assertEquals("Aggiornamento della partita fallito", 1, result);

		// Recupera la partita aggiornata e verifica i dati
		Partita partitaRecuperata = PartitaService.findByDisponibilita(disponibilitaPrivataProva.getIdDisp());
		assertEquals("Posti totali non aggiornati correttamente", 10, partitaRecuperata.getPostiTot());
		assertEquals("Stato non aggiornato correttamente", 1, partitaRecuperata.getStato());
		assertEquals("Modalità di pagamento non aggiornata correttamente", "Credito",
				partitaRecuperata.getModPagamento());
	}

	@Test
	public void testFindAll() {
		// Recupera tutte le partite
		List<Partita> partite = PartitaService.findAll();

		// Verifica che la lista non sia vuota e contenga la partita aggiunta
		assertNotNull("La lista delle partite è nulla", partite);
		assertFalse("La lista delle partite è vuota", partite.isEmpty());

		boolean partitaPrivataTrovata = false;
		for (Partita partita : partite) {
			if (partita.getIdPartita() == partitaPrivataProva.getIdPartita()) {
				partitaPrivataTrovata = true;
				break;
			}
		}
		assertTrue("La partita non è stata trovata nella lista", partitaPrivataTrovata);
	}

	@Test
	public void testFindAllPubbliche() {
		// Recupera tutte le partite pubbliche
		List<InfoPartita> partitePubbliche = PartitaService.findAllPubbliche();

		// Verifica che la lista non sia vuota e contenga la partita pubblicata
		assertNotNull("La lista delle partite pubbliche è nulla", partitePubbliche);
		assertFalse("La lista delle partite pubbliche è vuota", partitePubbliche.isEmpty());

		boolean partitaTrovata = false;
		for (InfoPartita infoPartita : partitePubbliche) {
			if (infoPartita.getIdPartita() == partitaPubblicaProva.getIdPartita()) {
				partitaTrovata = true;
				break;
			}
		}
		assertTrue("La partita pubblica non è stata trovata", partitaTrovata);
	}
}
