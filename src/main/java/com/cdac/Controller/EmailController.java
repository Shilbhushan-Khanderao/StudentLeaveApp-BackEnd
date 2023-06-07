package com.cdac.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.Model.EmailDetails;
import com.cdac.Service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@ModelAttribute EmailDetails emailDetails){
		boolean emailsent = false;
//		System.out.println(emailDetails);
		if(emailDetails.getAttachment() != null) 
			emailsent = emailService.sendEmailWithAttachment(emailDetails,emailDetails.getAttachment());
		else
			emailsent = emailService.sendEmail(emailDetails);
		
		System.out.println(emailsent);
		
		if(emailsent)
			return ResponseEntity.ok("Email Sent Successfully...");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in Sending Mail...!!!");
	}
}
