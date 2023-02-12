import java.io.*;
import java.util.*;

public class nqueen {

    public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
        if (row == board.length) {
            System.out.println(asf + ".");
            return;
        }

        for (int j = 0; j < board[0].length; j++) {
            if ((cols & (1 << j)) == 0 &&
                    (ndiag & (1 << (row + j))) == 0 &&
                    (rdiag & (1 << (row - j + board.length - 1))) == 0) {
                // board[row][j] = true;
                cols ^= (1 << j);
                ndiag ^= (1 << (row + j));
                rdiag ^= (1 << (row - j + board.length - 1));

                solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + j + ", ");

                cols ^= (1 << j);
                ndiag ^= (1 << (row + j));
                rdiag ^= (1 << (row - j + board.length - 1));
                // board[row][j] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        int cols = 0;
        int ndiag = 0;
        int rdiag = 0;
        solution(board, 0, cols, ndiag, rdiag, "");
    }

}