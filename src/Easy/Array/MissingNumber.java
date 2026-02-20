package Easy.Array;

public class MissingNumber {


    public static  int missingNo(int[] arr){
     int xorall = 0;
     //xor with all the given number in range
        for(int i =0; i<= arr.length;i++){
            //xorall ^= i;
            xorall = xorall ^ i;

        }

        //xor all numbers given in array
        for(int num : arr){
            xorall = xorall ^ num;
        }
        return xorall;

    }



    public static void main(String[] args) {
             int[] arr = {4,2,3,5,7,0,1};
             int res = missingNo(arr);
        System.out.println(res);
    }
}
