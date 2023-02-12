import java.util.*;
import java.io.*;

public class l94_N_queeens {
    public static void rec(int r, boolean[][] chess, String psf) {
        if (r == chess.length) {
            System.out.println(psf + ".");
            return;
        }
        for (int c = 0; c < chess[0].length; c++) {
            if (valid(chess, r, c) == true) {
                chess[r][c] = true;
                rec(r + 1, chess, psf + r + "-" + c + ", ");
                chess[r][c] = false;
            }
        }
    }

    public static boolean valid(boolean[][] chess, int r, int c) {
        for (int i = 0; i <= r; i++) {
            if (chess[i][c] == true) {
                // System.out.println(i + " " + c);
                return false;
            }
        }

        for (int i = 0; i <= c; i++) {
            if (chess[r][i] == true) {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        for (int i = r, j = c; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == true) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        boolean[][] chess = new boolean[n][n];
        rec(0, chess, "");
    }
}