package lt.liutikas.manga_notification_svc.adapter.web.manga;

import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;

import java.net.URL;
import java.util.List;

public interface MangaPage {

    boolean supports(URL url);

    List<LatestMangaChapter> getChapters();
}
