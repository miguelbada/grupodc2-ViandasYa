package desappgroupd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import percistence.service.SendMailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Grupodc2ApplicationTests {

    @Autowired
    private SendMailService sendMailService;

    @Test
    public void sendMailTest() {
        sendMailService.sendMail("miguelenriquebada07@gmail.com", "ViandasYa", "Es un test de comprobante de compra");
    }

}
