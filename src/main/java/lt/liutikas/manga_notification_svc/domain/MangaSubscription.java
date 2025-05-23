package lt.liutikas.manga_notification_svc.domain;

import lombok.Builder;
import lombok.Data;

import java.net.URL;
import java.util.UUID;

@Data
@Builder
public class MangaSubscription {

    private final UUID id;
    private final String name;
    private final URL pageUrl;
}
