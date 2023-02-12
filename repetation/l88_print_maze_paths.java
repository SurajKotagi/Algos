import java.util.*;
import java.io.*;

public class l88_print_maze_paths {
    public static void printMP(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        } else if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        printMP(sr, sc + 1, dr, dc, psf + "h");
        printMP(sr + 1, sc, dr, dc, psf + "v");

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        printMP(0, 0, r - 1, c - 1, "");
    }
}