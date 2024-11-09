package lt.liutikas.manga_notification_svc.adapter.persistence;

import lt.liutikas.manga_notification_svc.application.port.out.CreateMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaChaptersBySubscriptionIdPort;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MangaChapterRepository implements
        FetchMangaChaptersBySubscriptionIdPort,
        CreateMangaChaptersPort {

    @Override
    public List<MangaChapter> fetch(UUID mangaSubscriptionId) {

        return List.of();
    }

    @Override
    public List<MangaChapter> create(List<MangaChapter> chapters) {

        return List.of();
    }
}
