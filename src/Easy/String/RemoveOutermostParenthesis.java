package Easy.String;

public class RemoveOutermostParenthesis {
    public static void main(String[] args) {

        String s = "(()())((())";
        String remooved = removeOutermostParenthesis(s);
        System.out.printf(remooved);
    }

    static String removeOutermostParenthesis(String  s){
        StringBuilder result  = new StringBuilder();
         int counter = 0;
        int n = s.length();
        for(int i =0; i< n; i++){
            if(s.charAt(i) == ')'){
                counter--;

            }
            if (counter!=0) {  //when counter = 1; it will start adding
                result.append(s.charAt(i));
            }
            if(s.charAt(i) == '('){ // this will take  care that first character will not be added
                counter++;
            }

        }


        //return String.valueOf(result);
        return result.toString();
    }




}
