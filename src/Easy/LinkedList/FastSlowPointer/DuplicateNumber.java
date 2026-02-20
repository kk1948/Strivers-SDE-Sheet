package Easy.LinkedList.FastSlowPointer;

public class DuplicateNumber {


    private static int duplicateNo(int [] arr) {

        int slow = 0 , fast = 0;

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];

            if(slow == fast) break;

        }while (slow != fast);

        int n1= 0;
        int n2 = slow;

        while (n1 != n2){
            n1= arr[n1];
            n2 = arr[n2];
        }
        return n1;
    }

    public static void main(String[] args) {
         int[] arr= {2,3,4,1,1 };

       int res =   duplicateNo(arr);
        System.out.println(res);
    }
}


