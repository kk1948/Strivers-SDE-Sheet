package Easy.Heap;

public class CheckArrayisMinHeap {

    public static boolean checkMinHeap(int[] arr){
//        boolean isTrue = false;
//        int i = 0;
//        while(i<=(arr.length / 2) - 1){
//            if(arr[i]<= arr[2*i+1] && arr[i]<= arr[2*i+2] ){
//                isTrue = true;
//                i++;  //this stucks in infinite loop because incremental is happening only if condition is true,
//                     //so for false cases, i value never increment and it goes into infinite loop
//            }
//        }
//        return isTrue;

        // 2nd version

        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[i] > arr[left]) {
                return false;
            }

            if (right < n && arr[i] > arr[right]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        //int[] arr = {10, 20, 30, 21, 23};
        int[] arr = {10, 20, 30, 25, 15};

        boolean res  = checkMinHeap(arr);
        System.out.println(res);
    }
}
