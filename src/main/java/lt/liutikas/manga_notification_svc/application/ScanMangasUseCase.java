package lt.liutikas.manga_notification_svc.application;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.port.in.ScanMangasPort;
import lt.liutikas.manga_notification_svc.application.port.out.CreateNewMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaChaptersPort;
import lt.liutikas.manga_notification_svc.application.port.out.FetchMangaSubscriptionsPort;
import lt.liutikas.manga_notification_svc.application.port.out.NotifyNewChapterPort;
import lt.liutikas.manga_notification_svc.domain.MangaChapter;
import lt.liutikas.manga_notification_svc.domain.MangaSubscription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScanMangasUseCase implements ScanMangasPort {

    private final FetchMangaSubscriptionsPort fetchMangaSubscriptionsPort;
    private final FetchMangaChaptersPort fetchMangaChaptersPort;
    private final CreateNewMangaChaptersPort createNewMangaChaptersPort;
    private final NotifyNewChapterPort notifyNewChapterPort;

    @Override
    public void scan() {

        List<MangaSubscription> subscriptions = fetchMangaSubscriptionsPort.fetch();

        for (MangaSubscription subscription : subscriptions) {

            List<MangaChapter> chapters = fetchMangaChaptersPort.fetch(subscription);
            List<MangaChapter> newChapters = createNewMangaChaptersPort.create(chapters);

            for (MangaChapter newChapter : newChapters) {

                notifyNewChapterPort.notifyNewChapter(newChapter);
            }
        }
    }
}
