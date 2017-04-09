package com.sviatlana.xml.parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {

    public static void parser(String xmlName) throws Exception{

        StringBuilder outDocument = new StringBuilder("");

            File inputFile = new File(xmlName);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            outDocument.append("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("card");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                outDocument.append("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    outDocument.append("Registration: " + eElement.getAttribute("registration"));
                    outDocument.append("Author: " + eElement.getAttribute("author"));
                    outDocument.append("Is colored: " + eElement.getAttribute("colored"));

                    outDocument.append("Publication year: " + eElement
                               .getElementsByTagName("year")
                               .item(0)
                               .getTextContent());
                    outDocument.append("Country: " + eElement
                               .getElementsByTagName("country")
                               .item(0)
                               .getTextContent());
                    outDocument.append("Publication copies: " + eElement
                               .getElementsByTagName("numbers")
                               .item(0)
                               .getTextContent());
                    outDocument.append("Characteristic: " + eElement
                               .getElementsByTagName("characteristic")
                               .item(0)
                               .getTextContent());
                    outDocument.append("Valuable: " + eElement
                            .getElementsByTagName("valuable")
                            .item(0)
                            .getTextContent());
                    outDocument.append("Thema: " + eElement
                            .getElementsByTagName("thema")
                            .item(0)
                            .getTextContent());
                    outDocument.append("Type: " + eElement
                            .getElementsByTagName("type")
                            .item(0)
                            .getTextContent());
                }
            }

        System.out.println(outDocument.toString());
    }
}
