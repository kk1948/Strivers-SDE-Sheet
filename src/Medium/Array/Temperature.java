package Medium.Array;

import java.util.Arrays;
import java.util.Stack;

public class Temperature {

    public static int[] dailyTemperatures(int[] temperatures) {

//        int[]  res = new int[temperatures.length];
//       // res[res.length-1] = 0;
//        int i = 0, j = i+1;
//        int wait = 0;
//        while(j< temperatures.length ){
//            if(temperatures[j]> temperatures[i]){
//                wait = j -i;
//                res[i] = wait;
//                i++;
//                j= i+1;
//            }else {
//                j++;
//            }
//        }
//
//        return res;

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;



    }

    public static int[] dailyTemperaturesOptimized(int[] temperatures) {

        Stack<Integer>  stack = new Stack<>();

        int[] res = new int[temperatures.length];

        for(int i = 0; i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int previosuindex = stack.pop();
                res[previosuindex] = i - previosuindex;
            }
            stack.push(i);
        }

        return res;

    }

    public static void main(String[] args) {
        int[] arr = { 73,74,75,71,69,72,76,73};
       // int[] result = dailyTemperatures(arr);
        int[] result = dailyTemperaturesOptimized(arr);
        System.out.println(Arrays.toString(result));

    }
}
