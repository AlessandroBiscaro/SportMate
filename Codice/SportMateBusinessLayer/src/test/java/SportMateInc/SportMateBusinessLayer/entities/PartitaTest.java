package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Partita;

import static org.junit.Assert.*;

public class PartitaTest {

    private Partita partita;

    @Before
    public void setUp() {
        partita = new Partita(100, 1, 1, "Contante", 1, 2);
    }

    @Test
    public void testSetter() {
        partita.setPostiTot(200);
        partita.setPubblica(0);
        partita.setStato(2);
        partita.setModPagamento("Carta");
        partita.setIdOrgan(3);
        partita.setIdDisp(4);
        partita.setGoalCasa(1);
        partita.setGoalFuori(2);

        assertEquals(200, partita.getPostiTot());
        assertEquals(0, partita.getPubblica());
        assertEquals(2, partita.getStato());
        assertEquals("Carta", partita.getModPagamento());
        assertEquals(3, partita.getIdOrgan());
        assertEquals(4, partita.getIdDisp());
        assertEquals(1, partita.getGoalCasa());
        assertEquals(2, partita.getGoalFuori());
    }

    @Test
    public void testGoalCasa() {
        partita.setGoalCasa(3);
        assertEquals(3, partita.getGoalCasa());
    }

    
    @Test
    public void testGoalFuori() {
        partita.setGoalFuori(5);
        assertEquals(5, partita.getGoalFuori());
    }

    
    @Test
    public void testGetPostiTot() {
        assertEquals(100, partita.getPostiTot());
    }

    
    @Test
    public void testGetPubblica() {
        assertEquals(1, partita.getPubblica());
    }

    
    @Test
    public void testGetStato() {
        assertEquals(1, partita.getStato());
    }

    
    @Test
    public void testGetModPagamento() {
        assertEquals("Contante", partita.getModPagamento());
    }

    
    @Test
    public void testGetIdOrgan() {
        assertEquals(1, partita.getIdOrgan());
    }

    
    @Test
    public void testGetIdDisp() {
        assertEquals(2, partita.getIdDisp());
    }

    @Test
    public void testGetGoalCasa() {
        assertEquals(0, partita.getGoalCasa());
    }

    @Test
    public void testGetGoalFuori() {
        assertEquals(0, partita.getGoalFuori());
    }
}
