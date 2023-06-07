package com.cdac.Service;

import org.springframework.web.multipart.MultipartFile;

import com.cdac.Model.EmailDetails;

public interface EmailService {

	boolean sendEmail(EmailDetails emailDetails);

	boolean sendEmailWithAttachment(EmailDetails emailDetails, MultipartFile file);
}
