package Medium.Array;

public class MaximumproductSubarray {

    static int maxProductOptimized(int[] nums){
        int left_Product= 1;
        int right_Product =1 ;
        int ans = nums[0];

        for(int i =0; i<nums.length;i++){
            left_Product = left_Product == 0 ? 1: left_Product;
            right_Product = right_Product ==0 ? 1: right_Product;

            left_Product = left_Product * nums[i];
            right_Product = right_Product * nums[nums.length -1 -i];

            ans = Math.max(ans, Math.max(left_Product, right_Product));

        }
     return ans;
    }

    public static void main(String[] args) {
      int[] nums = { 2,3,-2,5,6,-1,4};
      int result = maxProductOptimized(nums);
        System.out.println(result);
    }
}
