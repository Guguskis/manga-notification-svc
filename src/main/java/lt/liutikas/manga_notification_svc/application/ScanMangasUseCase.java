package lt.liutikas.manga_notification_svc.application;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.in.ScanMangasPort;
import lt.liutikas.manga_notification_svc.application.port.out.*;
import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScanMangasUseCase implements ScanMangasPort { // todo rename to ScanMangaChaptersUseCase

    private final FetchMangaSubscriptionsPort fetchMangaSubscriptionsPort;
    private final FetchLatestMangaChaptersPort fetchLatestMangaChaptersPort;
    private final CreateNewMangaChaptersPort createNewMangaChaptersPort;
    private final NotifyNewChapterPort notifyNewChapterPort;
    private final NotifyApplicationErrorPort notifyApplicationErrorPort;

    @Override
    public void scan() {

        try {
            scanChapters();
        } catch (Exception e) {
            notifyApplicationErrorPort.notifyError("Failed to scan manga chapters", e);
        }
    }

    private void scanChapters() {
        for (MangaSubscription subscription : fetchMangaSubscriptionsPort.fetch()) {

            List<MangaChapter> newChapters = createNewChapters(subscription);

            for (MangaChapter chapter : newChapters) {
                notifyNewChapterPort.notifyNewChapter(chapter, subscription);
            }

        }
    }

    private List<MangaChapter> createNewChapters(MangaSubscription subscription) {

        List<CreateNewMangaChaptersPort.CreateMangaChapter> chapters =
                fetchLatestMangaChaptersPort.fetch(subscription)
                        .stream()
                        .map(ScanMangasUseCase::toNewChapter)
                        .toList();

        CreateNewMangaChaptersPort.Command command =
                CreateNewMangaChaptersPort.Command.builder()
                        .mangaSubscriptionId(subscription.getId())
                        .chapters(chapters)
                        .build();

        return createNewMangaChaptersPort.create(command);
    }

    private static CreateNewMangaChaptersPort.CreateMangaChapter toNewChapter(LatestMangaChapter chapter) {

        return CreateNewMangaChaptersPort.CreateMangaChapter.builder()
                .title(chapter.getTitle())
                .url(chapter.getUrl())
                .build();
    }
}
