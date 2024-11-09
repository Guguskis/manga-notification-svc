package lt.liutikas.manga_notification_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MangaNotificationSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangaNotificationSvcApplication.class, args);
	}

}
