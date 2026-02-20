package Medium.String;

import java.util.Arrays;

public class ReverseWord {

    public static void main(String[] args) {
        String s = "  Kishan    is a good    boy  ";

        //String result = reverseWordBrute(s);
        String result = reverseWordwithoutInbuilt(s);
        System.out.println(result);
//        char[] a = s.trim().replaceAll("\\s+"," ").toCharArray();
//        System.out.println(a);

//        String result = reverseWord(s);
//        System.out.println(result);

    }

//    static String  reverseWord(String s){
//        String str = s.trim();
//        String[] words = str.split("\\s+"); //split based on two or more white spaces
//        int start = 0;
//        int end = words.length - 1;
//        while(start< end){
//            String temp = words[start];
//            words[start] = words[end];
//            words[end] = temp;
//            start++;
//            end--;
//        }
//        String reversed = String.join(" ", words); // join words into a string
//        return reversed;
//
//    }

    static String reverseWordBrute(String s ){
       s = s.trim().replaceAll("\\s+"," ");
       String[] res = s.split(" ");

       int start = 0;
       int end = res.length - 1;

       while(start< end){
           String temp = res[start];
           res[start] = res[end];
           res[end] = temp;
           start++;
           end--;

       }
        return String.join(" ", res);
        //This joins the array of strings with a space between each word — without brackets or commas.


        //return String.valueOf(Arrays.toString(res)); //Arrays.toString(res) already returns a string, like this:"[world, Java, Hello]"Then you're wrapping it again with String.valueOf(...), which is redundant because Arrays.toString(res) is already a string. So it still returns that debug-style format with square brackets and commas.
        // ;
    }

    //Without using  inbuilt fxn

    static String reverseWordwithoutInbuilt(String s ){
       //cleaning the string
        int l =0, r = s.length()-1;
        while(l<s.length()){
            if(s.charAt(l) == ' ') {
                l= l +1;
            }else {
                break;
            }
        }

        while(r>=0){
            if(s.charAt(r) == ' ') {
                r= r +1;
            }else {
                break;
            }
        }


        //Create a stringbuilder
        StringBuilder sB = new StringBuilder();

        while (l<=r){
            if(s.charAt(l) != ' '){
                sB.append(s.charAt(l));
                l++;
            } else if (s.charAt(l) == ' ') {
                if(sB.charAt(sB.length()-1)!= ' '){
                    sB.append(' ');
                    l = l +1;
                }else {
                    //ignore
                    l = l + 1;
                }
            }
        }

        //sb -> "hello world"
        //reverse
        int i = 0,
                j = sB.length() -1;
        while (i<j){
            char temp = sB.charAt(i);
            sB.setCharAt(i, sB.charAt(j));
            sB.setCharAt(j,temp);

            i = i +1;
            j = j - 1;
        }

        //sB -->  "dlrow olleh"


        //word by word reverse
        int start = 0, end = 0;
        while (start< sB.length()){
            while (end< sB.length() && sB.charAt(end) != ' '){
                end++;
            }

            int p1 = start,
                    p2 = end - 1;
            while (p1< p2){
                char temp = sB.charAt(p1);
                sB.setCharAt(p1, sB.charAt(p2));
                sB.setCharAt(p2,temp);

                p1 = p1 +1;
                p2= p2 - 1;
            }

            start = end+1;
            end = start;
        }

        return sB.toString();

    }




    //Most optimized approach
    static String  reverseWord(String s){
    char[] chars = s.trim().replaceAll("\\s+", " ").toCharArray();

    // Step 1: Reverse the entire char array
    reverse(chars, 0, chars.length - 1);

    // Step 2: Reverse each word
    int start = 0;
        for (int end = 0; end <= chars.length; end++) {
        if (end == chars.length || chars[end] == ' ') {
            reverse(chars, start, end - 1);
            start = end + 1;
        }
    }

        return new String(chars);
}

private static void reverse(char[] arr, int left, int right) {
    while (left < right) {
        char temp = arr[left];
        arr[left++] = arr[right];
        arr[right--] = temp;
    }
}

//time 0( n ) --> Space o(k )



}
