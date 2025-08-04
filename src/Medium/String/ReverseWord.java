package Medium.String;

public class ReverseWord {

    public static void main(String[] args) {
        String s = "  Kishan    is a good    boy  ";
        char[] a = s.trim().replaceAll("\\s+"," ").toCharArray();
        System.out.println(a);

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
