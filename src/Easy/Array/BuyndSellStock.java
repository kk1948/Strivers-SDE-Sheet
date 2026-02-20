package Easy.Array;

public class BuyndSellStock {


   // First template
    private static int buysellstock(int[] prices){

        int buyPrice = prices[0];
        int profit = 0;

        for(int i = 1; i<prices.length;i++){
            if(prices[i]< buyPrice){
                buyPrice = prices[i];
            }else{
                int Currprofit = prices[i] - buyPrice;
                profit = Math.max(profit, Currprofit);
            }
        }
        return profit;
    }
    private static int buysellstockII(int[] prices){

        int profit = 0;

        for(int i = 1; i<prices.length;i++){
            if(prices[i]> prices[i-1]){
                profit = profit +  prices[i] - prices[i-1];
            }
        }
        return profit;
    }



    public static void main(String[] args) {
         int[] arr = { 7,1,5,3,6,4};
         int result = buysellstock(arr);
        System.out.println(result);
    }
}
