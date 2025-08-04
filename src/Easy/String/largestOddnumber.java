package Easy.String;

public class largestOddnumber {
    public static void main(String[] args) {
        String s = "1357";
        String finalresullt = largestOddNumber(s);
        System.out.println(finalresullt);
    }

    public static String largestOddNumber(String s){

//        StringBuilder result = new StringBuilder();
//        int n = s.length() ;
//        for(int right = n-1 ; right>= 0; right --){
//            int digit =     s.charAt(right) - '0';
//
//               if(digit % 2 != 0){
//                   result.append(digit);
//               }else{
//                   return "";
//               }
//        }
//       return result.toString();
//        You're building a string in reverse, starting from the right.
//
//        You return immediately when you hit the first even digit, which is incorrect.
//s = "4206"
//
//n = 4
//
//Loop from right to left:
//Iteration	right	s.charAt(right)	       digit	           digit % 2	                Action
//   1	        3	                '6'          	6	   0 (even)	   return " " immediately ❌
//        You’re trying to append digits instead of extracting a substring.

        int n = s.length();

        // Start from the end, find the first odd digit
        for (int i = n - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            if (digit % 2 != 0) {
                return s.substring(0, i + 1);  // return from 0 to that index
            }
        }

        return "";  // No odd digit found
    }
}
