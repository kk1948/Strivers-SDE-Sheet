package Easy.Array;

public class SecondLargest {
    public static void main(String[] args) {
        int[ ] arr = { 12, 35, 1, 10, 34, 1};
        int result = secondlargest(arr);
        System.out.println(result);
    }

    static  int secondlargest(int[] arr){
        int first_largest = 0;
        int second_largest = Integer.MIN_VALUE;
        for(int i = 1; i< arr.length;i++){
            if(arr[i]> first_largest ){
                second_largest = first_largest;
                first_largest = arr[i];
            } else if (arr[i]<first_largest && arr[i]>second_largest) {
                second_largest = arr[i];
            }
        }
        return second_largest;
    }

    static  int secondlargest1(int[] arr){
        int first_largest = Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;
        for(int i = 0; i< arr.length;i++){
            if(arr[i]> first_largest ){
                second_largest = first_largest;
                first_largest = arr[i];
            } else if (arr[i]<first_largest && arr[i]>second_largest) {
                second_largest = arr[i];
            }
        }

        // If second largest never updated, return -1
        if (second_largest == Integer.MIN_VALUE) {
            return -1;
        }
            return second_largest;

    }
}
