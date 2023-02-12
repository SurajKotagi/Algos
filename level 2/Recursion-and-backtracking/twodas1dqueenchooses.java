import java.io.*;
import java.util.*;

public class twodas1dqueenchooses {
    // qpsf - queens placed so far
    // tq - total number of queens need to be placed
    // chess[][] - true indicating already queen is placed, false indicating empty
    // lcno - last focused cell number

    public static void solution(int qpsf, int n, int tq, boolean[][] chess, int lcno) {
        // in this combination approach for the first queen all n x n cells are valid
        // is 1st queen is placed then for the 2nd queen only remaining (n x n) - 1
        // cells are valid
        // This question is already solved , here we are converting 2d to 1d with simple
        // equations

        // base case
        // if tq queens are placed then we can print
        if (qpsf == tq) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chess[i][j] == true) {
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // for a particular cel

        // its row number = cell number / n
        // its column number = cell number % n

        // cell number = (row number x n) + column number

        // for 1st queen all n x n are valid
        // looping from previous + 1 to (n x n) - 1

        for (int cell = lcno + 1; cell < n * n; cell++) {
            int row = cell / n;
            int col = cell % n;

            chess[row][col] = true;
            solution(qpsf + 1, n, tq, chess, cell);
            chess[row][col] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        solution(0, n, n, chess, -1);
    }
}