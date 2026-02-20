package Medium.Array;

public class maxSubarraySum {

    static int maxsubarrayusingkadanealgo(int [] nums){
         int current_sum = nums[0], max = nums[0];

        for(int num : nums){
            current_sum+= num;

            if(current_sum > max){
                max = current_sum;
            }

            if(current_sum< 0){
                current_sum = 0;
            }
        }


        return max;
    }

    static int maxsubarrayprintsubarray(int [] nums){
        int current_sum = nums[0];
        int max_sum = nums[0];

        int start = 0, end = 0, tempStart = 0;

        for(int i = 1; i < nums.length; i++){

            // Decide whether to start new subarray or continue
            if (nums[i] > current_sum + nums[i]) {
                current_sum = nums[i];
                tempStart = i;
            } else {
                current_sum = current_sum + nums[i];
            }

            // Update max sum and subarray indices
            if (current_sum > max_sum) {
                max_sum = current_sum;
                start = tempStart;
                end = i;
            }
        }

        // Print subarray
        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return max_sum;
    }






    public static void main(String[] args) {
       int[] arr = { -2,1,-3,4,-1,2,1,-5,4 };
    }
}
