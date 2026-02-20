package BinarySearch;

public class CapacityToShipinDdays {

    /// A conveyor belt has packages that must be shipped from one port to another within days days.
    /// The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages
    ///on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight
    /// capacity of the ship.
    /// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being
    ///  shipped within days days.
    public static int capacityToShipBruteForce(int[] weights, int D){
        int maxweight = 0;
        for(int wieght : weights){
            maxweight = Math.max(wieght, maxweight);
        }
        int capacity = maxweight;
        while (true){
            int days= calculateDays(weights,capacity);
            if(days<=D){
                return capacity;
            }
            capacity++;
        }
    }


    static int calculateDays(int[] weights, int capacity){
        int days = 1;
        int currentload = 0;
        for(int wieght : weights){
            if(currentload + wieght > capacity){
                days++;
                currentload = 0;
            }
            currentload+= wieght; 
        }
         return days;
    }



    public static void main(String[] args) {

        int[] weights = { 1,2,3,1,1};
        int result = capacityToShipBruteForce(weights, 4);
        System.out.println(result);
    }
}