package com.sviatlana.infohandling.parse;

import com.sviatlana.infohandling.model.LeafPart;
import com.sviatlana.infohandling.model.TextComposite;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterParse {
    private static final String CHARACTER_SPLIT_REGEX = ".{1}";

    public static void parseToCharacter(TextComposite wordList, String word) {

        Pattern pattern = Pattern.compile(CHARACTER_SPLIT_REGEX);
        Matcher matcher = pattern.matcher(word);
        String symbol = "";
        TextComposite LeafList = new TextComposite();

        while (matcher.find()) {
            symbol = matcher.group();
            LeafPart leaf = new LeafPart(symbol);
            LeafList.add(leaf);
        }

        wordList.add(LeafList);
    }
}
