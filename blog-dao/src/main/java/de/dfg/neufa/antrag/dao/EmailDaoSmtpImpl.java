/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-dao
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.antrag.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import de.dfg.neufa.DFGLogging;


/**
 * The Class EmailDaoSmtpImpl.
 */
@Stateless
public class EmailDaoSmtpImpl implements EmailDao {
	
	/** The email session. */
	@Resource(name = "java:jboss/mail/Default")
	private Session emailSession;
	
	/** The Constant TECH. */
	private static final Logger TECH = DFGLogging.getTechLogger(EmailDaoSmtpImpl.class);

	/**
	 * Send.
	 *
	 * @param from the from
	 * @param recipients the recipients
	 * @param subject the subject
	 * @param body the body
	 */
	public void send(String from, List<String> recipients, String subject, String body) {
		try {
			Message message = new MimeMessage(emailSession);
			message.setFrom(new InternetAddress(from));
			for(String recipient : recipients) {
				message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			}
			message.setSubject(subject);
			message.setContent("<p style='border: 2px solid #c0c0c0; border-radius: 12px; padding: 15px; margin: 15px; width: 500px;'><i>"+body+"</i></p>", "text/html; charset=utf-8");
			  
			Transport.send(message);
			TECH.log(Level.INFO, "Email an {0} gesendet.", recipients);
		}
		catch(Exception e) {
			TECH.log(Level.SEVERE, "Kann keine Email senden!", e);
		}
	}
}