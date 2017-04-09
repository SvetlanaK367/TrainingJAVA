package com.sviatlana.xml.parser;

import com.sviatlana.xml.model.OldCard;
import com.sviatlana.xml.model.OldCardEnum;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.*;

public class StAXParser {

    private List<OldCard> cardList;
    private OldCard currentCard;
    private XMLInputFactory factory;

    public StAXParser() {
        factory = XMLInputFactory.newInstance();
        cardList = new ArrayList<OldCard>();
    }

    private final Logger logger = LogManager.getLogger("StAXParser");

    public boolean parser(String xmlName) {

        String elementName = null;
        FileInputStream input = null;
        XMLStreamReader reader = null;
        boolean result = true;

        try {
            input = new FileInputStream(new File(xmlName));
            reader = factory.createXMLStreamReader(input);
            result = true;

            while (reader.hasNext()) {

                int type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        elementName = reader.getLocalName();

                        switch (OldCardEnum.valueOf(elementName.toUpperCase())) {
                            case OLDCARDS:
                                break;
                            case CARD:
                                currentCard = new OldCard();
                                currentCard.setRegistration(reader.getAttributeValue(null, OldCardEnum.REGISTRATION.getValue()));
                                currentCard.setAuthor(reader.getAttributeValue(null, OldCardEnum.AUTHOR.getValue()));
                                currentCard.setColored(reader.getAttributeValue(null, OldCardEnum.COLORED.getValue()));
                                break;
                            case YEAR:
                                currentCard.setYear(Integer.parseInt(getXMLText(reader)));
                                break;
                            case COUNTRY:
                                currentCard.setCountry(getXMLText(reader));
                                break;
                            case NUMBERS:
                                currentCard.setNumbers(Integer.parseInt(getXMLText(reader)));
                                break;
                            case CHARACTERISTIC:
                                currentCard.setCharacteristic(getCharacteristic(reader));

                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        elementName = reader.getLocalName();
                        if (OldCardEnum.valueOf(elementName.toUpperCase()) == OldCardEnum.CARD) {
                            cardList.add(currentCard);
                            ;
                        }
                        break;
                }
            }

            for (OldCard card : cardList) {
                System.out.println(card.toString());
            }

        } catch(FileNotFoundException e) {
            logger.log(Level.ERROR, "The file is absent: " + xmlName);
        } catch(XMLStreamException e) {
            logger.log(Level.ERROR, "StAX parsing error. " + e.getMessage());
        } finally{
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible to close the file " + xmlName + " : " + e);
            }
        }

        return result;
    }

    private OldCard.Characteristic getCharacteristic(XMLStreamReader reader) throws XMLStreamException {

        int type;
        String subElementName;
        OldCard.Characteristic currentCharacteristic = currentCard.new Characteristic();

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    subElementName = reader.getLocalName();
                    switch (OldCardEnum.valueOf(subElementName.toUpperCase())) {
                        case VALUABLE:
                            currentCharacteristic.setValuable(getXMLText(reader));
                            break;
                        case THEMA:
                            currentCharacteristic.setThema(getXMLText(reader));
                            break;
                        case TYPE:
                            currentCharacteristic.setType(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    subElementName = reader.getLocalName();
                    if (OldCardEnum.valueOf(subElementName.toUpperCase()) == OldCardEnum.CHARACTERISTIC) {
                        return currentCharacteristic;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Characteristic");
    }

    protected String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }


}

