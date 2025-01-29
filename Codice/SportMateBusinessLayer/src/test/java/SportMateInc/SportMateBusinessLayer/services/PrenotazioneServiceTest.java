package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Disponibilita.DISPONIBILITA;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Partite.PARTITE;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Utenti.UTENTI;

import org.junit.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;

import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Disponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.InfoDisponibilita;
import sportmateinc.sportmatebusinesslayer.entities.Livello;
import sportmateinc.sportmatebusinesslayer.entities.Partita;
import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.entities.Utente;
import sportmateinc.sportmatebusinesslayer.services.PrenotazioneService;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.DisponibilitaService;
import sportmateinc.sportmatebusinesslayer.services.TipoCampoService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.LivelliService;
import sportmateinc.sportmatebusinesslayer.services.PartitaService;
import sportmateinc.sportmatebusinesslayer.services.UtentiService;
import sportmateinc.sportmatedblayer.SportMateDB;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PrenotazioneServiceTest {

    private CentroSportivo centroProva;
    private Gestore gestoreProva;
    private Utente utenteProva;
    private Livello livello;
    private TipoCampo tipoCampo;
    private Disponibilita disponibilitaProva;
    private Partita partitaProva;

    @Before
    public void setUp() {
    	//Configurazione di base per il logger
    	BasicConfigurator.configure();
	    Logger.getRootLogger().setLevel(Level.ERROR);
        // Creazione di un gestore di prova
        gestoreProva = new Gestore(0, "gestoretest@test.com", "Giovanni", "Verdi", LocalDate.of(1985, 07, 20), null, "password123");
        gestoreProva.setId(GestoriService.aggiungiGestore(gestoreProva));  // Aggiungi il gestore al database

        // Creazione di un centro sportivo di prova associato al gestore
        centroProva = new CentroSportivo(0, "Centro Sportivo di Prova", "Via Test, 1, Milano, Italia", 
                BigDecimal.valueOf(45.0), BigDecimal.valueOf(32.201), BigDecimal.valueOf(200), "09:00", "20:00", gestoreProva.getId());
        centroProva.setIdCentro(CentriSportiviService.aggiungiCentro(centroProva));  // Aggiungi il centro sportivo al database

        // Associazione di un tipo di campo esistente (ID 1)
        tipoCampo = TipoCampoService.findTipoCampo(1);
        
        livello = LivelliService.findLivello(1);

        // Creazione di un utente di prova
        utenteProva = new Utente(0, "utentest@test.com", "Test", "Utente", LocalDate.of(1990, 01, 01), null , "passwordTest", livello);
        utenteProva.setId(UtentiService.aggiungiUtente(utenteProva));  // Aggiungi l'utente al database
    
        // Aggiungi una disponibilità
        LocalDateTime dataOra = LocalDateTime.now().plusDays(1);
        BigDecimal prezzo = BigDecimal.valueOf(50.0);
        disponibilitaProva = new Disponibilita(0,dataOra, prezzo, tipoCampo, centroProva, 0);
        disponibilitaProva.setIdDisp(DisponibilitaService.aggiungiDisponibilita(disponibilitaProva));
        
        //Crea una nuova partita privata
        partitaProva = new Partita(10, 0, 1, "Contanti", utenteProva.getId(), disponibilitaProva.getIdDisp());
        partitaProva.setIdPartita(PartitaService.aggiungiPartita(partitaProva));

    }

    @After
    public void tearDown() {
        // Rimuovi il centro sportivo e il gestore di prova
        SportMateDB db = SportMateDB.getInstance();
        db.apriConnessione();
        DSLContext dsl = db.getContext();

        // Elimina le partite, disponibilità, e la relazione tra centro sportivo e tipo di campo
        dsl.delete(PARTITE).where(PARTITE.IDPARTITA.eq(partitaProva.getIdPartita())).execute();
        dsl.delete(DISPONIBILITA).where(DISPONIBILITA.IDCENTRO.eq(disponibilitaProva.getIdDisp())).execute();
        dsl.delete(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(centroProva.getIdCentro())).execute();
        dsl.delete(GESTORI).where(GESTORI.IDGESTORE.eq(gestoreProva.getId())).execute();

        // Rimuovi l'utente
        dsl.delete(UTENTI).where(UTENTI.IDUTENTE.eq(utenteProva.getId())).execute();

        db.chiudiConnessione();
    }

    @Test
    public void testFindByUtente() {
       
        // Trova le disponibilità associate all'utente
        List<InfoDisponibilita> infoList = PrenotazioneService.findByUtente(utenteProva);

        // Verifica che la lista non sia vuota
        assertNotNull("La lista delle disponibilità è nulla", infoList);
        assertFalse("La lista delle disponibilità è vuota", infoList.isEmpty());

        // Verifica che il campo di disponibilità associato all'utente sia corretto
        InfoDisponibilita info = infoList.get(0);
        assertEquals("Nome del centro sportivo non corrisponde", "Centro Sportivo di Prova", info.getNomecentro());
        assertEquals("Tipo di campo non corrisponde", "Calcio a 5", info.getTipoCampo());
        assertEquals("Prezzo della disponibilità non corrisponde", BigDecimal.valueOf(50), info.getPrezzo());
    }
    
}
