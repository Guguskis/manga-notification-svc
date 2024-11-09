package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;

import java.util.List;
import java.util.UUID;

public interface FetchMangaChaptersBySubscriptionIdPort {

    List<MangaChapter> fetch(UUID mangaSubscriptionId);
}
