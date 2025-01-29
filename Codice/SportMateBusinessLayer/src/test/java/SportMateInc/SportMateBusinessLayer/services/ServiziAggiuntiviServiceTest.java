package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Serviziaggiuntivi.SERVIZIAGGIUNTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Dettaglioservizicentri.DETTAGLIOSERVIZICENTRI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;

import org.junit.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import sportmateinc.sportmatebusinesslayer.entities.ServiziAggiuntivi;
import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.services.ServiziAggService;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatedblayer.SportMateDB;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ServiziAggiuntiviServiceTest {

    private int idCentro;
    private int idServizio;
    private int idGestore;

    @Before
    public void setUp() {
    	 BasicConfigurator.configure();
	     Logger.getRootLogger().setLevel(Level.ERROR);
        // Crea un gestore di prova
        Gestore gestoreProva = new Gestore(0, "gestoreprova@test.com", "Giovanni", "Verdi", LocalDate.of(1990, 05, 15), null, "password123");
        idGestore = GestoriService.aggiungiGestore(gestoreProva);  // Aggiungi il gestore al database

        // Crea un centro sportivo di prova associato al gestore
        CentroSportivo centroProva = new CentroSportivo(0, "Centro Sportivo di Prova", "Via Test, 1, Milano, Italia", 
                BigDecimal.valueOf(45.0), BigDecimal.valueOf(32.201), BigDecimal.valueOf(200), "09:00", "20:00", idGestore);
        idCentro = CentriSportiviService.aggiungiCentro(centroProva);  // Aggiungi il centro sportivo al database

        // Aggiungi un servizio di prova al database
        ServiziAggiuntivi servizio = new ServiziAggiuntivi(0, "Servizio Test", "Descrizione del servizio di test");
        idServizio = aggiungiServizioTest(servizio);
    }

    @After
    public void tearDown() {
        // Rimuovi il centro sportivo di prova e il gestore di prova
        SportMateDB db = SportMateDB.getInstance();
        db.apriConnessione();
        DSLContext dsl = db.getContext();
        
        // Elimina la relazione tra centro e servizio
        dsl.delete(DETTAGLIOSERVIZICENTRI).where(DETTAGLIOSERVIZICENTRI.IDCENTRO.eq(idCentro)).and(DETTAGLIOSERVIZICENTRI.IDSERVIZIO.eq(idServizio)).execute();
        
        // Elimina il centro sportivo
        dsl.delete(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(idCentro)).execute();
        
        // Elimina il gestore
        dsl.delete(GESTORI).where(GESTORI.IDGESTORE.eq(idGestore)).execute();
        
        db.chiudiConnessione();
    }

    private int aggiungiServizioTest(ServiziAggiuntivi servizio) {
        // Aggiungi il servizio di test al database e ritorna l'ID del servizio
        SportMateDB db = SportMateDB.getInstance();
        db.apriConnessione();
        DSLContext dsl = db.getContext();
        int insertedId = dsl.insertInto(SERVIZIAGGIUNTIVI, SERVIZIAGGIUNTIVI.NOMESERVIZIO, SERVIZIAGGIUNTIVI.DESCRIZIONE)
                .values(servizio.getNomeServizio(), servizio.getDescrizione())
                .returning(SERVIZIAGGIUNTIVI.IDSERVIZIO)
                .fetchOne()
                .getValue(SERVIZIAGGIUNTIVI.IDSERVIZIO);
        db.chiudiConnessione();
        return insertedId;
    }

    @Test
    public void testFindServizi() {
        // Test per il metodo findServizi con un ID valido
        ServiziAggiuntivi servizio = ServiziAggService.findServizi(idServizio);
        
        // Verifica che il servizio non sia nullo e che l'ID corrisponda
        assertNotNull("Servizio non trovato", servizio);
        assertEquals("ID Servizio non corrisponde", idServizio, servizio.getIdServizio());
    }

    @Test
    public void testFindAll() {
        // Test per il metodo findAll() per verificare che ci siano servizi nel DB
        List<ServiziAggiuntivi> servizi = ServiziAggService.findAll();
        
        // Verifica che la lista dei servizi non sia nulla e contenga almeno un servizio
        assertNotNull("La lista dei servizi è nulla", servizi);
        assertTrue("La lista dei servizi è vuota", servizi.size() > 0);
    }

    @Test
    public void testAggiungiServizioAgg() {
        // Test per aggiungere un servizio a un centro sportivo
        int result = ServiziAggService.aggiungiServizioAgg(idCentro, idServizio);
        
        // Verifica che l'inserimento abbia avuto successo (risultato maggiore di 0)
        assertTrue("Inserimento del servizio nel centro sportivo fallito", result > 0);
        
        // Verifica che la relazione sia stata effettivamente creata nel database
        SportMateDB db = SportMateDB.getInstance();
        db.apriConnessione();
        DSLContext dsl = db.getContext();
        Result<Record> resultCheck = dsl.select()
                .from(DETTAGLIOSERVIZICENTRI)
                .where(DETTAGLIOSERVIZICENTRI.IDCENTRO.eq(idCentro))
                .and(DETTAGLIOSERVIZICENTRI.IDSERVIZIO.eq(idServizio))
                .fetch();
        db.chiudiConnessione();
        
        // Assicurati che la relazione tra centro sportivo e servizio esista
        assertFalse("La relazione tra centro sportivo e servizio non è stata creata", resultCheck.isEmpty());
    }

    public void testFindServiziInvalidId() {
    	ServiziAggiuntivi servizio = null;
        // Test per il metodo findServizi con un ID non valido
         try{
        	 servizio = ServiziAggService.findServizi(9999); 
        	 fail("NullPointerException non sollevata!");
         }
         catch(NullPointerException ex) {
        	 assertNull("Il servizio non dovrebbe esistere!", servizio);
         }
         fail("NullPointerException non sollevata!");
    }
}
