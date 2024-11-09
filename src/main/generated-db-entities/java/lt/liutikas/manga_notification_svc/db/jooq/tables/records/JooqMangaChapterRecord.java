/*
 * This file is generated by jOOQ.
 */
package lt.liutikas.manga_notification_svc.db.jooq.tables.records;


import java.time.LocalDateTime;
import java.util.UUID;

import lt.liutikas.manga_notification_svc.db.jooq.tables.MangaChapter;
import lt.liutikas.manga_notification_svc.db.jooq.tables.pojos.JooqMangaChapter;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JooqMangaChapterRecord extends UpdatableRecordImpl<JooqMangaChapterRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.manga_chapter.id</code>.
     */
    public JooqMangaChapterRecord setId(UUID value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.manga_chapter.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.manga_chapter.manga_subscription_id</code>.
     */
    public JooqMangaChapterRecord setMangaSubscriptionId(UUID value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.manga_chapter.manga_subscription_id</code>.
     */
    public UUID getMangaSubscriptionId() {
        return (UUID) get(1);
    }

    /**
     * Setter for <code>public.manga_chapter.title</code>.
     */
    public JooqMangaChapterRecord setTitle(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.manga_chapter.title</code>.
     */
    public String getTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.manga_chapter.url</code>.
     */
    public JooqMangaChapterRecord setUrl(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.manga_chapter.url</code>.
     */
    public String getUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.manga_chapter.created_on</code>.
     */
    public JooqMangaChapterRecord setCreatedOn(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.manga_chapter.created_on</code>.
     */
    public LocalDateTime getCreatedOn() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.manga_chapter.updated_on</code>.
     */
    public JooqMangaChapterRecord setUpdatedOn(LocalDateTime value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.manga_chapter.updated_on</code>.
     */
    public LocalDateTime getUpdatedOn() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JooqMangaChapterRecord
     */
    public JooqMangaChapterRecord() {
        super(MangaChapter.MANGA_CHAPTER);
    }

    /**
     * Create a detached, initialised JooqMangaChapterRecord
     */
    public JooqMangaChapterRecord(UUID id, UUID mangaSubscriptionId, String title, String url, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super(MangaChapter.MANGA_CHAPTER);

        setId(id);
        setMangaSubscriptionId(mangaSubscriptionId);
        setTitle(title);
        setUrl(url);
        setCreatedOn(createdOn);
        setUpdatedOn(updatedOn);
    }

    /**
     * Create a detached, initialised JooqMangaChapterRecord
     */
    public JooqMangaChapterRecord(JooqMangaChapter value) {
        super(MangaChapter.MANGA_CHAPTER);

        if (value != null) {
            setId(value.getId());
            setMangaSubscriptionId(value.getMangaSubscriptionId());
            setTitle(value.getTitle());
            setUrl(value.getUrl());
            setCreatedOn(value.getCreatedOn());
            setUpdatedOn(value.getUpdatedOn());
        }
    }
}