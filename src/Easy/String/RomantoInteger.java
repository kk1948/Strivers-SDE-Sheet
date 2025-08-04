package Easy.String;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public static void main(String[] args) {
        String s = "III";
        long start = System.nanoTime();  // Start time
        int result = romanToInt(s);
        long end = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Execution time: " + (end - start) + " nanoseconds");
        

    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int currValue = map.get(s.charAt(i));

            // Look ahead to next symbol if it exists
            if (i + 1 < s.length() && currValue < map.get(s.charAt(i + 1))) {
                total -= currValue;
            } else {
                total += currValue;
            }
        }

        return total;
    }
//    public static int romanToInt(String s) {
//        int ans = 0, num = 0;
//        for (int i = s.length()-1; i >= 0; i--) {
//            switch(s.charAt(i)) {
//                case 'I': num = 1; break;
//                case 'V': num = 5; break;
//                case 'X': num = 10; break;
//                case 'L': num = 50; break;
//                case 'C': num = 100; break;
//                case 'D': num = 500; break;
//                case 'M': num = 1000; break;
//            }
//            if (4 * num < ans) ans -= num;
//            else ans += num;
//        }
//        return ans;
//    }
}
