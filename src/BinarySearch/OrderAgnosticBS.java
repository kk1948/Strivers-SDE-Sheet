package BinarySearch;

public class OrderAgnosticBS {



    static int orderAgnosticBs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
//        if(arr[start]< arr[end]){
//            isAsc = true;
//        }else{
//            isAsc = false;
//        }

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;

                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    if (target > arr[mid]) {
                        end = mid - 1;

                    } else if (target > arr[mid]) {
                        start = mid + 1;
                    }

                }

            }



        }
        return -1;
    }
    public static void main (String[]args){
                   int[] arr = {120,40,30,20,10}; //arrays sorted in Descending Order
                   int target = 120;
                   int result = orderAgnosticBs(arr, target);
                   System.out.println(result);
               }

    }