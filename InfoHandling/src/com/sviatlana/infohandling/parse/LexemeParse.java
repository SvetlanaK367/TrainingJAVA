package com.sviatlana.infohandling.parse;

import com.sviatlana.infohandling.model.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParse {

    private static final String LEXEME_SPLIT_REGEX = "(\\s?|\\r\\n?)([\\r\\n]?\\S+[\\p{Punct}]?|[\\r\\n]?)(\\s?|\\r\\n?)";

    public static void parseToLexeme(TextComposite sentenceList, String sentence) {
        Pattern patternLexeme = Pattern.compile(LEXEME_SPLIT_REGEX);
        Matcher matcher = patternLexeme.matcher(sentence);
        String lexeme = null;
        TextComposite lexemeList = new TextComposite();
        String punct = "";

        while (matcher.find()) {
            lexeme = matcher.group().trim();
            if(!lexeme.isEmpty()) {
                punct = lexeme.substring(lexeme.length() - 1);

                if (TextComposite.PUNCTUATIONS.contains(punct)) {
                    CharacterParse.parseToCharacter(lexemeList, lexeme);
                } else {
                    WordParse.parseToWord(lexemeList, lexeme);
                }
            }
        }

        sentenceList.add(lexemeList);

    }
}
