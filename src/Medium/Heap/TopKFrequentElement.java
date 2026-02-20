package Medium.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {

    public static int[] topKFrequent(int[] nums, int k) {



        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            // T ; O(n) , S: O(n)
            map.put(num, map.getOrDefault(num ,0) + 1);
        }
        // map -> { 1:3 , 2:2 , 3:1 }

        PriorityQueue<Integer> heap = new PriorityQueue<>((e1, e2) -> map.get(e1) - map.get(e2));

        for(int ele: map.keySet()){
            // T: O(n.logk) , S:O(k)
            heap.add(ele);

             if(heap.size() > k){
                 heap.poll();
             }

        }

        //k -sized heap ---- K most frequent element
        int[] res =  new int[k];
        int i =0;
        // Total time complexity -> O(n.logk)
        while(!heap.isEmpty()){
            // T: O(k.logk) , S: O(1)
            res[i] = heap.poll();
            i++;
        }


        return res;
    }


    public static void main(String[] args) {
          int[]  nums = {1,1,1,2,2,3};
          int k = 2;
           int[] result =  topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
