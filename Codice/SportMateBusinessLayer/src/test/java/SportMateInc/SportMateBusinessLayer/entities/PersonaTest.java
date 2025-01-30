package SportMateInc.SportMateBusinessLayer.entities;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import sportmateinc.sportmatebusinesslayer.entities.Persona;

public class PersonaTest {
    
    private Persona persona;
    
    private static class PersonaTestImpl extends Persona {
        public PersonaTestImpl(Integer id, String mail, String nome, String cognome, LocalDate dataNascita, String telefono, String password) {
            super(id, mail, nome, cognome, dataNascita, telefono, password);
        }
    }
    
    @Before
    public void setUp() {
        persona = new PersonaTestImpl(1, "test@mail.com", "Mario", "Rossi", LocalDate.of(1990, 5, 20), "1234567890", "password123");
    }
    
    @Test
    public void testGetId() {
        assertEquals((Integer) 1, persona.getId());
    }
    
    @Test
    public void testSetId() {
        persona.setId(2);
        assertEquals((Integer) 2, persona.getId());
    }
    
    @Test
    public void testGetMail() {
        assertEquals("test@mail.com", persona.getMail());
    }
    
    @Test
    public void testSetMail() {
        persona.setMail("new@mail.com");
        assertEquals("new@mail.com", persona.getMail());
    }
    
    @Test
    public void testGetNome() {
        assertEquals("Mario", persona.getNome());
    }
    
    @Test
    public void testSetNome() {
        persona.setNome("Luigi");
        assertEquals("Luigi", persona.getNome());
    }
    
    @Test
    public void testGetCognome() {
        assertEquals("Rossi", persona.getCognome());
    }
    
    @Test
    public void testSetCognome() {
        persona.setCognome("Bianchi");
        assertEquals("Bianchi", persona.getCognome());
    }
    
    @Test
    public void testGetDataNascita() {
        assertEquals(LocalDate.of(1990, 5, 20), persona.getDataNascita());
    }
    
    @Test
    public void testSetDataNascita() {
        LocalDate newDate = LocalDate.of(1995, 10, 15);
        persona.setDataNascita(newDate);
        assertEquals(newDate, persona.getDataNascita());
    }
    
    @Test
    public void testGetTelefono() {
        assertEquals("1234567890", persona.getTelefono());
    }
    
    @Test
    public void testSetTelefono() {
        persona.setTelefono("0987654321");
        assertEquals("0987654321", persona.getTelefono());
    }
    
    @Test
    public void testGetPassword() {
        assertEquals("password123", persona.getPassword());
    }
    
    @Test
    public void testSetPassword() {
        persona.setPassword("newpassword");
        assertEquals("newpassword", persona.getPassword());
    }
}