import java.util.*;
import java.io.*;

public class l89_print_maze_path_with_jumps {
    public static void printMPWJ(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        } else if (sr == dr && sc == dc) {
            System.out.println(psf);
            return;
        }

        for (int c = sc + 1; c <= dc; c++) {
            printMPWJ(sr, c, dr, dc, psf + "h" + (c - sc));
        }
        for (int r = sr + 1; r <= dr; r++) {
            printMPWJ(r, sc, dr, dc, psf + "v" + (r - sr));
        }
        for (int diar = sr + 1, diac = sc + 1; diar <= dr && diac <= dc; diar++, diac++) {
            printMPWJ(diar, diac, dr, dc, psf + "d" + (diar - sr));
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int r = scn.nextInt();
        int c = scn.nextInt();

        printMPWJ(0, 0, r - 1, c - 1, "");
    }
}