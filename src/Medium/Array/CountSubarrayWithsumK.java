package Medium.Array;

public class CountSubarrayWithsumK {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};
       int result  =  countSubarraysumKBruteforce(arr, 3);
        System.out.println(result);
    }

    //count subarray with sum = j;
    public static int countSubarraysumKBruteforce(int[] nums, int num){

        int count = 0;
        for(int i = 0; i<nums.length; i++){
            for(int j = 1; j<=nums.length;j++){
                int sum = 0;
                int k;
                for( k = i; k< j ;k++){
                    sum += nums[k];

                }
                if(sum == num){
                    count++;
                }

            }
        }


        return count;
    }
}
