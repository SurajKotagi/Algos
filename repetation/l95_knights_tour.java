import java.util.*;
import java.io.*;

public class l95_knights_tour {
    public static void knightsTour(int r, int c, int[][] chess, int count) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] != 0) {
            return;
        } else if (count != chess.length * chess.length) {
            chess[r][c] = count;
        } else {
            chess[r][c] = count;
            for (int i = 0; i < chess.length; i++) {
                for (int j = 0; j < chess.length; j++) {
                    System.out.print(chess[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        knightsTour(r - 2, c + 1, chess, count + 1);
        knightsTour(r - 1, c + 2, chess, count + 1);
        knightsTour(r + 1, c + 2, chess, count + 1);
        knightsTour(r + 2, c + 1, chess, count + 1);
        knightsTour(r + 2, c - 1, chess, count + 1);
        knightsTour(r + 1, c - 2, chess, count + 1);
        knightsTour(r - 1, c - 2, chess, count + 1);
        knightsTour(r - 2, c - 1, chess, count + 1);

        chess[r][c] = 0;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] chess = new int[n][n];
        knightsTour(r, c, chess, 1);
    }
}