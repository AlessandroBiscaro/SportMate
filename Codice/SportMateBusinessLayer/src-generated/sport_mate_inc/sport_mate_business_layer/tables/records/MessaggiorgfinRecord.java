/*
 * This file is generated by jOOQ.
 */
package sport_mate_inc.sport_mate_business_layer.tables.records;


import org.jooq.impl.TableRecordImpl;

import sport_mate_inc.sport_mate_business_layer.tables.Messaggiorgfin;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class MessaggiorgfinRecord extends TableRecordImpl<MessaggiorgfinRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>MessaggiOrgFin.idMessaggio</code>.
     */
    public void setIdmessaggio(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>MessaggiOrgFin.idMessaggio</code>.
     */
    public Integer getIdmessaggio() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>MessaggiOrgFin.stato</code>.
     */
    public void setStato(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>MessaggiOrgFin.stato</code>.
     */
    public Integer getStato() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>MessaggiOrgFin.testo</code>.
     */
    public void setTesto(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>MessaggiOrgFin.testo</code>.
     */
    public String getTesto() {
        return (String) get(2);
    }

    /**
     * Setter for <code>MessaggiOrgFin.dataOra</code>.
     */
    public void setDataora(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>MessaggiOrgFin.dataOra</code>.
     */
    public String getDataora() {
        return (String) get(3);
    }

    /**
     * Setter for <code>MessaggiOrgFin.idOrganizzatore</code>.
     */
    public void setIdorganizzatore(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>MessaggiOrgFin.idOrganizzatore</code>.
     */
    public Integer getIdorganizzatore() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>MessaggiOrgFin.idUtenteFinale</code>.
     */
    public void setIdutentefinale(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>MessaggiOrgFin.idUtenteFinale</code>.
     */
    public Integer getIdutentefinale() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MessaggiorgfinRecord
     */
    public MessaggiorgfinRecord() {
        super(Messaggiorgfin.MESSAGGIORGFIN);
    }

    /**
     * Create a detached, initialised MessaggiorgfinRecord
     */
    public MessaggiorgfinRecord(Integer idmessaggio, Integer stato, String testo, String dataora, Integer idorganizzatore, Integer idutentefinale) {
        super(Messaggiorgfin.MESSAGGIORGFIN);

        setIdmessaggio(idmessaggio);
        setStato(stato);
        setTesto(testo);
        setDataora(dataora);
        setIdorganizzatore(idorganizzatore);
        setIdutentefinale(idutentefinale);
        resetChangedOnNotNull();
    }
}