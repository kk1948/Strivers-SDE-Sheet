package Easy.Array;

public class LargestElement {
    public static void main(String[] args) {

    }
    private static int  findlargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length ;i++){
            if(arr[i]> largest){
                largest = Math.max(arr[i], largest);

            }
        }
        return largest;
    }
}
