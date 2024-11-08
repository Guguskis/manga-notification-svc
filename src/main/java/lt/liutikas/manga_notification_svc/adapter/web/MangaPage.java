package lt.liutikas.manga_notification_svc.adapter.web;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;

import java.net.URL;
import java.util.List;

public interface MangaPage {

    boolean urlSupported(URL url);

    List<MangaChapter> getChapters(MangaSubscription subscription);
}
