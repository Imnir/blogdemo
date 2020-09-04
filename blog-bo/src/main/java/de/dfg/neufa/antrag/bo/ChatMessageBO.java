/**
 * 
 * Deutsche Forschungsgemeinschaft e.V.
 *
 * Projekt: neufa-antrag-bo
 * Datum: 14.04.2020
 * @author schulze
 * 
 * Copyright (c) 2020, All rights reserved. 
 * 
 **/
package de.dfg.neufa.antrag.bo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

/**
 * The Class ChatMessageBO.
 */
public class ChatMessageBO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private long id = -1;
	
	/** The user name. */
	private String userName = "";
	
	/** The text. */
	private String text = "";
	
	/** The created. */
	private LocalDateTime created = LocalDateTime.now();
	
	/**
	 * Instantiates a new chat message BO.
	 */
	public ChatMessageBO() {

	}
	
	/**
	 * Instantiates a new chat message BO.
	 *
	 * @param userName the user name
	 * @param text the text
	 * @param created the created
	 */
	public ChatMessageBO(String userName,  String text, LocalDateTime created) {
		this.userName=userName;
		this.text=text;
		this.created=created;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public LocalDateTime getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the new created
	 */
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	/**
	 * Checks if is me.
	 *
	 * @param currentUser the current user
	 * @return true, if is me
	 */
	public boolean isMe(String currentUser) {
		return this.getUserName().equals(currentUser);
	}
	
	/**
	 * Gets the initialen.
	 *
	 * @return the initialen
	 */
	public String getInitialen() {
		StringBuilder initialen = new StringBuilder();
		if(this.getUserName()!=null && this.getUserName().length()>1) {
			StringTokenizer st = new StringTokenizer(this.getUserName(), " ");  
		    while (st.hasMoreTokens()) {  
		        initialen.append(st.nextToken().charAt(0));  
		    } 
		}
		if(initialen.toString().length()>2) {
			return initialen.substring(0, 2).toUpperCase();				
		}
		return initialen.toString().toUpperCase();
	}

}
	