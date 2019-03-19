package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    String  valueToParse;
    public List<Item> parseItemList(String valueToParse) {
        List<Item> newList = new ArrayList<>();
        String[] str = valueToParse.split("##");

        for (int i = 0; i < str.length; i++) {
            try {
                //parseSingleItem(str[i]);
                newList.add(parseSingleItem(str[i]));
                //System.out.println(newList);
            } catch (ItemParseException e) {
                e.printStackTrace();
            }
        }
        return newList ;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        try {
            singleItem = singleItem.replaceAll("#", "");
            StringTokenizer tokenizer = new StringTokenizer(singleItem, ";");
            String[][] container = new String[4][2];
            int count = 0;
            while (tokenizer.hasMoreTokens()) {
                container[count] = splitter(tokenizer.nextToken());
                count++;
            }

            Item item = new Item(container[0][1].toLowerCase(), Double.parseDouble(container[1][1]),
                    container[2][1].toLowerCase(), container[3][1]);

            return item;
        }
        catch (Exception e){
            throw new ItemParseException();
        }
    }
    private String[] splitter(String nextToken) {
        String s = changingword("(:|@|\\^|\\*|%)",":",nextToken);
        String[] s1 = s.split(":");
        return s1;
    }
    public String changingword (String wordSource, String wordDestiny ,String textSource) {
        Pattern p = Pattern.compile(wordSource);
        Matcher m = p.matcher(textSource);
        return m.replaceAll(wordDestiny);
    }
}