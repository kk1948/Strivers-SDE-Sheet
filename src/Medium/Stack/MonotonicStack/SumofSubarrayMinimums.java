package Medium.Stack.MonotonicStack;

import java.util.Stack;

public class SumofSubarrayMinimums {

    public static int sumofsubarrayminbruteForce(int[] arr){
        int n = arr.length ;
        int mod = (int)  Math.log(1e9 + 7);

        int sum = 0;

        for (int i = 0;i< n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = i; j< n;j++){
                min = Math.min(min, arr[j]);
                sum= (sum + min) % mod;
            }
        }
        return sum;

    }


    public static int sumofsubarrayminOptimized(int[] arr){
        int[] nsei = new int[arr.length];
        int[] psei = new int[arr.length];

        for(int i = 0; i<arr.length;i++){
            nsei[i] = arr.length;
            psei[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<arr.length;i++){
            while (true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }

                int idx = stack.peek();

                if(arr[i] < arr[idx]) {
                    nsei[idx] = i;
                    stack.pop();
                }else {
                    stack.push(i);
                    break;
                }
            }
        }

        stack.clear();

        //previous smaller element index
        for(int i = arr.length -1; i>=0;i--){
            while (true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }

                int idx = stack.peek();

                if(arr[i] < arr[idx]) {
                    psei[idx] = i;
                    stack.pop();
                }else {
                    stack.push(i);
                    break;
                }
            }
        }

        long sum = 0;

        for(int i =0; i< arr.length; i++){
            int leftboundary = i - psei[i];
            int rightboundary = nsei[i] - i;

            long contribution = (leftboundary * rightboundary) % 1000000007;

            contribution = (contribution * arr[i]) % 1000000007;

            sum = (sum + contribution) % 1000000007;
        }
      return (int)sum;

    }


    public static void main(String[] args) {
          int[] arr = {3,1,2,4};
          int result = sumofsubarrayminbruteForce(arr);
          System.out.println(result);

          //TC -> O(n) SC -> O(n)
    }

}
