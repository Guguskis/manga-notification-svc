package lt.liutikas.manga_notification_svc.adapter.web.manga;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.out.FetchLatestMangaChaptersPort;
import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MangaPageOrchestrator implements FetchLatestMangaChaptersPort {

    private final MangaPageFactory mangaPageFactory;

    @Override
    public List<LatestMangaChapter> fetch(MangaSubscription subscription) {

        return mangaPageFactory
                .getMangaPage(subscription.getPageUrl())
                .getChapters();
    }
}
