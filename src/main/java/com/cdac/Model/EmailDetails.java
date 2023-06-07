package com.cdac.Model;

import org.springframework.web.multipart.MultipartFile;

public class EmailDetails {
	private String recipient;
	private String cc;
	private String mailBody;
	private String subject;
	private MultipartFile attachment;
	private boolean isHtmlMsg;
	
	public EmailDetails() {
		
	}
	
	public EmailDetails(String recipient, String cc, String messageBody, String subject, MultipartFile attachment, boolean isHtmlMsg) {
		this.recipient = recipient;
		this.cc = cc;
		this.mailBody = messageBody;
		this.subject = subject;
		this.attachment = attachment;
		this.isHtmlMsg = isHtmlMsg;
	}
	
	public String getRecipient() {
		return recipient;
	}
	
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getMailBody() {
		return mailBody;
	}
	
	public void setMailBody(String messageBody) {
		this.mailBody = messageBody;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public MultipartFile getAttachment() {
		return attachment;
	}
	
	public void setAttachment(MultipartFile attachment) {
		this.attachment = attachment;
	}

	public boolean isHtmlMsg() {
		return isHtmlMsg;
	}

	public void setHtmlMsg(boolean isHtmlMsg) {
		this.isHtmlMsg = isHtmlMsg;
	}
}
