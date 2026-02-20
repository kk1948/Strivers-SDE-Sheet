package Easy.String;

public class Palindrome {

   public static boolean palindromeOptimized(String s ){
       //removing non alphabet character
       s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
       int left = 0;
       int right = s.length() - 1;
       while(left < right){
         if(s.charAt(left) != s.charAt(right)){
             return false;
         }
         left++;
         right--;
       }
       return true;


   }

    public static boolean palindromeOptimizedII(String s ){
        //removing non alphabet character

        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            if(right > left && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if(Character.isLetterOrDigit(s.charAt(left))!= Character.isLetterOrDigit(s.charAt(right))) return false;
        }
        return true;


    }






    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = palindromeOptimized(s);
        System.out.println(result);
    }
}
