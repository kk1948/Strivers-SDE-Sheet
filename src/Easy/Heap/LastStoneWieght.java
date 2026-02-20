package Easy.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWieght {


    public static int lastStoneWeight(int[] stones){

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());

        //max heap
        for(int stone : stones){
            maxheap.add(stone);
        }


        while(maxheap.size()>1){
            int x = maxheap.poll();
            int y = maxheap.poll();

            if(x!=y){
                maxheap.add(x - y);
            }
        }

        return maxheap.isEmpty() ? 0 : maxheap.peek();
    }


    public static void main(String[] args) {
         int[] stone = {2,7,4,1,8,1};
         int result = lastStoneWeight(stone);
        System.out.println(result);
    }
}
