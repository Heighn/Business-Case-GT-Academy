package nl.getthere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class StudentMailSender {

	@Autowired
	private JavaMailSender mailSender;
	

	public void sendEmail(String messageText, String subject, String... emailAddressList) {

		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("studentportalph@gmail.com");
			msg.setSubject(subject);
			msg.setText(messageText);


			for (String emailAddress : emailAddressList) {
				msg.setTo(emailAddress);
				mailSender.send(msg);
			}

		} catch (Exception me) {
			System.out.println("Mail kan niet worden verzonden: " + me);
			me.printStackTrace();

		}
	}
}
