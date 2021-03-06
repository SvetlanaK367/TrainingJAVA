package com.sviatlana.web.command;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import com.sviatlana.web.handler.XMLErrorHandler;
import com.sviatlana.web.model.ActionCommand;
import com.sviatlana.web.services.ConfigurationManager;
import com.sviatlana.web.services.MessageManager;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class ValidateSAX implements ActionCommand {
	
	private final static Logger logger = LogManager.getLogger("FileUpload"); 	

	@Override
    public String execute(HttpServletRequest request) {

        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        StringBuilder str = new StringBuilder();
        String page = null;
        String xmlName = null;
        String xsdName = null;

        try {
        	final Part xmlPart = request.getPart("fileXML");
        	xmlName = getFileName(xmlPart);
        	final Part xsdPart = request.getPart("fileXSD");
        	xsdName = getFileName(xsdPart);
        	
            schema = factory.newSchema(new File(xsdName));
            SAXParserFactory spf = SAXParserFactory.newInstance();

            spf.setNamespaceAware(true);
            spf.setSchema(schema);

            SAXParser parser = spf.newSAXParser();

            parser.parse(xmlName, new XMLErrorHandler(str));
            if(str == null || str.length() == 0) {
	            MessageManager.getProperty("message.successUpload");
	            logger.log(Level.INFO, "");
            }            
        } catch (ParserConfigurationException e) {
            System.err.println(xmlName + ": config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(xmlName + ": SAX error: " + e.getMessage());
        } catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
            System.err.println(xmlName + ": I/O error: " + e.getMessage());
        } 
        
        page = ConfigurationManager.getProperty("path.page.main");
        
		return page;
    }

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    logger.log(Level.INFO, "Part Header = {0}", partHeader);
	    
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
