package Medium.String;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharacterbyFrequency {
    public static void main(String[] args) {
        String str = "tree";
        String result = sortCharacterByFrequency(str);
        System.out.println(result);


    }

    public static String sortCharacterByFrequency(String str){

        // Step 1 --> build map with character and its corresponding frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+ 1);
        }

        //Step 2 --> sort the frequencies by value
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
       // list.sort(Map.Entry.comparingByValue());  sorts in ascending order
        //list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));  sorts in descending order

        //Step 3 --> build the final string based on sorting the map by value
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Character,Integer> item : list){
            char ch  = item.getKey();
            int  freq = item.getValue();
            for(int i = 0; i< freq; i++){
                builder.append(ch);
            }
        }

        return String.valueOf(builder);
    }
}
