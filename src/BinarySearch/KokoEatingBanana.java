package BinarySearch;

public class KokoEatingBanana {


    static int kokoBinarySearch(int[] piles, int h){
        int minspeed = 1;
        int maxspeed = 0;
        for(int pile: piles){
            maxspeed = Math.max(maxspeed, pile);
        }
        //Binary Search
        while (minspeed < maxspeed){
            int mid = minspeed + (maxspeed - minspeed) / 2;
            if(canEatInTime(piles, h, mid)){
                maxspeed = mid;
            }else {
                minspeed = mid + 1;
            }

        }

        return  minspeed;
    }

    private static boolean canEatInTime(int[] piles, int h, int speed) {
        int hours = 0;
        for(int pile: piles){
            hours += (int)Math.ceil( (double)pile / speed );
        }

        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = { 3,6,7,11};
        int h = 8;
        int result = kokoBinarySearch(piles, h);
        System.out.println(result);
    }

}
