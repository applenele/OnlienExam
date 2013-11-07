package org.nele.mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GetMailSend {

	 public static void sendMail(String receiverMailAddress) throws FileNotFoundException, MessagingException{
		 
		Properties props=new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.qq.com");
        
        Session session = Session.getInstance(props,
				new Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("1941973283","apple19920716");
					}
				}
		);
        session.setDebug(true);
        
        Message msg=new MimeMessage(session,new FileInputStream("mail/医学院在线考试系统欢迎您.eml"));
        
        Transport.send(msg,InternetAddress.parse(receiverMailAddress));
	 }
}
