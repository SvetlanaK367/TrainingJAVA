package com.sviatlana.xml.validate;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import com.sviatlana.xml.handler.XMLErrorHandler;
import org.xml.sax.SAXException;

public class ValidatorSAX {

    public static boolean validateSAX(String xmlName, String xsdName) {

        System.setProperty("javax.xml.parsers.SAXParserFactory", "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");

        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        boolean result = false;
        StringBuilder str = new StringBuilder();

        try {
            // установка проверки с использованием XSD
            schema = factory.newSchema(new File(xsdName));
            SAXParserFactory spf = SAXParserFactory.newInstance();

            //spf.setValidating(false);
            spf.setNamespaceAware(true);
            spf.setSchema(schema);
            // создание объекта-парсера
            SAXParser parser = spf.newSAXParser();
            // установка обработчика ошибок и запуск

            parser.parse(xmlName, new XMLErrorHandler(str));
            if(str == null || str.length() == 0) {
                result = true;
            }

        } catch (ParserConfigurationException e) {
            System.err.println(xmlName + ": config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(xmlName + ": SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println(xmlName + ": I/O error: " + e.getMessage());
        }

        return result;
    }
}
