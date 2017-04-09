package com.sviatlana.infohandling.parse;

import com.sviatlana.infohandling.model.TextComposite;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParse {

    private static final String SENTENCE_SPLIT_REGEX = "([^(\\.|!|\\?)]+)(\\.|!|\\?)";

    public static void parseToSentence (TextComposite paragraphList, String paragraph) {

        Pattern patternSentence = Pattern.compile(SENTENCE_SPLIT_REGEX);
        Matcher matcher = patternSentence.matcher(paragraph);
        String sentence = null;
        TextComposite sentenceList = new TextComposite();

        while (matcher.find()) {
            sentence = matcher.group();
            LexemeParse.parseToLexeme(sentenceList, sentence);
        }
        paragraphList.add(sentenceList);
        //System.out.println(sentenceList.toString());
    }


}
