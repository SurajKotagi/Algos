import java.io.*;
import java.util.*;

public class knightstour {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] chess = new int[n][n];
        solution(chess, r, c, 1);
    }

    public static void solution(int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] != 0) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = move;
        solution(chess, r - 2, c + 1, move + 1);
        solution(chess, r - 1, c + 2, move + 1);
        solution(chess, r + 1, c + 2, move + 1);
        solution(chess, r + 2, c + 1, move + 1);
        solution(chess, r + 2, c - 1, move + 1);
        solution(chess, r + 1, c - 2, move + 1);
        solution(chess, r - 1, c - 2, move + 1);
        solution(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}