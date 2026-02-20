package Easy.Array;

public class MaximumSumsubArray {

    /// subarray containing max sum of size k

    public static int maxsum(int[] arr, int k){
//        int sum =0 , max = 0;
//        int i =0;
//        for(int j = 0; j<k;j++) {
//            sum = sum + arr[j];
//            max = Math.max(max, sum);
//        }
//            //sliding windows
//        int  j = k;
//            while(j<arr.length){
//              sum = sum + arr[j];
//              sum = sum - arr[i];
//              i++;
//              j++;
//              max = Math.max(max, sum);
//            }
//
//
//       return max;

        int sum =0;

        //first window
        for(int i = 0; i<k; i++){
            sum+= arr[i];
        }
        int max = sum;

        //sliding window
        int i = 0;
        for(int j = k; j<arr.length;j++ ){
            sum = sum + arr[j] - arr[i];
            i++;
            max = Math.max(max, sum);

        }
        return max;
    }


    public static void main(String[] args) {
       int[] arr= { 1,2,3,4,5};
       int k = 3;
       int res = maxsum(arr, k);
        System.out.println(res);
    }
}
