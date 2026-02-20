package Easy.String;

public class ReverseWords {

    public static  String reverseWords(String s) {
        String[] schar  = s.split(" ");

        StringBuilder result = new StringBuilder();
        for(int i = 0; i<schar.length; i++){
            String words = schar[i];
            StringBuilder rev = new StringBuilder();
            for(int j = words.length() -1; j>= 0; j--){
                rev.append(words.charAt(j));
            }

            result.append(rev);
            if (i != schar.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static  String reverseWordsOptimized(String s) {

        char[] words = s.toCharArray();

        int start = 0;
        for(int end = 0; end<=words.length ;end++){
            if(end == words.length || words[end] == ' ' ){
                reverse(words, start, end -1);
                start = end+1;
            }
        }
        return new String(words);
    }

    public static void reverse(char[] arr, int left, int right){
        while (left<right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        String res = reverseWords(s);
        System.out.println(res);

    }
}
