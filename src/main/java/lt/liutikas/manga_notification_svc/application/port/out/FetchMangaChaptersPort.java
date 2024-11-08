package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;

import java.util.List;

public interface FetchMangaChaptersPort {

    List<MangaChapter> fetch(MangaSubscription subscription);
}
