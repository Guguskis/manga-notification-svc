package lt.liutikas.manga_notification_svc.adapter.web;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.out.FetchLatestMangaChaptersPort;
import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MangaPageOrchestrator implements FetchLatestMangaChaptersPort {

    private final List<MangaPage> mangaPages;

    @Override
    public List<LatestMangaChapter> fetch(MangaSubscription subscription) {

        return mangaPages.stream()
                .filter(page -> page.urlSupported(subscription.getPageUrl()))
                .findFirst()
                .map(mangaPage -> mangaPage.getChapters(subscription))
                .orElseThrow(() -> new IllegalStateException(
                        "No manga page found for subscription [%s]"
                                .formatted(subscription.getPageUrl())));
    }
}
