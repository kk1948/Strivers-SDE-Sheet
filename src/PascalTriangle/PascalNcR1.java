package PascalTriangle;

import static PascalTriangle.PascalNcR.funNcR;

public class PascalNcR1 {

    //Q - Given R(row) & C(column) find the element at that place N-> Row , R -> column


    public static void main(String[] args) {

        long N = 5; long R = 4;
        long result = funNcR(N-1, R-1);
        for( R =1; R<= N; R++ ){
            System.out.println(result);
        }

    }
}
