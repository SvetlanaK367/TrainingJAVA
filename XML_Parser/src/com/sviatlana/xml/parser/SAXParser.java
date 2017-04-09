package com.sviatlana.xml.parser;

import com.sviatlana.xml.handler.SAXHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXException;
import java.io.IOException;

public class SAXParser {

    public static void parser(String xmlName) throws SAXException, IOException{

        XMLReader reader = XMLReaderFactory.createXMLReader();
        SAXHandler handler = new SAXHandler();

        reader.setContentHandler(handler);
        reader.parse(xmlName);
    }
}
