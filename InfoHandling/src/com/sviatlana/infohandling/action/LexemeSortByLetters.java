package com.sviatlana.infohandling.action;

import com.sviatlana.infohandling.model.IComponent;
import com.sviatlana.infohandling.model.TextComposite;
import com.sviatlana.infohandling.parse.CharacterParse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LexemeSortByLetters {

    public static String sortLexeme(TextComposite entities) {

        Map<String, Character> lexemeMap = new HashMap<String, Character>();
        LinkedHashMap<String, Character> lexemeSorted = new LinkedHashMap<String, Character>();
        StringBuilder strBuildText = new StringBuilder();

        Iterator iteratorText = entities.getIterator();
        String lexeme = null;
        Character firstLetter = null;

        while (iteratorText.hasNext()) {
            IComponent entityText = (IComponent) iteratorText.next();
            Iterator iteratorParagraph = entityText.getIterator();

            while (iteratorParagraph.hasNext()) {
                IComponent entityParagraph = (IComponent) iteratorParagraph.next();
                Iterator iteratorSentence = entityParagraph.getIterator();

                while (iteratorSentence.hasNext()) {

                    IComponent entitySentence = (IComponent) iteratorSentence.next();
                    Iterator iteratorLexeme = entitySentence.getIterator();

                    while (iteratorLexeme.hasNext()) {
                        IComponent entityLexeme = (IComponent) iteratorLexeme.next();
                        lexeme = entityLexeme.toString().toLowerCase();
                        firstLetter = lexeme.charAt(0);
                        lexemeMap.put(lexeme.trim(), firstLetter);
                    }

                }
            }
        }

        lexemeSorted = lexemeMap.entrySet()
                                .stream()
                                .sorted(Map.Entry.comparingByValue())
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new
                                ));

        Iterator<Map.Entry<String, Character>> iteratorLexeme = lexemeSorted.entrySet().iterator();
        strBuildText.setLength(0);
        Character prevLetter = null;

        while(iteratorLexeme.hasNext()) {
            Map.Entry<String, Character> pair = iteratorLexeme.next();
            String s = pair.getKey();
            Character l = pair.getValue();
            if(l == null || prevLetter == null || l != prevLetter){
                strBuildText.append("\n\t");
            }

            prevLetter = l;
            strBuildText.append(s + "; ");
        }

        return strBuildText.toString();
    }
}
