package Easy.String;

import java.text.BreakIterator;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {

        String s = "listen";
        String t = "silent";
         boolean result = validAnagramOptimzed(s, t);
        System.out.println(result);

    }

    public static boolean validAnagramOptimzed(String s1, String s2){

        if (s1.length() != s2.length()){
            return  false;
        }

        HashMap<Character,Integer> map= new HashMap<>();
        for(char ch : s1.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        for(char ch1: s2.toCharArray()){
            if(!map.containsKey(ch1)){
                return false;
            }
            map.put(ch1, map.get(ch1) -1);
                if(map.get(ch1)< 0){
                    return false;
                }

        }

        return true;
    }
}
