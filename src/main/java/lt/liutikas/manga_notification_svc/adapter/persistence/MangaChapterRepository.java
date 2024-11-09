package lt.liutikas.manga_notification_svc.adapter.persistence;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.out.CreateMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaChaptersBySubscriptionIdPort;
import lt.liutikas.manga_notification_svc.db.jooq.tables.records.JooqMangaChapterRecord;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static lt.liutikas.manga_notification_svc.common.util.UrlUtils.toUrl;
import static lt.liutikas.manga_notification_svc.db.jooq.Tables.MANGA_CHAPTER;

@Repository
@RequiredArgsConstructor
public class MangaChapterRepository implements
        FetchMangaChaptersBySubscriptionIdPort,
        CreateMangaChaptersPort {

    private final DSLContext dslContext;

    @Override
    public List<MangaChapter> fetch(UUID mangaSubscriptionId) {

        return dslContext.selectFrom(MANGA_CHAPTER)
                .where(MANGA_CHAPTER.MANGA_SUBSCRIPTION_ID.eq(mangaSubscriptionId))
                .fetch()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public List<MangaChapter> create(List<MangaChapter> chapters) {

        List<JooqMangaChapterRecord> jooqRecords = chapters.stream()
                .map(this::toJooq)
                .toList();

        dslContext.batchInsert(jooqRecords).execute();

        return chapters;
    }

    private MangaChapter toDomain(JooqMangaChapterRecord record) {

        return MangaChapter.builder()
                .id(record.getId())
                .mangaSubscriptionId(record.getMangaSubscriptionId())
                .title(record.getTitle())
                .url(toUrl(record.getUrl()))
                .createdOn(record.getCreatedOn())
                .updatedOn(record.getUpdatedOn())
                .build();
    }

    private JooqMangaChapterRecord toJooq(MangaChapter chapter) {

        JooqMangaChapterRecord jooqRecord = new JooqMangaChapterRecord();

        jooqRecord.setId(chapter.getId());
        jooqRecord.setMangaSubscriptionId(chapter.getMangaSubscriptionId());
        jooqRecord.setTitle(chapter.getTitle());
        jooqRecord.setUrl(chapter.getUrl().toString());
        jooqRecord.setCreatedOn(chapter.getCreatedOn());
        jooqRecord.setUpdatedOn(chapter.getUpdatedOn());

        return jooqRecord;
    }
}
