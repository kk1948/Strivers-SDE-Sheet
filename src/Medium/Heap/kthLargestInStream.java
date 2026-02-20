package Medium.Heap;

import java.util.PriorityQueue;

public class kthLargestInStream {
    ///


    private PriorityQueue<Integer> minheap;
    int k ;
    public kthLargestInStream(int k, int[] nums) {
        this.k = k;
        this.minheap = new PriorityQueue();

        for(int num : nums){
            minheap.offer(num);

            if(minheap.size()> k){
                minheap.poll();
            }
        }
    }


    public int add(int val){
        if(minheap.size()< k){
            minheap.add(val);
            return  minheap.peek();
        }

        minheap.add(val);
        minheap.poll();
        return minheap.peek();
    }
}
