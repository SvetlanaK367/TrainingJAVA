package com.sviatlana.infohandling.parse;

import com.sviatlana.infohandling.model.TextComposite;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParse {

    private static final String WORD_SPLIT_REGEX = "(\\s?|\\r\\n?)(\\S+)(\\s?|\\r\\n?)";

    public static void parseToWord(TextComposite lexemeList, String lexeme) {
        Pattern patternWord = Pattern.compile(WORD_SPLIT_REGEX);
        Matcher matcher = patternWord.matcher(lexeme);
        String word = null;
        TextComposite wordList = new TextComposite();

        while (matcher.find()) {
            word = matcher.group().trim();
            CharacterParse.parseToCharacter(wordList, word);
        }

        lexemeList.add(wordList);

    }

}
