package com.sviatlana.web.command;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.sviatlana.web.model.ActionCommand;
import com.sviatlana.web.model.Constants;
import com.sviatlana.web.services.ConfigurationManager;
import com.sviatlana.web.services.MessageManager;

public class FileUpload implements ActionCommand{
	
	private final static int MAX_MEMORY_SIZE = 1024*1024*50;  // 50 MB
	private final static int MAX_REQUEST_SIZE = 1024*1024*100;// 100 MB
	//private final static int FILE_SIZE_THREHOLD = 1024*1024*10;// 10 MB
    
	private final static Logger logger = LogManager.getLogger("FileUpload"); 
	
	@Override
	public String execute(HttpServletRequest request) {

        String applicationPath = request.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + Constants.getUploadDir();
        String page = null;
        File file = null;
        
        System.out.println("uploadFilePath: " + uploadFilePath);
        System.out.println("applicationPath: " + applicationPath);
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
 
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(MAX_MEMORY_SIZE);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File(uploadFilePath));
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax(MAX_REQUEST_SIZE);
      
        try {
            // Parse the request to get file items.
            List<FileItem> fileItems = upload.parseRequest((RequestContext) request);
            // Process the uploaded file items
            Iterator<FileItem> i = fileItems.iterator();
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fileName = fi.getName();
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(fileSaveDir
                            + fileName.substring(fileName.lastIndexOf("\\")));
                        fileName.substring(fileName.lastIndexOf("\\")+1);
                    } else {
                        file = new File(fileSaveDir
                            + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                } 
            }
            MessageManager.getProperty("message.successUpload");
            logger.log(Level.INFO, "Upload File Directory=" + fileSaveDir.getAbsolutePath());

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
		}
		
        page = ConfigurationManager.getProperty("path.page.main");
        
		return page;
        
	}
}
