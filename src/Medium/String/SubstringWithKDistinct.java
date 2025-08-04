package Medium.String;

import java.util.HashSet;

public class SubstringWithKDistinct {
    public static void main(String[] args) {
        String s = "aa";
        int result = countSubstringsWithKDistinct(s, 1);
        System.out.println(result);

    }

    public static int countSubstringsWithKDistinct(String s, int k){
        //take a counter variable to store the count
        int count = 0;

        //take two loops ine start with first element and another start with next element
        for(int i = 0; i< s.length(); i++){

            //take a hashset to store the unique character
            HashSet<Character> characters = new HashSet<>();
            for(int j = i; j< s.length(); j++){

                characters.add(s.charAt(j));

                if(characters.size() > k) break;
                if(characters.size() == k) count++;

            }

        }
         return count;
    }
}
