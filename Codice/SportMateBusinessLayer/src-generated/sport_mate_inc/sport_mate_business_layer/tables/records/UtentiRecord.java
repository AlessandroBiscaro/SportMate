/*
 * This file is generated by jOOQ.
 */
package sport_mate_inc.sport_mate_business_layer.tables.records;


import java.math.BigDecimal;

import org.jooq.impl.TableRecordImpl;

import sport_mate_inc.sport_mate_business_layer.tables.Utenti;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class UtentiRecord extends TableRecordImpl<UtentiRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Utenti.idUtente</code>.
     */
    public void setIdutente(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Utenti.idUtente</code>.
     */
    public Integer getIdutente() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Utenti.nome</code>.
     */
    public void setNome(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Utenti.nome</code>.
     */
    public String getNome() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Utenti.cognome</code>.
     */
    public void setCognome(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Utenti.cognome</code>.
     */
    public String getCognome() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Utenti.dataNascita</code>.
     */
    public void setDatanascita(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>Utenti.dataNascita</code>.
     */
    public String getDatanascita() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Utenti.mail</code>.
     */
    public void setMail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>Utenti.mail</code>.
     */
    public String getMail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>Utenti.telefono</code>.
     */
    public void setTelefono(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>Utenti.telefono</code>.
     */
    public String getTelefono() {
        return (String) get(5);
    }

    /**
     * Setter for <code>Utenti.password</code>.
     */
    public void setPassword(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>Utenti.password</code>.
     */
    public String getPassword() {
        return (String) get(6);
    }

    /**
     * Setter for <code>Utenti.credito</code>.
     */
    public void setCredito(BigDecimal value) {
        set(7, value);
    }

    /**
     * Getter for <code>Utenti.credito</code>.
     */
    public BigDecimal getCredito() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>Utenti.livello</code>.
     */
    public void setLivello(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>Utenti.livello</code>.
     */
    public Integer getLivello() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>Utenti.pathImg</code>.
     */
    public void setPathimg(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>Utenti.pathImg</code>.
     */
    public String getPathimg() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UtentiRecord
     */
    public UtentiRecord() {
        super(Utenti.UTENTI);
    }

    /**
     * Create a detached, initialised UtentiRecord
     */
    public UtentiRecord(Integer idutente, String nome, String cognome, String datanascita, String mail, String telefono, String password, BigDecimal credito, Integer livello, String pathimg) {
        super(Utenti.UTENTI);

        setIdutente(idutente);
        setNome(nome);
        setCognome(cognome);
        setDatanascita(datanascita);
        setMail(mail);
        setTelefono(telefono);
        setPassword(password);
        setCredito(credito);
        setLivello(livello);
        setPathimg(pathimg);
        resetChangedOnNotNull();
    }
}