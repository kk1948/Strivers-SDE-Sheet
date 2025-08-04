package PascalTriangle;

public class PascalNcR {

    //Q - Given R(row) & C(column) find the element at that place N-> Row , R -> column
    public static long funNcR(long N, long R){
        long res = 1;
        for(int i = 0; i<R; i++){
            res = res*(N - i);
            res = res / (i+ 1);
        }
        return res;
    }

    public static void main(String[] args) {

        long N = 5; long R = 4;
        long result = funNcR(N-1, R-1);
        System.out.println(result);
    }
}
