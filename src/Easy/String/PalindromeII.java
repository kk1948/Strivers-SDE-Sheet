package Easy.String;

public class PalindromeII {

   public static boolean palindromeIIOptimized(String s ){




       //removing non alphabet character
       s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
       int left = 0;
       int right = s.length() - 1;
       while(left < right){
         if(s.charAt(left) == s.charAt(right)){
             left++;
             right--;
         }else {
             return isPalindrome(s,left +1, right) || isPalindrome(s, left, right -1);
         }

       }
       return true;
   }

    private static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }

        }
        return true;
    }





    public static void main(String[] args) {
        String s = "abca";
        boolean result = palindromeIIOptimized(s);
        System.out.println(result);
    }
}
