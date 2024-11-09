package lt.liutikas.manga_notification_svc.adapter.web.manga;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MangaPageFactory {

    private final List<MangaPage> mangaPages;

    public MangaPage getMangaPage(URL url) {

        return mangaPages.stream()
                .filter(page -> page.supports(url))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException(
                                "No manga page found for subscription [%s]"
                                        .formatted(url)));
    }
}
