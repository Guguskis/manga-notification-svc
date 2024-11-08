package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;

import java.util.List;

public interface CreateNewMangaChaptersPort {

    List<MangaChapter> create(List<MangaChapter> chapters);
}
