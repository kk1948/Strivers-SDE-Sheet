package Medium.Array;

import java.util.*;

public class ThreeSum {

    /// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    ///
    /// Notice that the solution set must not contain duplicate triplets

    public static List<List<Integer>> threeSumBruteForce(int[] nums){
        Set<List<Integer>> setResult = new HashSet<>(); // no duplicates

        for(int i = 0; i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1; k<nums.length;k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        setResult.add(triplet);

                    }
                }
            }
        }
        return new ArrayList<>(setResult);
    }

    public static List<List<Integer>> threeSumOptimized(int[] nums){
        if(nums.length< 3 && nums == null) return new ArrayList<>();

        // Sort the Array
        Arrays.sort(nums);
        Set<List<Integer>> tripletSet = new HashSet<>();
        //Now fix the first element, and finds other two element
        for(int i = 0; i<nums.length - 2;i++){
            int left = i+1;
            int right = nums.length -1;
            while (left < right){
                int sum = nums[i] + nums[left]+ nums[right];

                if(sum == 0){

                    //Add to the Set , and mve to find other triplets
                    tripletSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if(sum < 0){
                    left ++;
                }else{
                    right--;
                }
            }
        }

        return new ArrayList<>(tripletSet);
    }
//
//    Arrays.sort(nums);
//    List<List<Integer>> result = new ArrayList<>();
//
//for (int i = 0; i < nums.length - 2; i++) {
//
//        // Skip duplicate fixed element
//        if (i > 0 && nums[i] == nums[i - 1]) continue;
//
//        int left = i + 1;
//        int right = nums.length - 1;
//
//        while (left < right) {
//
//            int sum = nums[i] + nums[left] + nums[right];
//
//            if (sum == 0) {
//                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                left++;
//                right--;
//
//                // Skip duplicates
//                while (left < right && nums[left] == nums[left - 1])
//                    left++;
//
//                while (left < right && nums[right] == nums[right + 1])
//                    right--;
//
//            } else if (sum < 0) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//    }
//
//return result;




    public static void main(String[] args) {

        int[] nums = { -1,0,1,2,-1,-4};
       // List<List<Integer>> result = threeSumBruteForce(nums);
        List<List<Integer>> result = threeSumOptimized(nums);
        System.out.println(result);


    }
}
