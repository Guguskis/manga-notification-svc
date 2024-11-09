package lt.liutikas.manga_notification_svc.application;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.out.CreateMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.CreateNewMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaChaptersBySubscriptionIdPort;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CreateNewMangaChaptersUseCase implements CreateNewMangaChaptersPort {

    private final FetchMangaChaptersBySubscriptionIdPort fetchMangaChaptersBySubscriptionIdPort;
    private final CreateMangaChaptersPort createMangaChaptersPort;

    @Override
    public List<MangaChapter> create(Command command) {

        UUID subscriptionId = command.getMangaSubscriptionId();
        List<CreateMangaChapter> chapters = command.getChapters();

        List<MangaChapter> existingChapters = fetchMangaChaptersBySubscriptionIdPort.fetch(subscriptionId);

        List<MangaChapter> newChapters =
                filterNewChapters(chapters, existingChapters)
                        .stream()
                        .map(chapter -> toMangaChapter(subscriptionId, chapter))
                        .toList();

        return createMangaChaptersPort.create(newChapters);
    }

    private List<CreateMangaChapter> filterNewChapters(List<CreateMangaChapter> chapters, List<MangaChapter> existingChapters) {

        Set<String> existingTitles = existingChapters.stream()
                .map(MangaChapter::getTitle)
                .collect(Collectors.toSet());

        return chapters.stream()
                .filter(chapter -> !existingTitles.contains(chapter.getTitle()))
                .toList();
    }

    private MangaChapter toMangaChapter(UUID subscriptionId, CreateMangaChapter chapter) {

        LocalDateTime now = LocalDateTime.now();

        return MangaChapter.builder()
                .id(UUID.randomUUID())
                .mangaSubscriptionId(subscriptionId)
                .title(chapter.getTitle())
                .url(chapter.getUrl())
                .createdOn(now)
                .updatedOn(now)
                .build();
    }
}
