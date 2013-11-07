package junit.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;

import org.junit.Test;
import org.nele.mail.GetMailSend;

public class MailTest {

	@Test
	public void test() throws FileNotFoundException, MessagingException {
		GetMailSend.sendMail("nele0716@163.com");
	}

}
