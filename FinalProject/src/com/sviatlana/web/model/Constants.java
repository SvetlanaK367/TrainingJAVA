package com.sviatlana.web.model;

public class Constants {
	protected final static String PROPERTIES_PATH = "resources";
	private final static String DB_PROPERTIES = PROPERTIES_PATH + "\\db.properties";
	protected final static String CONFIG_PROPERTIES = PROPERTIES_PATH + "\\config.properties";
	protected final static String MESSAGE_PROPERTIES = PROPERTIES_PATH + "\\messages.properties";
	private final static String UPLOAD_DIR = "\\data";

	public static String getDBproperties(){
		return DB_PROPERTIES;
	}

	public static String getConfigProperties(){
		return CONFIG_PROPERTIES;
	}
	
	public static String getMessageProperties(){
		return MESSAGE_PROPERTIES;
	}	
	
	public static String getUploadDir(){
		return UPLOAD_DIR;
	}		
	
}
