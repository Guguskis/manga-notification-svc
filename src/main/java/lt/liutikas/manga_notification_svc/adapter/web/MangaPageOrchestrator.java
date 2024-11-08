package lt.liutikas.manga_notification_svc.adapter.web;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaChaptersPort;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MangaPageOrchestrator implements FetchMangaChaptersPort {

    private final List<MangaPage> mangaPages;

    @Override
    public List<MangaChapter> fetch(MangaSubscription subscription) {

        return mangaPages.stream()
                .filter(page -> page.urlSupported(subscription.getPageUrl()))
                .findFirst()
                .map(mangaPage -> mangaPage.getChapters(subscription))
                .orElseThrow(() -> new IllegalStateException(
                        "No manga page found for subscription [%s]"
                                .formatted(subscription.getPageUrl())));
    }
}
