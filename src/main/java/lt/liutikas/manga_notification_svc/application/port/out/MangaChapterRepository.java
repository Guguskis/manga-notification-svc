package lt.liutikas.manga_notification_svc.application.port.out;

import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MangaChapterRepository implements CreateNewMangaChaptersPort {
    @Override
    public List<MangaChapter> create(List<MangaChapter> chapters) {

        return List.of();
    }
}
