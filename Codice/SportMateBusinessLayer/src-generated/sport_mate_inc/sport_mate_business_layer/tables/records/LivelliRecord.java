/*
 * This file is generated by jOOQ.
 */
package sport_mate_inc.sport_mate_business_layer.tables.records;


import org.jooq.impl.TableRecordImpl;

import sport_mate_inc.sport_mate_business_layer.tables.Livelli;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class LivelliRecord extends TableRecordImpl<LivelliRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Livelli.idLivello</code>.
     */
    public void setIdlivello(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Livelli.idLivello</code>.
     */
    public Integer getIdlivello() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Livelli.nomeLivello</code>.
     */
    public void setNomelivello(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Livelli.nomeLivello</code>.
     */
    public String getNomelivello() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LivelliRecord
     */
    public LivelliRecord() {
        super(Livelli.LIVELLI);
    }

    /**
     * Create a detached, initialised LivelliRecord
     */
    public LivelliRecord(Integer idlivello, String nomelivello) {
        super(Livelli.LIVELLI);

        setIdlivello(idlivello);
        setNomelivello(nomelivello);
        resetChangedOnNotNull();
    }
}