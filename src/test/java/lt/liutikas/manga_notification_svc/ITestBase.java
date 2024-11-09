package lt.liutikas.manga_notification_svc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"itest", "secrets"})
public class ITestBase {

}
