package Medium.String;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {

        String s= "babad";
        longestPalindromicSubstring(s);
    }

    //Optimized
    public  static String longestPalindromicSubstring(String s){
        if(s == null && s.length() < 1) return "";

        int start = 0;
        int maxlen = 1;
        for(int i = 1; i<s.length();i++){
            //even lenght
            int l = i -1;
            int r = i;
            while(l>= 0 && r<s.length() && s.charAt(l) == s.charAt(r) ){
                if(r-l+1> maxlen){
                    maxlen = r-l+1;
                    start = l;
                }
                l--;
                r++;
            }

            //odd length
            l = i-1;
            r = i+1;
            while(l>= 0 && r<s.length() && s.charAt(l) == s.charAt(r) ){
                if(r-l+1> maxlen){
                    maxlen = r-l+1;
                    start = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start+ maxlen);
    }
}
