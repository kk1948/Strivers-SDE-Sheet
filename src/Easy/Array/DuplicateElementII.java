package Easy.Array;

public class DuplicateElementII {

    /// Given an integer array nums and an integer k,
    /// return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

    public boolean duplicateElementIIBruteForce(int[] nums, int k){
        for(int i =0; i<nums.length; i++){
            for(int j =i+1; j<nums.length; j++){
                //if(i == j) continue;
                if(nums[i]== nums[j] && Math.abs(i-j)<= k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateElementII duplicateElementII = new DuplicateElementII();
        int[] nums = {1,2,3,1,2,3};
        System.out.println(duplicateElementII.duplicateElementIIBruteForce(nums, 2));
    }
}
