package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.match.Match;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroceryReporter {
    private final String originalFileText;

//    private static final Pattern p = Pattern.compile("(\\\\w+):(\\\\w+);(\\\\w+):(\\\\d.\\\\d{2})");
//    Matcher m = p.matcher(originalFileText);
//    String name, Milk, Bread, Cookies, Apples;
//    public Integer number = 0;

//    public Integer Item(List<Item> numberOfItem, Integer timesViewed) {
//        timesViewed = 0;
//        if (name.equals("milk"))
//            System.out.println(timesViewed++);
//
//        return timesViewed;
//    }
    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
       ItemParser itemParser = new ItemParser();
        List<Item> list = itemParser.parseItemList(originalFileText);
//
//        List<Item> milk = list
//                .stream()
//                .filter(x -> x.getName().equals("milk"))
//                .map( x -> x.getPrice() )
//                .collect(Collectors.toList());

        Map<Double, Long> milk = list
                .stream()
                .filter( x -> x.getName().toLowerCase().equals("milk") )
                .map( x -> x.getPrice())
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(milk.entrySet());

//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//                .collect(Collectors.toList());
//


//        System.out.println("Size: " + list.size());
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }



//        return "GroceryReporter{" +
//                "originalFileText='" + originalFileText + '\'' +
//                '}';


        return null;
    }
}


