package lt.liutikas.manga_notification_svc.adapter.persistence;

import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaSubscriptionsPort;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Repository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Repository
public class MangaSubscriptionRepository implements FetchMangaSubscriptionsPort {

    @Override
    public List<MangaSubscription> fetch() {

        return List.of(
                MangaSubscription.builder()
                        .pageUrl(toUrl("https://readberserk.com/"))
                        .build()
        );
    }

    private URL toUrl(String url) {

        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Bad url", e);
        }
    }
}
