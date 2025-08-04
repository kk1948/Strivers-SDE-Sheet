package Easy.String.ConsecutiveCharcterVersion;

public class CharacterHavingLongestCount {

    public  static String characterHavingMaxCount(String s){
        int current_count = 1;
        int max_count = 1;
        char max_char = s.charAt(0);
        for(int i =1; i<s.length();i++){

            /**
             if current character is same as previous character
             **/
            if(s.charAt(i)== s.charAt(i-1)){
                /**
                 increment current_count
                 **/
                current_count++;
            }else {
                //when there is break set current_count = 1
                current_count = 1;
            }
            if(current_count> max_count){
                max_count = Math.max(current_count, max_count);
                max_char = s.charAt(i);
            }

        }
        return max_char + ": " + max_count;
    }

    public static void main(String[] args) {
        String s= "abbcccdeeeeeee";
        String result = characterHavingMaxCount(s);
        System.out.println(result);
    }
}
