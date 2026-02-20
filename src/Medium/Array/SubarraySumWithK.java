package Medium.Array;

public class SubarraySumWithK {

    static int subarraySumBruteForce(int[]arr, int k){
        int count = 0;

        // i = starting index
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            // j = ending index
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    int len = j - i + 1;
                    if (len > count) count = len;
                }
            }
        }

        return count;
    }



    public static void main(String[] args) {
        String s = "j";
        s.toLowerCase();
           int[] arr = { 10, 5, 2, 7, 1, 9};
           int k = 15;
           int result = subarraySumBruteForce(arr, k);
        System.out.println(result);
    }
}
