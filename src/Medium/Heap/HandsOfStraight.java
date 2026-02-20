package Medium.Heap;

import java.util.TreeMap;

public class HandsOfStraight {

    /// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
    /// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

    /// Example 1:
    ///
    /// Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
    /// Output: true
    /// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
    /// Example 2:
    ///
    /// Input: hand = [1,2,3,4,5], groupSize = 4
    /// Output: false
    /// Explanation: Alice's hand can not be rearranged into groups of 4.



    public static boolean handsofStraight(int[] hands , int groupSize){
        if(hands.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        //build sorted frequncy map
        for(int item : hands){
            map.put(item, map.getOrDefault(item, 0)+ 1);
        }

        //forming gp
        while(!map.isEmpty()){
            int start = map.firstKey();
            for(int i = 0; i< groupSize; i++){
                int curr = start + i;

                if(!map.containsKey(curr)) return  false;

                map.put(curr, map.get(curr) - 1);

                if(map.get(curr) == 0){
                    map.remove(curr);
                }
                //at the end map will be empty this means it forms a pair of given groupsize
            }
        }
        return true;
    }


    public static void main(String[] args) {
       int[] hands = { 1,2,3,6,2,3,4,7,8};  //gp size - 3
       //int[] hands = { 1,2,3,4,5};
       int groupsize = 3;
       boolean result = handsofStraight(hands, groupsize);
        System.out.println(result);
    }
}
