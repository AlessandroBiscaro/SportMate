package SportMateInc.SportMateBusinessLayer.entities;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Location;

import static org.junit.Assert.*;

public class LocationTest {

    private Location location;

    
    @Before
    public void setUp() {
        
        location = new Location(1, "Italy", "Rome", "Colosseum", 41.8902, 12.4922);
    }

    @Test
    public void testGetId() {
        assertEquals(1, location.getId());
    }

    @Test
    public void testGetCountry() {
        assertEquals("Italy", location.getCountry());
    }

    
    @Test
    public void testGetCity() {
        assertEquals("Rome", location.getCity());
    }

    @Test
    public void testGetPlace() {
        assertEquals("Colosseum", location.getPlace());
    }

    @Test
    public void testGetLatitude() {
        assertEquals(41.8902, location.getLatitude(), 0.0001);
    }

    @Test
    public void testGetLongitude() {
        assertEquals(12.4922, location.getLongitude(), 0.0001);
    }

    @Test
    public void testToString() {
        String expectedString = "Location [id=1, country=Italy, city=Rome, place=Colosseum, latitude=41.8902, longitude=12.4922]";
        assertEquals(expectedString, location.toString());
    }
}
