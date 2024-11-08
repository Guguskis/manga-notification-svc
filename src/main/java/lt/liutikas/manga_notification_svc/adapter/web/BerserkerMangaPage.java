package lt.liutikas.manga_notification_svc.adapter.web;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BerserkerMangaPage implements MangaPage {

    private static final String PAGE_HOST = "readberserk.com";
    private static final String CHAPTERS_LIST_CSS_SELECTOR = "tbody.no-border-x tr";
    private static final String CHAPTER_TITLE_CSS_SELECTOR = "td";
    private static final String CHAPTER_URL_CSS_SELECTOR = "td a";

    private final WebDriver webDriver;

    @Override
    public boolean urlSupported(URL url) {

        return url.getHost().equalsIgnoreCase(PAGE_HOST);
    }

    @Override
    public List<MangaChapter> getChapters(MangaSubscription subscription) {

        String pageBodyHtml = navigateToHomePage();

        return parseMangaChapters(pageBodyHtml, subscription);
    }

    private String navigateToHomePage() {

        webDriver.navigate().to("https://" + PAGE_HOST);

        return webDriver.getPageSource();
    }

    public List<MangaChapter> parseMangaChapters(String pageBodyHtml, MangaSubscription subscription) {

        return Jsoup
                .parse(pageBodyHtml)
                .select(CHAPTERS_LIST_CSS_SELECTOR)
                .stream()
                .map(chapterItem -> toMangaChapter(chapterItem, subscription))
                .toList();
    }

    private MangaChapter toMangaChapter(Element chapterItem, MangaSubscription subscription) {

        String title = chapterItem.select(CHAPTER_TITLE_CSS_SELECTOR).get(0).text();
        String url = chapterItem.select(CHAPTER_URL_CSS_SELECTOR).attr("href");

        return MangaChapter.builder()
                .mangaSubscriptionId(subscription.getId())
                .title(title)
                .url(url)
                .build();
    }
}
