
import java.io.*;
import java.util.*;

public class solve_sudoko {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        if (i == board.length) {
            display(board);
            return;
        }

        int ni = 0;
        int nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, ni, nj);
        } else {
            for (int x = 1; x <= 9; x++) {
                if (isValid(board, i, j, x)) {
                    board[i][j] = x;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;

                }
            }
        }

    }

    public static boolean isValid(int[][] board, int r, int c, int x) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[r][j] == x) {
                return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == x) {
                return false;
            }
        }
        for (int di = r / 3 * 3; di < r / 3 * 3 + 3; di++) {
            for (int dj = c / 3 * 3; dj < c / 3 * 3 + 3; dj++) {
                if (board[di][dj] == x) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}
