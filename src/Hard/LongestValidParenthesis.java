package Hard;

import java.util.Stack;

public class LongestValidParenthesis {


    public static int longestValidParenthesis(String s) {
//        Stack<Character> stack = new Stack<>();
//
//        for(int i = 0; i<s.length();i++){
//            if(s.charAt(i) == '(' || s.charAt(i+1))
//        }

//        int  count = 0;
//        for(int i = 1;i<s.length();i++){
//            if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
//                continue;
//            }else {
//                count = count + 2;
//            }
//        }
//
//        return  count;


        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for(int i =0; i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                max = Math.max(max, i - stack.peek());
                if(stack.isEmpty()){
                    stack.push(i);
                }
            }

        }
        return  max;
    }

    public static void main(String[] args) {
        String s = "()(())";
        //String s = "()(()";

       int res =  longestValidParenthesis( s);
        System.out.println(res);
    }
}
