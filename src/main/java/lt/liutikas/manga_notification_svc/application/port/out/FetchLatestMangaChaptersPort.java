package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;

import java.util.List;

public interface FetchLatestMangaChaptersPort {

    List<LatestMangaChapter> fetch(MangaSubscription subscription);
}
