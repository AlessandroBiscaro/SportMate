/*
 * This file is generated by jOOQ.
 */
package SportMateInc.SportMateBusinessLayer.tables;


import SportMateInc.SportMateBusinessLayer.DefaultSchema;
import SportMateInc.SportMateBusinessLayer.tables.records.SquadreRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Squadre extends TableImpl<SquadreRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Squadre</code>
     */
    public static final Squadre SQUADRE = new Squadre();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SquadreRecord> getRecordType() {
        return SquadreRecord.class;
    }

    /**
     * The column <code>Squadre.idSquadra</code>.
     */
    public final TableField<SquadreRecord, Integer> IDSQUADRA = createField(DSL.name("idSquadra"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>Squadre.nomeSquadra</code>.
     */
    public final TableField<SquadreRecord, String> NOMESQUADRA = createField(DSL.name("nomeSquadra"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Squadre.coloreMaglia</code>.
     */
    public final TableField<SquadreRecord, String> COLOREMAGLIA = createField(DSL.name("coloreMaglia"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Squadre.inCasa</code>.
     */
    public final TableField<SquadreRecord, Integer> INCASA = createField(DSL.name("inCasa"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>Squadre.idPartita</code>.
     */
    public final TableField<SquadreRecord, Integer> IDPARTITA = createField(DSL.name("idPartita"), SQLDataType.INTEGER.nullable(false), this, "");

    private Squadre(Name alias, Table<SquadreRecord> aliased) {
        this(alias, aliased, null);
    }

    private Squadre(Name alias, Table<SquadreRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Squadre</code> table reference
     */
    public Squadre(String alias) {
        this(DSL.name(alias), SQUADRE);
    }

    /**
     * Create an aliased <code>Squadre</code> table reference
     */
    public Squadre(Name alias) {
        this(alias, SQUADRE);
    }

    /**
     * Create a <code>Squadre</code> table reference
     */
    public Squadre() {
        this(DSL.name("Squadre"), null);
    }

    public <O extends Record> Squadre(Table<O> child, ForeignKey<O, SquadreRecord> key) {
        super(child, key, SQUADRE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Squadre as(String alias) {
        return new Squadre(DSL.name(alias), this);
    }

    @Override
    public Squadre as(Name alias) {
        return new Squadre(alias, this);
    }

    @Override
    public Squadre as(Table<?> alias) {
        return new Squadre(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Squadre rename(String name) {
        return new Squadre(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Squadre rename(Name name) {
        return new Squadre(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Squadre rename(Table<?> name) {
        return new Squadre(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Integer, ? super String, ? super String, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Integer, ? super String, ? super String, ? super Integer, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
