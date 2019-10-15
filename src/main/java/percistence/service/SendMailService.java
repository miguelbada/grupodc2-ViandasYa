package percistence.service;

public interface SendMailService {
    void sendMail(String to, String subject, String text);
}
