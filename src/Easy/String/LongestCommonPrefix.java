package Easy.String;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] words = { "clove", "clover", "clority"};
        System.out.println(longestCommonPrefix(words));

    }

    static String longestCommonPrefix(String[] str){

        StringBuilder builder  = new StringBuilder();
        Arrays.sort(str);
        char[] fisrt = str[0].toCharArray();
        char[] last = str[str.length - 1].toCharArray();

        for(int i = 0; i<fisrt.length;i++){
            if(fisrt[i] != last[i]){
                break;
            }
            builder.append(fisrt[i]);
        }

        return builder.toString();
    }
}
