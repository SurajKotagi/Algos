import java.io.*;
import java.util.*;

public class queen_permutations3 {
    // qno - Queen number i.e if 4 queens are there then the queens can be given as
    // q1,q2,q3,q4
    // tq - total number of queens need to be palaced
    // chess[][] - 2d array holding queens q1 q2 q3 q4 ...
    // used[][] - 2d boolean board indicating whether spot is occupied or not
    // qpsf - queens placed so far

    public static void solution(int qno, int qpsf, int tq, String[][] chess, boolean[][] used) {
        // base case
        // if all queens are placed then we can print
        if (qpsf == tq) {
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess.length; j++) {
                    if (chess[i][j] == null) {
                        System.out.print("-\t");
                    } else {
                        System.out.print(chess[i][j] + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        // in this approach queen chooses the spot
        // for first queen total n x n spots are available
        // for 2nd queen (n x n) - 1 spots i.e remaining spots are availabel

        for (int row = 0; row < chess.length; row++) {
            for (int col = 0; col < chess.length; col++) {
                if (used[row][col] == false) {
                    used[row][col] = true;
                    chess[row][col] = "q" + qno;
                    solution(qno + 1, qpsf + 1, tq, chess, used);
                    chess[row][col] = null;
                    used[row][col] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] chess = new String[n][n];
        boolean[][] used = new boolean[n][n];

        solution(1, 0, n, chess, used);
    }
}