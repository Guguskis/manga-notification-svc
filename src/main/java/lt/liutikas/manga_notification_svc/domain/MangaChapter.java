package lt.liutikas.manga_notification_svc.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class MangaChapter {

    private UUID mangaSubscriptionId;
    private String title;
    private String url;
}
