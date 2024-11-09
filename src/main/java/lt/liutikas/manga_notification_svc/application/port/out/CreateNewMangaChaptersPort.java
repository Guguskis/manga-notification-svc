package lt.liutikas.manga_notification_svc.application.port.out;

import lombok.Builder;
import lombok.Data;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;

import java.net.URL;
import java.util.List;
import java.util.UUID;

public interface CreateNewMangaChaptersPort {

    List<MangaChapter> create(Command command);

    @Data
    @Builder
    class Command {

        private final UUID mangaSubscriptionId;
        private final List<CreateMangaChapter> chapters;
    }

    @Data
    @Builder
    class CreateMangaChapter {

        private final String title;
        private final URL url;
    }
}
