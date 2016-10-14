package nl.getthere.services;

import nl.getthere.model.EmailEntity;
import nl.getthere.model.EmailRepository;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class StudentMailSender {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private EmailRepository emailRepo;
	

	public void sendEmail(String messageText, String subject, String... emailAddressList) {
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("studentportalph@gmail.com");
			msg.setSubject(subject);
			msg.setText(messageText);
			ArrayList<Student> receivers = new ArrayList<Student>();

			for (String emailAddress : emailAddressList) {
				msg.setTo(emailAddress);
				mailSender.send(msg);

				receivers.add(studentRepo.findByEmailAddress(emailAddress));
			}

			//Save email in repository for access later
			EmailEntity email = new EmailEntity(receivers, subject, messageText);
			emailRepo.save(email);

		} catch (Exception me) {
			System.out.println("Mail kan niet worden verzonden: " + me);
			me.printStackTrace();

		}
	}
}
