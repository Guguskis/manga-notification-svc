/*
 * This file is generated by jOOQ.
 */
package lt.liutikas.manga_notification_svc.db.jooq.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import lt.liutikas.manga_notification_svc.db.jooq.Indexes;
import lt.liutikas.manga_notification_svc.db.jooq.Keys;
import lt.liutikas.manga_notification_svc.db.jooq.Public;
import lt.liutikas.manga_notification_svc.db.jooq.tables.records.JooqMangaChapterRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MangaChapter extends TableImpl<JooqMangaChapterRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.manga_chapter</code>
     */
    public static final MangaChapter MANGA_CHAPTER = new MangaChapter();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JooqMangaChapterRecord> getRecordType() {
        return JooqMangaChapterRecord.class;
    }

    /**
     * The column <code>public.manga_chapter.id</code>.
     */
    public final TableField<JooqMangaChapterRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.manga_chapter.manga_subscription_id</code>.
     */
    public final TableField<JooqMangaChapterRecord, UUID> MANGA_SUBSCRIPTION_ID = createField(DSL.name("manga_subscription_id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.manga_chapter.title</code>.
     */
    public final TableField<JooqMangaChapterRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.manga_chapter.url</code>.
     */
    public final TableField<JooqMangaChapterRecord, String> URL = createField(DSL.name("url"), SQLDataType.VARCHAR(1028).nullable(false), this, "");

    /**
     * The column <code>public.manga_chapter.created_on</code>.
     */
    public final TableField<JooqMangaChapterRecord, LocalDateTime> CREATED_ON = createField(DSL.name("created_on"), SQLDataType.LOCALDATETIME(3).nullable(false), this, "");

    /**
     * The column <code>public.manga_chapter.updated_on</code>.
     */
    public final TableField<JooqMangaChapterRecord, LocalDateTime> UPDATED_ON = createField(DSL.name("updated_on"), SQLDataType.LOCALDATETIME(3).nullable(false), this, "");

    private MangaChapter(Name alias, Table<JooqMangaChapterRecord> aliased) {
        this(alias, aliased, null);
    }

    private MangaChapter(Name alias, Table<JooqMangaChapterRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.manga_chapter</code> table reference
     */
    public MangaChapter(String alias) {
        this(DSL.name(alias), MANGA_CHAPTER);
    }

    /**
     * Create an aliased <code>public.manga_chapter</code> table reference
     */
    public MangaChapter(Name alias) {
        this(alias, MANGA_CHAPTER);
    }

    /**
     * Create a <code>public.manga_chapter</code> table reference
     */
    public MangaChapter() {
        this(DSL.name("manga_chapter"), null);
    }

    public <O extends Record> MangaChapter(Table<O> child, ForeignKey<O, JooqMangaChapterRecord> key) {
        super(child, key, MANGA_CHAPTER);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.asList(Indexes.IDX_MANGA_CHAPTER_SUBSCRIPTION_ID);
    }

    @Override
    public UniqueKey<JooqMangaChapterRecord> getPrimaryKey() {
        return Keys.MANGA_CHAPTER_PKEY;
    }

    @Override
    public MangaChapter as(String alias) {
        return new MangaChapter(DSL.name(alias), this);
    }

    @Override
    public MangaChapter as(Name alias) {
        return new MangaChapter(alias, this);
    }

    @Override
    public MangaChapter as(Table<?> alias) {
        return new MangaChapter(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public MangaChapter rename(String name) {
        return new MangaChapter(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MangaChapter rename(Name name) {
        return new MangaChapter(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public MangaChapter rename(Table<?> name) {
        return new MangaChapter(name.getQualifiedName(), null);
    }
}