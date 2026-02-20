package BinarySearch;

public class BS {


    static int binarySearch( int[] arr, int target){
        int start = 0;
        int end = arr.length -1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                end = mid -1;

            } else if (target > arr[mid]) {
                start = mid + 1;
            } else{
                return mid;
            }
        }
        return  -1;
    }

    static int binarySearchDescendingOrder( int[] arr, int target){
        int start = 0;
        int end = arr.length -1;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(target < arr[mid]){
                start = mid + 1;

            } else if (target > arr[mid]) {

                end = mid -1;
            } else{
                return mid;
            }
        }
        return  -1;
    }


    public static void main(String[] args) {

       // int[] arr = {10,20,35,40,120}; //arrays sorted in Ascending Order
        int[] arr = {120,40,30,20,10}; //arrays sorted in Descending Order
        int target = 120;
        int result = binarySearch(arr, target);
        int result1 = binarySearchDescendingOrder(arr, target);

        System.out.println(
                result1
        );
    }
}
