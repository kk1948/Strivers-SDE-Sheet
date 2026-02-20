package Medium.Stack;

import java.util.Stack;

public class InfixtoPostfix {


    private static int precedence(char ch){
//        switch (ch){          legacy style (older version)
//            case '^' : return 1;
//            case '/', '*': return  2;
//            case '-', '+' : return 3;
//            default: return -1;
//        }

        // newer version
//        return switch (ch) {
//            case '+', '-' -> 1;
//            case '*', '/' -> 2;
//            case '^' -> 3;
//            default -> -1;
//        };

        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1;
        }
    }


    public static String infixtopostfix(String exp){

        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {

            // 1. Operand → add to result
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }

            // 2. '(' → push
            else if (c == '(') {
                stack.push(c);
            }

            // 3. ')' → pop until '('
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // 4. Operator
            else {
                while (!stack.isEmpty() &&
                        precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);  // important
            }
        }

        // 5. Pop remaining operators (AFTER loop)
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();

    }

    public static void main(String[] args) {
         String s = "(a+b)*c";
         String res = infixtopostfix(s);
        System.out.println(res);
    }
}
