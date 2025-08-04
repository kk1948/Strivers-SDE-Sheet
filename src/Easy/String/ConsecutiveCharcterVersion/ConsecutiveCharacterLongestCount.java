package Easy.String.ConsecutiveCharcterVersion;

public class ConsecutiveCharacterLongestCount {

    public  static  int consecutiveCharcter(String s){

        int count = 1;
        int max_count = 1;
        for(int i =1; i<s.length();i++){

            /**
             if current character is same as previous character
             **/
            if(s.charAt(i)== s.charAt(i-1)){
                /**
                 increment count
                 **/
                count++;
            }else {
                //when there is break set count = 1
                count = 1;
            }
            //endregion

            max_count = Math.max(count, max_count);
        }
        return max_count;
    }


    public static void main(String[] args) {
        String s= "abbcccdeeeeeee";
        int result = consecutiveCharcter(s);
        System.out.println(result);

    }
}
