import java.util.*;
import java.io.*;

public class l84_get_maze_path_with_jumpps {
    static ArrayList<String> res = new ArrayList<>();

    public static void getMaze(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr && sc == dc) {
            res.add(psf);
            return;
        }

        for (int c = sc + 1; c <= dc; c++) {
            getMaze(sr, c, dr, dc, psf + "h" + (c - sc));
        }
        for (int r = sr + 1; r <= dr; r++) {
            getMaze(r, sc, dr, dc, psf + "v" + (r - sr));
        }
        for (int diar = sr + 1, diac = sc + 1; dr <= dr && diac <= dc; diar++, diac++) {
            getMaze(diar, diac, dr, dc, psf + "d" + (diar - sr));
        }
    }

    public static ArrayList<String> getMaze2(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> bArrL = new ArrayList<>();
            bArrL.add("");
            return bArrL;
        }

        ArrayList<String> myArrL = new ArrayList<>();

        ArrayList<String> slice = new ArrayList<>();

        for (int c = sc + 1; c <= dc; c++) {
            slice = getMaze2(sr, c, dr, dc);
            for (String slices : slice) {
                myArrL.add("h" + (c - sc) + slices);
            }
        }
        for (int r = sr + 1; r <= dr; r++) {
            slice = getMaze2(r, sc, dr, dc);
            for (String slices : slice) {
                myArrL.add("v" + (r - sr) + slices);
            }
        }

        for (int diar = sr + 1, diac = sc + 1; diar <= dr && diac <= dc; diar++, diac++) {
            slice = getMaze2(diar, diac, dr, dc);
            for (String slices : slice) {
                myArrL.add("d" + (diar - sr) + slices);
            }
        }

        return myArrL;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        // getMaze(0, 0, r - 1, c - 1, "");
        // System.out.println(res);

        // method 2

        ArrayList<String> res = getMaze2(0, 0, r - 1, c - 1);
        System.out.println(res);
    }
}