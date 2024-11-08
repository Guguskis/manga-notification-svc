package lt.liutikas.manga_notification_svc.adapter.web;

import lt.liutikas.manga_notification_svc.application.port.out.NotifyNewChapterPort;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import org.springframework.stereotype.Service;

@Service
public class DiscordNotificationService implements NotifyNewChapterPort {

    @Override
    public void notifyNewChapter(MangaChapter chapter) {

    }
}
