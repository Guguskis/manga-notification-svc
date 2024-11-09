package lt.liutikas.manga_notification_svc.adapter.persistence;

import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaSubscriptionsPort;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Repository;

import java.util.List;

import static lt.liutikas.manga_notification_svc.common.util.UrlUtils.toUrl;

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
}
