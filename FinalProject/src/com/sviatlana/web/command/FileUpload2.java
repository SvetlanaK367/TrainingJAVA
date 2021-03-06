package com.sviatlana.web.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sviatlana.web.model.ActionCommand;
import com.sviatlana.web.model.Constants;
import com.sviatlana.web.services.ConfigurationManager;
import com.sviatlana.web.services.MessageManager;

public class FileUpload2 implements ActionCommand{

	private final static Logger logger = LogManager.getLogger("FileUpload"); 

	@Override
	public String execute(HttpServletRequest request) {
	    OutputStream out = null;
	    InputStream filecontent = null;
	    String page = null;
      
        try {
        	String applicationPath = request.getServletContext().getRealPath("");
            String uploadFilePath = applicationPath + File.separator + Constants.getUploadDir();

        	final Part filePart = request.getPart("file");
        	final String fileName = getFileName(filePart);	
        	
        	out = new FileOutputStream(new File(uploadFilePath + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];
            
            logger.log(Level.INFO, "uploadFilePath=" + uploadFilePath + ", fileName = " + fileName);

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            logger.log(Level.INFO, "File{0}being uploaded. ", 
                    new Object[]{fileName, uploadFilePath});
            
            MessageManager.getProperty("message.successUpload");

		} catch (IllegalStateException e) {
			MessageManager.getProperty("message.unsuccessedUpload");
			logger.log(Level.ERROR, "IllegalStateException:" + e);
		} catch (ServletException e) {
			MessageManager.getProperty("message.unsuccessedUpload");
			logger.log(Level.ERROR, "ServletException:" + e);
		} catch (IOException e) {
			MessageManager.getProperty("message.unsuccessedUpload");
			logger.log(Level.ERROR, "IOException:" + e);
		} catch (Exception e) {
			logger.log(Level.ERROR, "Exception:" + e);
		} finally {
			try {
		        if (out != null) {
		            out.close();
		        }
		        if (filecontent != null) {
		            filecontent.close();
		        }
			} catch (Exception e){
				logger.log(Level.ERROR, "Cannot be closed:" + e);
			}
			
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
