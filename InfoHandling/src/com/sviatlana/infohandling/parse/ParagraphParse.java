package com.sviatlana.infohandling.parse;

import com.sviatlana.infohandling.model.TextComposite;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParse {

    private static final String PARAGRAPH_SPLIT_REGEX = "[^\\t]+";

    public static void parseToParagraph(TextComposite wholeText, String text) {

        Pattern patternParagraph = Pattern.compile(PARAGRAPH_SPLIT_REGEX);
        Matcher matcher = patternParagraph.matcher(text);
        String paragraph = "";
        int index = 0;
        TextComposite paragraphList = new TextComposite();

        while (matcher.find()) {
            paragraph = matcher.group();
            SentenceParse.parseToSentence(paragraphList, paragraph);
        }

        wholeText.add(paragraphList);
    }

}
