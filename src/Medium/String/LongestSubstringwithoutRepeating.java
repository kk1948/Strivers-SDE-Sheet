package Medium.String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringwithoutRepeating {


    /// take two variable keft and right which start from(left = 0 & right = 0)
    /// now move right pointer one at a time and check if set contains that charcater or not
    ///  if set not contains, add it to set
    /// if contains, means repeated character is found, so we need to move left pointer such that repeated will get removed from Set
    /// so remove character at left , move left pointer one step at ahead. so compare charcater at right pointer is present innset or not,
    /// if not then stop the left pointer

    public static  int lengthOfLongestSubstring(String s){

        Set<Character> charSet = new HashSet<>();

        int left  =0, maxlength = 0;

        for(int right = 0; right<s.length();right++ ){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxlength = Math.max(maxlength, right -left + 1);

        }
        return maxlength;

    }

    public static void main(String[] args) {

        String s = "pwwkew";
        int res =  lengthOfLongestSubstring(s);
        System.out.println(res);

    }
}
