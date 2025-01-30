package SportMateInc.SportMateBusinessLayer.entities;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.TipoCampo;

public class TipoCampoTest {
    
    @Test
    public void testGetIdCampo() {
        TipoCampo campo = new TipoCampo(1, "Calcio");
        assertEquals(1, campo.getIdCampo());
    }
    
    @Test
    public void testGetNomeCampo() {
        TipoCampo campo = new TipoCampo(2, "Tennis");
        assertEquals("Tennis", campo.getNomeCampo());
    }
}