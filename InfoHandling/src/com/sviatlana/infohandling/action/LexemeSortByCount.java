package com.sviatlana.infohandling.action;

import com.sviatlana.infohandling.model.TextComposite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LexemeSortByCount {
    public static String lexemeSort(TextComposite text) {

        Map<String, Integer> sentenceMap = new HashMap<String, Integer>();
        StringBuilder strBuildText = new StringBuilder();
        LinkedHashMap<String, Integer> sentenceSorted = new LinkedHashMap<String, Integer>();

        LexemeCount.counts(text, sentenceMap);

        sentenceSorted = sentenceMap.entrySet()
                                    .stream()
                                    .sorted(Map.Entry.comparingByValue())
                                    .collect(Collectors.toMap(
                                            Map.Entry::getKey,
                                            Map.Entry::getValue,
                                            (e1, e2) -> e1,
                                            LinkedHashMap::new
                                    ));

        Iterator<Map.Entry<String, Integer>> iter2 = sentenceSorted.entrySet().iterator();
        strBuildText.setLength(0);

        while(iter2.hasNext()) {
            Map.Entry<String, Integer> pair = iter2.next();
            String s = pair.getKey();
            int n = pair.getValue();
            strBuildText.append("Lexemes=" + n + ", " + s + "\n");
        }

        return strBuildText.toString();
    }

}
