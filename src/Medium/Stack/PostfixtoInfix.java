package Medium.Stack;

import java.util.Stack;

public class PostfixtoInfix {

    static String postfixtoinfix(String str){
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If operand → push
            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            }
            // If operator → pop two, combine, push back
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();

                String newExp = "(" + op1 + ch + op2 + ")";
                stack.push(newExp);
            }
        }

        // Final expression
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String str = "ab*c+";
        String result = postfixtoinfix(str);
        System.out.println(result);
    }
}
