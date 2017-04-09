package com.sviatlana.infohandling.action;

import com.sviatlana.infohandling.model.IComponent;
import com.sviatlana.infohandling.model.TextComposite;

import java.util.Iterator;
import java.util.Map;

public class LexemeCount {

    public static void counts(TextComposite entities, Map<String, Integer> sentenceMap) {

        Iterator iteratorText = entities.getIterator();
        String sentence = null;
        int lexeme = 0;

        while (iteratorText.hasNext()) {
            IComponent entityText = (IComponent) iteratorText.next();
            Iterator iteratorParagraph = entityText.getIterator();

            while (iteratorParagraph.hasNext()) {
                IComponent entityParagraph = (IComponent) iteratorParagraph.next();
                Iterator iteratorSentence = entityParagraph.getIterator();

                while (iteratorSentence.hasNext()) {

                    lexeme = 0;
                    IComponent entitySentence = (IComponent) iteratorSentence.next();
                    sentence = entitySentence.toString();
                    Iterator iteratorLexeme = entitySentence.getIterator();

                    while (iteratorLexeme.hasNext()) {
                        IComponent entityLexeme = (IComponent) iteratorLexeme.next();
                        lexeme++;
                    }
                    sentenceMap.put(sentence, lexeme);
                }
            }
        }

    }
}
