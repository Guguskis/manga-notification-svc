package lt.liutikas.manga_notification_svc.adapter.web;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.out.NotifyApplicationErrorPort;
import lt.liutikas.manga_notification_svc.application.port.out.NotifyNewChapterPort;
import lt.liutikas.manga_notification_svc.common.util.Loggable;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.ActionRow;
import org.javacord.api.entity.message.component.Button;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
@RequiredArgsConstructor
public class DiscordNotificationService implements
        Loggable,
        NotifyNewChapterPort,
        NotifyApplicationErrorPort {

    private static final String HEADER_NEW_CHAPTER = "New chapter!";

    private final ServerTextChannel channel;

    @Override
    public void notifyNewChapter(MangaChapter chapter, MangaSubscription subscription) {

        getLogger().info("Sending new notification for [{}] chapter [{}]", subscription.getName(), chapter.getTitle());

        new MessageBuilder()
                .addComponents(linkButton(chapter.getUrl()))
                .setContent(buildUnformattedContent(chapter, subscription))
                .send(channel)
                .thenAcceptAsync(action -> action
                        .edit(buildFormattedContent(chapter, subscription))
                        .join()
                )
                .join();
    }

    @Override
    public void notifyError(String message, Exception e) {

        new MessageBuilder()
                .setContent(message)
                .send(channel)
                .thenAcceptAsync(action -> action
                        .edit(buildFormattedContent(message, e))
                        .join()
                )
                .join();
    }

    private String buildUnformattedContent(MangaChapter chapter, MangaSubscription mangaSubscription) {

        return """
                %s
                Manga: %s
                Chapter: %s
                                
                """
                .formatted(
                        HEADER_NEW_CHAPTER,
                        mangaSubscription.getName(),
                        chapter.getTitle()
                );
    }

    private String buildFormattedContent(MangaChapter chapter, MangaSubscription mangaSubscription) {

        return """
                ## %s
                > **Manga**: `%s`
                > **Chapter**: `%s`
                                
                """
                .formatted(
                        HEADER_NEW_CHAPTER,
                        mangaSubscription.getName(),
                        chapter.getTitle()
                );
    }

    private String buildFormattedContent(String message, Exception e) {

        return """
                ## %s
                ```diff
                - %s
                ```
                """.formatted(message, e.toString());
    }

    private static ActionRow linkButton(URL url) {

        return ActionRow.of(
                Button.link(url.toString(), "Read")
        );
    }
}
