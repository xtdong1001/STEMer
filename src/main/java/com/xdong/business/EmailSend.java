package com.xdong.business;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSend {
	public static void send(String from, String to, String subject, String body) {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		//have no time to write a password decryption method
		email.setAuthenticator(new DefaultAuthenticator("xtdong1001@gmail.com", "8530@dong"));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(from);
			email.setSubject(subject);
			email.setMsg(body);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
