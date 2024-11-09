package lt.liutikas.manga_notification_svc.common.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.URL;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UrlUtils {

    public static URL toUrl(String url) {

        try {
            return new URL(url);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse latest manga page URL", e);
        }
    }
}
