package Medium.String.SLidingWindow;

import java.util.HashSet;

public class MaxVowels {


    public static int maxVowels(String s , int k){
        int max_count = 0, count = 0;

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < k; i++) {
            if(vowels.contains(s.charAt(i))){
                count++;
                max_count = Math.max(count, max_count);
            }
        }

        for(int i =k; i<s.length();i++){

            if(vowels.contains(s.charAt(i-k))){
                count--;
            }
            if(vowels.contains(s.charAt(i))){
                count++;
                max_count = Math.max(count, max_count);
            }
        }
      return max_count;

    }

    public static void main(String[] args) {

        String s = "abciiidef";
        int k = 3;
        int res =  maxVowels(s,k);
        System.out.println(res);
    }

}
