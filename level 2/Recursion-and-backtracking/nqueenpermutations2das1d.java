import java.io.*;
import java.util.*;

public class nqueenpermutations2das1d {

    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        // checking horizontally
        for (int j = 0, i = row; j < chess.length; j++) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        // checking vertically
        for (int i = 0, j = col; i < chess.length; i++) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        // checking left up diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        // checking left down diagonal
        for (int i = row, j = col; i < chess.length && j >= 0; i++, j--) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        // checking right up diagonal
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        // checking right down diagonal
        for (int i = row, j = col; i < chess.length && j < chess.length; i++, j++) {
            if (chess[i][j] == true) {
                return false;
            }
        }
        return true;
    }

    public static void solution(int qpsf, int tq, String[][] chess, boolean[][] used) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    if (chess[row][col] != null) {
                        System.out.print(chess[row][col] + "\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (used[row][col] == false && IsQueenSafe(used, row, col)) {
                used[row][col] = true;
                chess[row][col] = "q" + (qpsf + 1);
                solution(qpsf + 1, tq, chess, used);
                chess[row][col] = null;
                used[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] used = new boolean[n][n];
        String[][] chess = new String[n][n];
        solution(0, n, chess, used);
    }
}