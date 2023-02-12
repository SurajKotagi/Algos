import java.io.*;
import java.util.*;

public class nknightcombination {

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        // -8-1-
        // 7---2
        // --x--
        // 6---3
        // -5-4-
        // checking 1 place
        if (i - 2 >= 0 && j + 1 < chess.length) {
            if (chess[i - 2][j + 1]) {
                return false;
            }
        }

        // checking 8 place
        if (i - 2 >= 0 && j - 1 >= 0) {
            if (chess[i - 2][j - 1]) {
                return false;
            }
        }

        // checking 5 place
        if (i + 2 < chess.length && j - 1 >= 0) {
            if (chess[i + 2][j - 1]) {
                return false;
            }
        }

        // checking 7 place
        if (i - 1 >= 0 && j - 2 >= 0) {
            if (chess[i - 1][j - 2]) {
                return false;
            }
        }

        // checking 2 place
        if (i - 1 >= 0 && j + 2 < chess.length) {
            if (chess[i - 1][j + 2]) {
                return false;
            }
        }

        // checking 3 place
        if (i + 1 < chess.length && j + 2 < chess.length) {
            if (chess[i + 1][j + 2]) {
                return false;
            }
        }

        // checking 4 place
        if (i + 2 < chess.length && j + 1 < chess.length) {
            if (chess[i + 2][j + 1]) {
                return false;
            }
        }

        // checking 6 place
        if (i + 1 < chess.length && j - 2 >= 0) {
            if (chess[i + 1][j - 2]) {
                return false;
            }
        }

        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}