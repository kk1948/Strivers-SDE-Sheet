package Medium.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestElement {


    public static int kthsmallest( int[] nums, int k ){

        // min heap of size k
        //min heap will store the k largest integer at any time

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            if(heap.size() < k){
                heap.add(num);
            }else{
                if(num < heap.peek()){
                    //remove  the current peek
                    //add the current number into heap
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        return heap.peek();  //return the kth largest(because first element in heap will be k th largest)


    }


    public static void main(String[] args) {
        int[] nums = { 3,2,1,4,5,5,6};
        int k = 4;
        int result = kthsmallest(nums, k);
        System.out.println(result);
    }
}
