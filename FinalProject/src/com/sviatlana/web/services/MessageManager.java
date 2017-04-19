package com.sviatlana.web.services;

import java.util.ResourceBundle;

public class MessageManager {
	
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

	private MessageManager() { }
	
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
