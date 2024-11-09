package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;

public interface NotifyNewChapterPort {

    void notifyNewChapter(MangaChapter chapter, MangaSubscription subscription);
}
