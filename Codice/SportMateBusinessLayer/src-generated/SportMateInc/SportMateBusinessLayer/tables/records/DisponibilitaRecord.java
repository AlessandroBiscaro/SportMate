/*
 * This file is generated by jOOQ.
 */
package SportMateInc.SportMateBusinessLayer.tables.records;


import SportMateInc.SportMateBusinessLayer.tables.Disponibilita;

import java.math.BigDecimal;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class DisponibilitaRecord extends TableRecordImpl<DisponibilitaRecord> implements Record5<Integer, String, BigDecimal, Integer, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>Disponibilita.idDisponibilita</code>.
     */
    public void setIddisponibilita(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Disponibilita.idDisponibilita</code>.
     */
    public Integer getIddisponibilita() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Disponibilita.dataOra</code>.
     */
    public void setDataora(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Disponibilita.dataOra</code>.
     */
    public String getDataora() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Disponibilita.prezzo</code>.
     */
    public void setPrezzo(BigDecimal value) {
        set(2, value);
    }

    /**
     * Getter for <code>Disponibilita.prezzo</code>.
     */
    public BigDecimal getPrezzo() {
        return (BigDecimal) get(2);
    }

    /**
     * Setter for <code>Disponibilita.tipoCampo</code>.
     */
    public void setTipocampo(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>Disponibilita.tipoCampo</code>.
     */
    public Integer getTipocampo() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>Disponibilita.idCentro</code>.
     */
    public void setIdcentro(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>Disponibilita.idCentro</code>.
     */
    public Integer getIdcentro() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, BigDecimal, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, BigDecimal, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Disponibilita.DISPONIBILITA.IDDISPONIBILITA;
    }

    @Override
    public Field<String> field2() {
        return Disponibilita.DISPONIBILITA.DATAORA;
    }

    @Override
    public Field<BigDecimal> field3() {
        return Disponibilita.DISPONIBILITA.PREZZO;
    }

    @Override
    public Field<Integer> field4() {
        return Disponibilita.DISPONIBILITA.TIPOCAMPO;
    }

    @Override
    public Field<Integer> field5() {
        return Disponibilita.DISPONIBILITA.IDCENTRO;
    }

    @Override
    public Integer component1() {
        return getIddisponibilita();
    }

    @Override
    public String component2() {
        return getDataora();
    }

    @Override
    public BigDecimal component3() {
        return getPrezzo();
    }

    @Override
    public Integer component4() {
        return getTipocampo();
    }

    @Override
    public Integer component5() {
        return getIdcentro();
    }

    @Override
    public Integer value1() {
        return getIddisponibilita();
    }

    @Override
    public String value2() {
        return getDataora();
    }

    @Override
    public BigDecimal value3() {
        return getPrezzo();
    }

    @Override
    public Integer value4() {
        return getTipocampo();
    }

    @Override
    public Integer value5() {
        return getIdcentro();
    }

    @Override
    public DisponibilitaRecord value1(Integer value) {
        setIddisponibilita(value);
        return this;
    }

    @Override
    public DisponibilitaRecord value2(String value) {
        setDataora(value);
        return this;
    }

    @Override
    public DisponibilitaRecord value3(BigDecimal value) {
        setPrezzo(value);
        return this;
    }

    @Override
    public DisponibilitaRecord value4(Integer value) {
        setTipocampo(value);
        return this;
    }

    @Override
    public DisponibilitaRecord value5(Integer value) {
        setIdcentro(value);
        return this;
    }

    @Override
    public DisponibilitaRecord values(Integer value1, String value2, BigDecimal value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DisponibilitaRecord
     */
    public DisponibilitaRecord() {
        super(Disponibilita.DISPONIBILITA);
    }

    /**
     * Create a detached, initialised DisponibilitaRecord
     */
    public DisponibilitaRecord(Integer iddisponibilita, String dataora, BigDecimal prezzo, Integer tipocampo, Integer idcentro) {
        super(Disponibilita.DISPONIBILITA);

        setIddisponibilita(iddisponibilita);
        setDataora(dataora);
        setPrezzo(prezzo);
        setTipocampo(tipocampo);
        setIdcentro(idcentro);
        resetChangedOnNotNull();
    }
}
