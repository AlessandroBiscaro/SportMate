/*
 * This file is generated by jOOQ.
 */
package sport_mate_inc.sport_mate_business_layer.tables.records;


import org.jooq.impl.TableRecordImpl;

import sport_mate_inc.sport_mate_business_layer.tables.Serviziaggiuntivi;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ServiziaggiuntiviRecord extends TableRecordImpl<ServiziaggiuntiviRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>ServiziAggiuntivi.idServizio</code>.
     */
    public void setIdservizio(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>ServiziAggiuntivi.idServizio</code>.
     */
    public Integer getIdservizio() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>ServiziAggiuntivi.nomeServizio</code>.
     */
    public void setNomeservizio(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>ServiziAggiuntivi.nomeServizio</code>.
     */
    public String getNomeservizio() {
        return (String) get(1);
    }

    /**
     * Setter for <code>ServiziAggiuntivi.descrizione</code>.
     */
    public void setDescrizione(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>ServiziAggiuntivi.descrizione</code>.
     */
    public String getDescrizione() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ServiziaggiuntiviRecord
     */
    public ServiziaggiuntiviRecord() {
        super(Serviziaggiuntivi.SERVIZIAGGIUNTIVI);
    }

    /**
     * Create a detached, initialised ServiziaggiuntiviRecord
     */
    public ServiziaggiuntiviRecord(Integer idservizio, String nomeservizio, String descrizione) {
        super(Serviziaggiuntivi.SERVIZIAGGIUNTIVI);

        setIdservizio(idservizio);
        setNomeservizio(nomeservizio);
        setDescrizione(descrizione);
        resetChangedOnNotNull();
    }
}