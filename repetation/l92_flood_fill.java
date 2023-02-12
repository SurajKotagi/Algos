import java.util.*;
import java.io.*;

public class l92_flood_fill {
    public static void rec(int sr, int sc, int dr, int dc, String psf, int[][] maze, boolean[][] visited) {
        if (sr < 0 || sc < 0 || sr > dr || sc > dc || maze[sr][sc] == 1 || visited[sr][sc] == true) {
            return;
        } else if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        // there are four options from a point
        visited[sr][sc] = true;
        rec(sr - 1, sc, dr, dc, psf + "t", maze, visited);
        rec(sr, sc - 1, dr, dc, psf + "l", maze, visited);
        rec(sr + 1, sc, dr, dc, psf + "d", maze, visited);
        rec(sr, sc + 1, dr, dc, psf + "r", maze, visited);
        visited[sr][sc] = false;
    }

    // method 2

    public static ArrayList<String> rec2(int sr, int sc, int[][] maze, boolean[][] visited) {
        if (sr < 0 || sc < 0 || sr >= maze.length || sc >= maze[0].length || maze[sr][sc] == 1
                || visited[sr][sc] == true) {
            ArrayList<String> bArrL = new ArrayList<>();
            return bArrL;
        } else if (sr == maze.length - 1 && sc == maze[0].length - 1) {
            ArrayList<String> bArrL = new ArrayList<>();
            bArrL.add("");
            return bArrL;
        }

        ArrayList<String> myArrL = new ArrayList<>();
        visited[sr][sc] = true;
        ArrayList<String> fromt = rec2(sr - 1, sc, maze, visited);
        for (String slices : fromt) {
            myArrL.add("t" + slices);
        }
        ArrayList<String> froml = rec2(sr, sc - 1, maze, visited);
        for (String slices : froml) {
            myArrL.add("l" + slices);
        }
        ArrayList<String> fromd = rec2(sr + 1, sc, maze, visited);
        for (String slices : fromd) {
            myArrL.add("d" + slices);
        }
        ArrayList<String> fromr = rec2(sr, sc + 1, maze, visited);
        for (String slices : fromr) {
            myArrL.add("r" + slices);
        }
        visited[sr][sc] = false;

        return myArrL;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        int[][] maze = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                maze[i][j] = scn.nextInt();
            }
        }
        // mehtod 1

        boolean[][] visited = new boolean[r][c];
        // rec(0, 0, r - 1, c - 1, "", maze, visited);

        // method 2
        ArrayList<String> res = rec2(0, 0, maze, visited);
        for (String slices : res) {
            System.out.println(slices);
        }
    }
}