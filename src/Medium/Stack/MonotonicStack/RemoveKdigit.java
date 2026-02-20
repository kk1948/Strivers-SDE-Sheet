package Medium.Stack.MonotonicStack;

import java.util.Stack;

public class RemoveKdigit {

    public static  String removeKdigit(String s , int k){
        Stack<Character> st = new Stack<>();

        for(char digit : s.toCharArray()) {

            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }
            st.push(digit);
        }
            //if k still greater than 0
            while (k> 0 && !st.isEmpty()){
                st.pop();
                k--;
            }
            //start building ans with Stringbuilder
            StringBuilder sb = new StringBuilder();
            boolean isleadingzero = true;

            for(char c : st){
                if(isleadingzero && c == '0') continue;
                isleadingzero = false;
                sb.append(c);
            }

         return sb.length() == 0 ? "0" : sb.toString();
    }




    public static void main(String[] args) {
         //String num = "1432219"; k =3
        // String num = "10200"; int k = 1;
         String num = "10200";
         int k = 2;


         String result = removeKdigit(num, k);
        System.out.println(result);

    }
}
