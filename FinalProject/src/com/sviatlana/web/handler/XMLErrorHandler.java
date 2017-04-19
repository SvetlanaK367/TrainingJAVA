package com.sviatlana.web.handler;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLErrorHandler extends DefaultHandler {

    private final static Logger logger = LogManager.getLogger("XMLErrorHandler");
    private StringBuilder s;

    public XMLErrorHandler(StringBuilder str) {
        this.s = str;
    }

    public void warning(SAXParseException e) {
        s.append(getLineAddress(e) + "-" + e.getMessage());
        logger.log(Level.WARN,getLineAddress(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        s.append(getLineAddress(e) + "-" + e.getMessage());
        logger.log(Level.ERROR,getLineAddress(e) + " - " + e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException{
        s.append(getLineAddress(e) + "-" + e.getMessage());
        logger.log(Level.FATAL,getLineAddress(e) + " - " + e.getMessage());
        throw new SAXException(getLineAddress(e) + " - " + e.getMessage());
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

    public StringBuilder getResult() {
        return this.s;
    }

}
