package lt.liutikas.manga_notification_svc.adapter.web;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.common.util.UrlUtils;
import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OnePunchManMangaPage implements MangaPage {

    private static final String PAGE_HOST = "https://www.mangaread.org/manga/one-punch-man-onepunchman/";
    private static final String CHAPTERS_LIST_CSS_SELECTOR = "li.wp-manga-chapter";
    private static final String CHAPTER_TITLE_CSS_SELECTOR = "a";
    private static final String CHAPTER_URL_CSS_SELECTOR = "a";

    private final WebDriver webDriver;

    @Override
    public boolean supports(URL url) {

        return url.toString().equalsIgnoreCase(PAGE_HOST);
    }

    @Override
    public List<LatestMangaChapter> getChapters() {

        String pageBodyHtml = navigateToHomePage();

        return parseMangaChapters(pageBodyHtml);
    }

    private String navigateToHomePage() {

        webDriver.navigate().to(PAGE_HOST);

        return webDriver.getPageSource();
    }

    public List<LatestMangaChapter> parseMangaChapters(String pageBodyHtml) {

        return Jsoup
                .parse(pageBodyHtml)
                .select(CHAPTERS_LIST_CSS_SELECTOR)
                .stream()
                .map(this::toMangaChapter)
                .toList();
    }

    private LatestMangaChapter toMangaChapter(Element chapterItem) {

        String title = chapterItem.select(CHAPTER_TITLE_CSS_SELECTOR).text().trim();
        String url = chapterItem.select(CHAPTER_URL_CSS_SELECTOR).attr("href").trim();

        return LatestMangaChapter.builder()
                .title(title)
                .url(UrlUtils.toUrl(url))
                .build();
    }
}
