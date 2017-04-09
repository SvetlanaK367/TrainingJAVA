package com.sviatlana.infohandling.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextComposite implements IComponent {
    public final static String PUNCTUATIONS = ".,:;!?";

    private IComponent entity;
    private List<IComponent> entities = new ArrayList<IComponent>();

    public TextComposite() { }

    @Override
    public IComponent getComponent(int i) { return entities.get(i); }

    @Override
    public void setEntity(IComponent entity) { this.entity = entity; }

    @Override
    public void add(IComponent value) {
        if (value != null) {
            entities.add(value);
        }
    }

    @Override
    public void remove(IComponent value) {
        entities.remove(value);
    }

    @Override
    public Iterator<IComponent> getIterator() {
        return entities.iterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (this.entities.isEmpty()) {
            result.append(this);
        } else {
            for (IComponent child : this.entities) {
                result.append(child.toString());
            }
        }
        result.append(" ");
        return result.toString();
    }

    public String assembleText() {
        StringBuilder parseText = new StringBuilder();

        if (entities != null || !entities.isEmpty()) {
            Iterator iteratorText = entities.iterator();
            while (iteratorText.hasNext()) {
                IComponent entityText = (IComponent) iteratorText.next();
                Iterator iteratorParagraph = entityText.getIterator();

                while (iteratorParagraph.hasNext()) {
                    parseText.append("\t");
                    IComponent entityParagraph = (IComponent) iteratorParagraph.next();
                    Iterator iteratorSentence = entityParagraph.getIterator();

                    while (iteratorSentence.hasNext()) {
                        IComponent entitySentence = (IComponent) iteratorSentence.next();
                        Iterator iteratorLexeme = entitySentence.getIterator();

                        while (iteratorLexeme.hasNext()) {
                            IComponent entityLexeme = (IComponent) iteratorLexeme.next();
                            parseText.append(entityLexeme);
                            //parseText.append(" ");
                        }
                    }
                    parseText.append("\n");
                }

            }
        }
        return parseText.toString();
    }
}

