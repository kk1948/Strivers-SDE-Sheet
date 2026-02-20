package Easy.String;

public class MaxNestingDepth {

    private static int  maxnestingdepth(String s) {
        int current_depth = 0, max_depth = 0;

        for(char c: s.toCharArray()){
            if(c == '('){
                current_depth++;
                max_depth = Math.max(current_depth, max_depth);
            }

            if(c == ')'){
                current_depth--;
                max_depth= Math.max(current_depth, max_depth);
            }

        }
        return max_depth;
    }

    public static void main(String[] args) {
       // String s = "(1+(2*3)+((8)/4))+1";
        String s = "()()()()";
        int result = maxnestingdepth(s);
        System.out.println(result);
    }


}
