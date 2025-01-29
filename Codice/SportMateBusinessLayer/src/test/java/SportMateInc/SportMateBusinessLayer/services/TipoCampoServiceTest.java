package SportMateInc.SportMateBusinessLayer.services;

import static org.junit.Assert.*;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Centrisportivi.CENTRISPORTIVI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Gestori.GESTORI;
import static sportmateinc.sportmatebusinesslayergenerated.tables.Dettagliotipologiecentri.DETTAGLIOTIPOLOGIECENTRI;

import org.junit.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;
import sportmateinc.sportmatebusinesslayer.entities.Gestore;
import sportmateinc.sportmatebusinesslayer.entities.CentroSportivo;
import sportmateinc.sportmatebusinesslayer.services.TipoCampoService;
import sportmateinc.sportmatebusinesslayer.services.GestoriService;
import sportmateinc.sportmatebusinesslayer.services.CentriSportiviService;
import sportmateinc.sportmatedblayer.SportMateDB;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TipoCampoServiceTest {

    private int idCentro;
    private int idGestore;

    @Before
    public void setUp() {
    	 BasicConfigurator.configure();
	     Logger.getRootLogger().setLevel(Level.ERROR);
        // Crea un gestore di prova
        Gestore gestoreProva = new Gestore(0, "gestoretest@test.com", "Giovanni", "Verdi", LocalDate.of(1985, 07, 20), null, "password123");
        idGestore = GestoriService.aggiungiGestore(gestoreProva);  // Aggiungi il gestore al database

        // Crea un centro sportivo di prova associato al gestore
        CentroSportivo centroProva = new CentroSportivo(0, "Centro Sportivo di Prova", "Via Test, 1, Milano, Italia", 
                BigDecimal.valueOf(45.0), BigDecimal.valueOf(32.201), BigDecimal.valueOf(200), "09:00", "20:00", idGestore);
        idCentro = CentriSportiviService.aggiungiCentro(centroProva);  // Aggiungi il centro sportivo al database
    }

    @After
    public void tearDown() {
        // Rimuovi il centro sportivo e il gestore di prova
        SportMateDB db = SportMateDB.getInstance();
        db.apriConnessione();
        DSLContext dsl = db.getContext();
        
        // Elimina la relazione tra il centro sportivo e il tipo di campo (id 1, 2, 3)
        dsl.delete(DETTAGLIOTIPOLOGIECENTRI).where(DETTAGLIOTIPOLOGIECENTRI.IDCENTRO.eq(idCentro)).execute();
        
        // Elimina il centro sportivo
        dsl.delete(CENTRISPORTIVI).where(CENTRISPORTIVI.IDCENTRO.eq(idCentro)).execute();
        
        // Elimina il gestore
        dsl.delete(GESTORI).where(GESTORI.IDGESTORE.eq(idGestore)).execute();
        
        db.chiudiConnessione();
    }

    @Test
    public void testFindTipoCampo() {
        // Test per il metodo findTipoCampo con un ID valido (es. ID 1)
        TipoCampo tipoCampo = TipoCampoService.findTipoCampo(1);
        
        // Verifica che il tipo di campo non sia nullo e che l'ID corrisponda
        assertNotNull("Tipo di campo non trovato", tipoCampo);
        assertEquals("ID Tipo di campo non corrisponde", 1, tipoCampo.getIdCampo());
    }

    @Test
    public void testFindAll() {
        // Test per il metodo findAll() per verificare che ci siano tipi di campo nel DB
        List<TipoCampo> tipiCampo = TipoCampoService.findAll();
        
        // Verifica che la lista dei tipi di campo non sia nulla e contenga almeno un tipo
        assertNotNull("La lista dei tipi di campo è nulla", tipiCampo);
        assertTrue("La lista dei tipi di campo è vuota", tipiCampo.size() > 0);
    }

    @Test
    public void testAggiungiTipoCampo() {
        // Test per associare un tipo di campo esistente (ID 1) a un centro sportivo
        int result = TipoCampoService.aggiungiTipoCampo(idCentro, 1);
        
        // Verifica che l'inserimento abbia avuto successo (risultato maggiore di 0)
        assertTrue("Inserimento del tipo di campo nel centro sportivo fallito", result > 0);
        
        // Verifica che la relazione sia stata effettivamente creata nel database
        SportMateDB db = SportMateDB.getInstance();
        db.apriConnessione();
        DSLContext dsl = db.getContext();
        Result<Record> resultCheck = dsl.select()
                .from(DETTAGLIOTIPOLOGIECENTRI)
                .where(DETTAGLIOTIPOLOGIECENTRI.IDCENTRO.eq(idCentro))
                .and(DETTAGLIOTIPOLOGIECENTRI.IDTIPOLOGIA.eq(1))  // Associare tipo campo ID 1
                .fetch();
        db.chiudiConnessione();
        
        // Assicurati che la relazione tra centro sportivo e tipo di campo esista
        assertFalse("La relazione tra centro sportivo e tipo di campo non è stata creata", resultCheck.isEmpty());
    }

    @Test
    public void testFindTipoCampoInvalidId() {
        // Test per il metodo findTipoCampo con un ID non valido
        TipoCampo tipoCampo = null;
        try{
        	tipoCampo = TipoCampoService.findTipoCampo(9999);
        	fail("NullPointerException prevista");// ID inesistente
        }catch(NullPointerException ex) {
        	 // Verifica che il risultato sia nullo, poiché non esiste un tipo di campo con quell'ID
            assertNull("Il tipo di campo non dovrebbe essere trovato", tipoCampo);
        }
    }
}
