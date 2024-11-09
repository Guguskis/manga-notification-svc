package lt.liutikas.manga_notification_svc.domain;

import lombok.Builder;
import lombok.Data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class MangaChapter {

    private UUID id;
    private UUID mangaSubscriptionId;
    private String title;
    private URL url;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
