package Medium.String;

public class mincharsToAppend {

    public static int minCharsToAppend(String s, String t) {
        int tIndex = 0;
        int sLength = s.length();
        int tLength = t.length();

        for (int i = 0; i < sLength && tIndex < tLength; i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {
                tIndex++; // Move to the next character in t
            }
        }

        // The number of characters left in t that we didn't match is how many we need to append
        return tLength - tIndex;
    }

    public static int minCharsToAppendOptimized(String s, String t) {
        int i =0, j = 0;
        while(i< s.length() && j<t.length()){
            if(s.charAt(i)== t.charAt(j)){
                j = j + 1;
                i = i +1;
            }else{
                i = i + 1;
            }

        }

        return t.length() - j;
    }

    public static void main(String[] args) {
         String s = "coaching" , t = "coding";
         int result = minCharsToAppendOptimized(s, t);
        System.out.println(result);
    }
}
