package lt.liutikas.manga_notification_svc.application;

import lt.liutikas.manga_notification_svc.ITestBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ScanMangasUseCaseITest extends ITestBase {

    @Autowired
    private ScanMangasUseCase scanMangasUseCase;

    @Test
    void scan() {

        scanMangasUseCase.scan();
    }

}