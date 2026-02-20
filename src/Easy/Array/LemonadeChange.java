package Easy.Array;

public class LemonadeChange {


    public static boolean lemonadeChange(int[] bills) {
        int tens = 0, fives = 0;

        for(int bill : bills){
            if(bill == 5){
                fives++;
            } else if (bill == 10) {
                if(fives == 0) return false;
                fives--;
                tens++;
            }else {
                // 20
                if(tens>0 && fives >0){
                    tens--;
                    fives--;
                } else if ( fives >= 3) {
                    fives -= 3;
                }else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
       // int[] bills = { 5,5,5,10,20};
        int[] bills = { 5,5,10,10,20};
        boolean res = lemonadeChange(bills);
        System.out.println(res);
    }
}
