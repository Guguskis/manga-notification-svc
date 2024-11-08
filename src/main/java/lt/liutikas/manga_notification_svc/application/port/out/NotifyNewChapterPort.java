package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;

public interface NotifyNewChapterPort {

    void notifyNewChapter(MangaChapter chapter);
}
