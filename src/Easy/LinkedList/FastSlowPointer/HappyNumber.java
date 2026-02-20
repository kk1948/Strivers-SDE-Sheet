package Easy.LinkedList.FastSlowPointer;

public class HappyNumber {

    /// Write an algorithm to determine if a number n is happy.
    ///
    /// A happy number is a number defined by the following process:
    ///
    /// Starting with any positive integer, replace the number by the sum of the squares of its digits.
    /// Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    /// Those numbers for which this process ends in 1 are happy.
    /// Return true if n is a happy number, and false if not.


   static int sumofsquaresofdigits(int n){
        int sum =0;
         while(n>0){
              int dig = n % 10;
              sum = sum + (dig * dig);
              n = n/10;

         }
         return sum;
    }
    public static boolean isHappy(int n) {
       int fast = n;
       int slow = n;

       while (fast != 1){
           slow = sumofsquaresofdigits(slow);
           fast = sumofsquaresofdigits(sumofsquaresofdigits(fast));

           if(fast == 1) return true;
           if(slow == fast) return  false;

       }
       return true;
    }


    public static void main(String[] args) {

      //int n = 2;
      int n = 19;
      boolean res = isHappy(n);
        System.out.println(res);

    }
}
