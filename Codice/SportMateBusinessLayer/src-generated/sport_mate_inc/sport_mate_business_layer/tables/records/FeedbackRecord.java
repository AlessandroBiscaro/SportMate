/*
 * This file is generated by jOOQ.
 */
package sport_mate_inc.sport_mate_business_layer.tables.records;


import org.jooq.impl.TableRecordImpl;

import sport_mate_inc.sport_mate_business_layer.tables.Feedback;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class FeedbackRecord extends TableRecordImpl<FeedbackRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Feedback.idFeedback</code>.
     */
    public void setIdfeedback(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Feedback.idFeedback</code>.
     */
    public Integer getIdfeedback() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Feedback.oggetto</code>.
     */
    public void setOggetto(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Feedback.oggetto</code>.
     */
    public String getOggetto() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Feedback.testo</code>.
     */
    public void setTesto(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Feedback.testo</code>.
     */
    public String getTesto() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Feedback.numLike</code>.
     */
    public void setNumlike(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>Feedback.numLike</code>.
     */
    public Integer getNumlike() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>Feedback.idUtente</code>.
     */
    public void setIdutente(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>Feedback.idUtente</code>.
     */
    public Integer getIdutente() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FeedbackRecord
     */
    public FeedbackRecord() {
        super(Feedback.FEEDBACK);
    }

    /**
     * Create a detached, initialised FeedbackRecord
     */
    public FeedbackRecord(Integer idfeedback, String oggetto, String testo, Integer numlike, Integer idutente) {
        super(Feedback.FEEDBACK);

        setIdfeedback(idfeedback);
        setOggetto(oggetto);
        setTesto(testo);
        setNumlike(numlike);
        setIdutente(idutente);
        resetChangedOnNotNull();
    }
}