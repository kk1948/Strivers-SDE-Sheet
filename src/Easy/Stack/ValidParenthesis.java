package Easy.Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    /// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    ///
    /// An input string is valid if:
    ///
    /// Open brackets must be closed by the same type of brackets.
    /// Open brackets must be closed in the correct order.
    /// Every close bracket has a corresponding open bracket of the same type



    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                characters.push(c);
            } else {
                // closing bracket
                if (characters.isEmpty()) {
                    return false; // no matching opening
                }

                char top = characters.peek();

                if ((c == ')' && top == '(') ||
                        (c == '}' && top == '{') ||
                        (c == ']' && top == '[')) {
                    characters.pop(); // matched
                } else {
                    return false; // mismatch
                }
            }
        }

        return characters.isEmpty();
    }




    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isValid(s)); // true
    }
}
