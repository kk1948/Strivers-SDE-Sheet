package BinarySearch;

public class SmallestDivisor {

    ///Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
    ///divide all the array by it, and sum the division's result. Find the smallest divisor such that the
    ///result mentioned above is less than or equal to threshold.
    /// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).


    public static int smallestDivisorBinarySearch(int[] nums, int threshold){
        int start = 1;
        int end = Integer.MIN_VALUE;

        //Find the maximum possible of divisor
        for(int i=0; i<nums.length; i++){
            if(nums[i]> end){
                end = nums[i];

            }
        }
        int res = -1;

        while (start<= end){
            int mid = start + (end - start) / 2;
            if(isDivisionPossible(nums, mid, threshold)){
                res = mid;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return  res;
    }

       static boolean  isDivisionPossible(int[] nums, int divisor, int threshold){
        int sumOfDivision = 0;

        for(int i =0; i< nums.length;i++){
            sumOfDivision += nums[i] / divisor;
            if(nums[i]% divisor != 0){
                sumOfDivision++;
            }
            if(sumOfDivision > threshold){
                return false;
            }
        }
        return true;
     }

    public static void main(String[] args) {

    }

}
