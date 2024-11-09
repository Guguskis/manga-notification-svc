package lt.liutikas.manga_notification_svc.application;

import lt.liutikas.manga_notification_svc.ITestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ScanMangaChaptersUseCaseITest extends ITestBase {

    @Autowired
    private ScanMangaChaptersUseCase scanMangaChaptersUseCase;

    @Test
    void scan() {

        scanMangaChaptersUseCase.scan();
    }

}