package lt.liutikas.manga_notification_svc.application.port.out;

public interface NotifyApplicationErrorPort {

    void notifyError(String message, Exception e);
}
