/*
 * This file is generated by jOOQ.
 */
package sport_mate_inc.sport_mate_business_layer.tables.records;


import org.jooq.impl.TableRecordImpl;

import sport_mate_inc.sport_mate_business_layer.tables.Gestori;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class GestoriRecord extends TableRecordImpl<GestoriRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Gestori.idGestore</code>.
     */
    public void setIdgestore(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Gestori.idGestore</code>.
     */
    public Integer getIdgestore() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Gestori.nome</code>.
     */
    public void setNome(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Gestori.nome</code>.
     */
    public String getNome() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Gestori.cognome</code>.
     */
    public void setCognome(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Gestori.cognome</code>.
     */
    public String getCognome() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Gestori.dataNascita</code>.
     */
    public void setDatanascita(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>Gestori.dataNascita</code>.
     */
    public String getDatanascita() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Gestori.mail</code>.
     */
    public void setMail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>Gestori.mail</code>.
     */
    public String getMail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>Gestori.telefono</code>.
     */
    public void setTelefono(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>Gestori.telefono</code>.
     */
    public String getTelefono() {
        return (String) get(5);
    }

    /**
     * Setter for <code>Gestori.password</code>.
     */
    public void setPassword(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>Gestori.password</code>.
     */
    public String getPassword() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GestoriRecord
     */
    public GestoriRecord() {
        super(Gestori.GESTORI);
    }

    /**
     * Create a detached, initialised GestoriRecord
     */
    public GestoriRecord(Integer idgestore, String nome, String cognome, String datanascita, String mail, String telefono, String password) {
        super(Gestori.GESTORI);

        setIdgestore(idgestore);
        setNome(nome);
        setCognome(cognome);
        setDatanascita(datanascita);
        setMail(mail);
        setTelefono(telefono);
        setPassword(password);
        resetChangedOnNotNull();
    }
}