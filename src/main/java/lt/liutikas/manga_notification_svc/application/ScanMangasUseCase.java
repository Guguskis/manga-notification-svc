package lt.liutikas.manga_notification_svc.application;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.in.ScanMangasPort;
import lt.liutikas.manga_notification_svc.application.port.out.CreateNewMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchLatestMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaSubscriptionsPort;
import lt.liutikas.manga_notification_svc.application.port.out.NotifyNewChapterPort;
import lt.liutikas.manga_notification_svc.domain.LatestMangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScanMangasUseCase implements ScanMangasPort {

    private final FetchMangaSubscriptionsPort fetchMangaSubscriptionsPort;
    private final FetchLatestMangaChaptersPort fetchLatestMangaChaptersPort;
    private final CreateNewMangaChaptersPort createNewMangaChaptersPort;
    private final NotifyNewChapterPort notifyNewChapterPort;

    @Override
    public void scan() {

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
