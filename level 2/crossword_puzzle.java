import java.io.*;
import java.util.*;

public class crossword_puzzle {

    public static void solution(char[][] board, String[] words, int vidx) {
        if (vidx == words.length) {
            print(board);
            System.out.println("suraj");
            return;
        }

        String word = words[vidx];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '-' || board[i][j] == word.charAt(0)) {
                    if (hisvalid(board, word, i, j) == true) {
                        boolean[] wp = hfitcomp(board, word, i, j);
                        solution(board, words, vidx + 1);
                        hremcomp(board, wp, i, j);
                    }

                    if (visvalid(board, word, i, j) == true) {
                        boolean[] rp = vfitcomp(board, word, i, j);
                        solution(board, words, vidx + 1);
                        vremcomp(board, rp, i, j);
                    }
                }
            }
        }
    }

    public static boolean hisvalid(char[][] board, String word, int r, int c) {
        if (c >= 1 && board[r][c - 1] != '+') {
            return false;
        } else if (c + word.length() < board[0].length && board[r][c + word.length()] != '+') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            if (c + i >= board[0].length) {
                return false;
            }

            if (board[r][c + i] == '-' || board[r][c + i] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean visvalid(char[][] board, String word, int r, int c) {
        if (r >= 1 && board[r - 1][c] != '+') {
            return false;
        } else if (r + word.length() < board.length && board[r + word.length()][c] != '+') {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (r + i >= board.length) {
                return false;
            }

            if (board[r + i][c] != '-' || board[r + i][c] == word.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean[] hfitcomp(char[][] board, String word, int r, int c) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (board[r][c + i] == '-') {
                board[r][c + i] = word.charAt(i);
                wePlaced[i] = true;
            }
        }
        return wePlaced;
    }

    public static void hremcomp(char[][] board, boolean[] weplaced, int r, int c) {
        for (int j = 0; j < weplaced.length; j++) {
            if (weplaced[j] == true) {
                board[r][c + j] = '-';
            }
        }
    }

    public static boolean[] vfitcomp(char[][] board, String word, int r, int c) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (board[r + i][c] != '-') {
                board[r + i][c] = word.charAt(i);
                wePlaced[i] = true;
            }
        }
        return wePlaced;
    }

    public static void vremcomp(char[][] board, boolean[] weplaced, int r, int c) {
        for (int i = 0; i < weplaced.length; i++) {
            if (weplaced[i] == true) {
                board[r + i][c] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}