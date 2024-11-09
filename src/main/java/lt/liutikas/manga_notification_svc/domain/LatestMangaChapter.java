package lt.liutikas.manga_notification_svc.domain;

import lombok.Builder;
import lombok.Data;

import java.net.URL;

@Data
@Builder
public class LatestMangaChapter {

    private final String title;
    private final URL url;
}
