package nl.getthere.services;

import nl.getthere.model.Correspondence;
import nl.getthere.model.CorrespondenceRepository;
import nl.getthere.users.Student;
import nl.getthere.users.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service
public class StudentMailSender {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CorrespondenceRepository correspondenceRepo;
	

	public void sendEmail(String messageText, String subject, String... emailAddressList) {
		try {
			String emailAddressString = "";
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("studentportalph@gmail.com");
			msg.setSubject(subject);
			msg.setText(messageText);
			ArrayList<Student> receivers = new ArrayList<Student>();

			for (String emailAddress : emailAddressList) {
				msg.setTo(emailAddress);
				mailSender.send(msg);
				emailAddressString += emailAddress + ",";
			}

			//Save email in repository for access later
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Correspondence email = new Correspondence(emailAddressString, dateFormat.format(new Date()), subject, messageText, "Email");
			correspondenceRepo.save(email);
			for(Correspondence correspondence : correspondenceRepo.findAll()){
				System.out.println("Correspondence: " + correspondence.getReceivers());
			}
		} catch (Exception me) {
			System.out.println("Mail kan niet worden verzonden: " + me);
			me.printStackTrace();

		}
	}
}
