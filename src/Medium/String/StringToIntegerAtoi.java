package Medium.String;

import static java.lang.Character.isDigit;

public class StringToIntegerAtoi {
    // Atoi function --> Convert String to Integer representation
//    The algorithm for myAtoi(string s) is as follows:
//
//    Whitespace: Ignore any leading whitespace (" ").
//    Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//    Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.


    /**
    "   123" ---> ignore leading whitespace
     "  -23" --> -23
     "   23" -->  23
     "  -042" --> -42 (skip leading zeroes)
     "  -04cb2" --> -4 (stop when non digit character encountered

     */


    public  static  boolean isdigit(char c){
        return c >= '0' && c<= '9';
    }

    public static  int myAtoi(String s){

        //1 - leading whitespaces
        int i = 0;
        int num = 0;
        int sign = 1; //default is positive, -1 for negative

        while(i < s.length() && s.charAt(i) == ' '){
            i = i +1;
        }

        // 2- signedness
        if(i < s.length()){
            if(s.charAt(i) == '-'){
                sign = -1;
                i = i+1;
            }else if(s.charAt(i) == '+'){
                i= i+1;
            }
        }

        // 3- Conversion
        while(i<s.length() && isdigit(s.charAt(i))){

            int digit = s.charAt(i) - '0'; // '6' - '0' = 6

            //4 - Rounding
            if(num == Integer.MAX_VALUE /10){
                if (sign == 1 && digit >= 7) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && digit >= 8) {
                    return Integer.MIN_VALUE;
                }
            }
            if(num > Integer.MAX_VALUE / 10){
                if(sign == 1){
                    return Integer.MAX_VALUE;
                } else{
                    return Integer.MIN_VALUE;
                }
            }


            num =  num * 10 + digit;
            i++;
        }




        return num * sign;
    }




    public static void main(String[] args) {

      String s = "  42";
      int result = myAtoi(s);
        System.out.println(result);
    }
}
