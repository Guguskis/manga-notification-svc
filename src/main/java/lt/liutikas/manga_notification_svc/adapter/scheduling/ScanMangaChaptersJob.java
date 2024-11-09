package lt.liutikas.manga_notification_svc.adapter.scheduling;

import lombok.RequiredArgsConstructor;
import lt.liutikas.manga_notification_svc.application.ScanMangasUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScanMangaChaptersJob {

    private final ScanMangasUseCase scanMangasUseCase;

    @Scheduled(cron = "0 0 */4 * * ?")
    public void scanRides() {

        scanMangasUseCase.scan();
    }
}
