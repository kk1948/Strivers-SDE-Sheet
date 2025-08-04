package Easy.String;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
    public static void main(String[] args) {

        String s = "foo"; String t = "bar";
        boolean result =  isIsomorphic(s, t);
        System.out.println(result);

    }


    //Brute force approach

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> St = new HashMap<>();
        Map<Character, Character> Ts = new HashMap<>();
         for(int i = 0; i< s.length(); i++){
             char st = s.charAt(i); char ts = t.charAt(i);
              if(St.containsKey(st) && St.get(st)!= ts) return false;
             if(Ts.containsKey(ts) && Ts.get(ts)!= st) return false;

             St.put(st, ts);
             Ts.put(ts, st);
         }

        return true;
    }
}
