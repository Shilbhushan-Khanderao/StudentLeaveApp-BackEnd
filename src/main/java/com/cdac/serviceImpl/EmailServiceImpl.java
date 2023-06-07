package com.cdac.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.Model.EmailDetails;
import com.cdac.Service.EmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	@Override
	public boolean sendEmail(EmailDetails emailDetails) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setSubject(emailDetails.getSubject());
			mailMessage.setText(emailDetails.getMailBody());
			
			javaMailSender.send(mailMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean sendEmailWithAttachment(EmailDetails emailDetails, MultipartFile file) {
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDetails.getRecipient());
			//mimeMessageHelper.setCc(emailDetails.getCc());
			mimeMessageHelper.setSubject(emailDetails.getSubject());
			if(emailDetails.isHtmlMsg())
				mimeMessageHelper.setText(emailDetails.getMailBody(), true);
			else
				mimeMessageHelper.setText(emailDetails.getMailBody());
			
//			FileSystemResource attachment = new FileSystemResource(file);
			
			mimeMessageHelper.addAttachment(file.getOriginalFilename(), file);
			
			javaMailSender.send(mimeMessage);
//			System.out.println(emailDetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
