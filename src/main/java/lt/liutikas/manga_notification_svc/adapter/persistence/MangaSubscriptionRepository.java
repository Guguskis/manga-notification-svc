package lt.liutikas.manga_notification_svc.adapter.persistence;

import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaSubscriptionsPort;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static lt.liutikas.manga_notification_svc.common.util.UrlUtils.toUrl;

@Repository
public class MangaSubscriptionRepository implements FetchMangaSubscriptionsPort {

    @Override
    public List<MangaSubscription> fetch() {

        return List.of(
                MangaSubscription.builder()
                        .id(UUID.fromString("d7e41dde-7363-4988-9d54-1430ef96d267"))
                        .pageUrl(toUrl("https://readberserk.com/"))
                        .build(),
                MangaSubscription.builder()
                        .id(UUID.fromString("fd9a04cf-1e6e-40a2-88c3-f38cee3fa3a9"))
                        .pageUrl(toUrl("https://www.mangaread.org/manga/one-punch-man-onepunchman/"))
                        .build()
        );
    }
}
