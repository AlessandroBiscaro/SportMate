/*
 * This file is generated by jOOQ.
 */
package SportMateInc.SportMateBusinessLayer.tables;


import SportMateInc.SportMateBusinessLayer.DefaultSchema;
import SportMateInc.SportMateBusinessLayer.tables.records.GestoriRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function7;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row7;
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
public class Gestori extends TableImpl<GestoriRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Gestori</code>
     */
    public static final Gestori GESTORI = new Gestori();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GestoriRecord> getRecordType() {
        return GestoriRecord.class;
    }

    /**
     * The column <code>Gestori.idGestore</code>.
     */
    public final TableField<GestoriRecord, Integer> IDGESTORE = createField(DSL.name("idGestore"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>Gestori.nome</code>.
     */
    public final TableField<GestoriRecord, String> NOME = createField(DSL.name("nome"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Gestori.cognome</code>.
     */
    public final TableField<GestoriRecord, String> COGNOME = createField(DSL.name("cognome"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Gestori.dataNascita</code>.
     */
    public final TableField<GestoriRecord, String> DATANASCITA = createField(DSL.name("dataNascita"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Gestori.mail</code>.
     */
    public final TableField<GestoriRecord, String> MAIL = createField(DSL.name("mail"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Gestori.telefono</code>.
     */
    public final TableField<GestoriRecord, String> TELEFONO = createField(DSL.name("telefono"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>Gestori.password</code>.
     */
    public final TableField<GestoriRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.CLOB.nullable(false), this, "");

    private Gestori(Name alias, Table<GestoriRecord> aliased) {
        this(alias, aliased, null);
    }

    private Gestori(Name alias, Table<GestoriRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>Gestori</code> table reference
     */
    public Gestori(String alias) {
        this(DSL.name(alias), GESTORI);
    }

    /**
     * Create an aliased <code>Gestori</code> table reference
     */
    public Gestori(Name alias) {
        this(alias, GESTORI);
    }

    /**
     * Create a <code>Gestori</code> table reference
     */
    public Gestori() {
        this(DSL.name("Gestori"), null);
    }

    public <O extends Record> Gestori(Table<O> child, ForeignKey<O, GestoriRecord> key) {
        super(child, key, GESTORI);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Gestori as(String alias) {
        return new Gestori(DSL.name(alias), this);
    }

    @Override
    public Gestori as(Name alias) {
        return new Gestori(alias, this);
    }

    @Override
    public Gestori as(Table<?> alias) {
        return new Gestori(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Gestori rename(String name) {
        return new Gestori(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gestori rename(Name name) {
        return new Gestori(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gestori rename(Table<?> name) {
        return new Gestori(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function7<? super Integer, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function7<? super Integer, ? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}