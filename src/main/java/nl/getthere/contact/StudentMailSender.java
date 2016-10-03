package nl.getthere.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class StudentMailSender {
	
	@Autowired 
	private JavaMailSender mailSender;
	
	public void sendEmail(String messageText, String... emailAddressList) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setText(messageText);
			
			for(String emailAddress : emailAddressList){
				msg.setTo(emailAddress);
				mailSender.send(msg);
			}
		} catch (Exception me) {
			System.out.println("Mail kan niet worden verzonden." + me);
		}
	}
	
	public void sendWelcomeEmail(String firstName, String... emailAddressList) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setText("Hoi " + firstName + "! Welkom bij het Get There Student Portal. Leuk dat je je hebt ingeschreven!");
			
			for(String emailAddress : emailAddressList){
				msg.setTo(emailAddress);
				mailSender.send(msg);
			}
		} catch (Exception me) {
			System.out.println("Mail kan niet worden verzonden." + me);
		}
	}

}
