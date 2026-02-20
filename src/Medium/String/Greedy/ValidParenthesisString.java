package Medium.String.Greedy;

public class ValidParenthesisString {

    public static  boolean checkValidString(String s) {
        int openbrack = 0, closebrack = 0, asterik = 0;

        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '(') {
                openbrack++;
            }
            if (s.charAt(i) == ')') {
                closebrack++;
            }
            if (s.charAt(i) == '*') {
                asterik++;
            }
        }

        if (openbrack + asterik == closebrack) {
            return true;
        }
     return false;
    }

    public static  boolean checkValidStringII(String s) {
        int minopen = 0;
        int maxopen = 0;

        for(char ch : s.toCharArray()){
            if( ch  == '('){
                minopen++;
                maxopen++;
            }
            else if( ch == ')'){
                minopen--;
                maxopen--;
            }
            else{
                minopen--;
                maxopen++;
            }
            if(minopen <0) minopen = 0;

            if(maxopen <0 ) return false;
        }

        return minopen == 0;
    }




        public static void main(String[] args) {

        String s = "(*)";
        boolean res = checkValidStringII(s);
//        boolean res = checkValidString(s);
            System.out.println(res
            );
    }
}
