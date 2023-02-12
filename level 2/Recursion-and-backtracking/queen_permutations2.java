import java.io.*;
import java.util.*;

public class queen_permutations2 {
    // ----------------------------------------------------------------
    // Queens Combinations - 2d As 2d - Queen Chooses
    // ----------------------------------------------------------------

    // qpsf - queenns placed so far
    // tq - total number of queens need to be placed
    // chess - n x n boolean array, true indicating queen is placed and false
    // indicating empty spot
    // prow - row of spot where previous queen is placed
    // pcol - column of spot where previous queen is placed

    public static void solution(int qpsf, int tq, boolean[][] chess, int n, int prow, int pcol) {
        // base case
        // whenever you place tq queens ,you can print
        if (qpsf == tq) {
            // int count = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == true) {
                        System.out.print("q\t");
                        // count++;
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // in this approach the queen makes the decision to whether to be placed on spot
        // or not
        // for a queen the places next to the spot and the spot at the time are only
        // available

        // the queen at the moment can be placed on left-out columns of the previous
        // spot or can be placed on other spots next to them

        // calling for left out columns
        for (int col = pcol + 1; col < n; col++) {
            chess[prow][col] = true;
            solution(qpsf + 1, tq, chess, n, prow, col);
            chess[prow][col] = false;
        }

        // calling for next to remaining spots on the board
        for (int row = prow + 1; row < n; row++) {
            // columns start form 0 (IMPORTANT)
            for (int col = 0; col < n; col++) {
                chess[row][col] = true;
                solution(qpsf + 1, tq, chess, n, row, col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        // previous row value is 0 and column valumn value is taken as -1
        solution(0, n, chess, n, 0, -1);
    }
}