import java.util.*;
import java.io.*;

public class l83_get_maze_paths {
    static ArrayList<String> res = new ArrayList<>();

    public static void getMaze(int sr, int sc, int dr, int dc, String psf) {
        if (sr > dr || sc > dc) {
            return;
        } else if (sr == dr && sc == dc) {
            res.add(psf);
            return;
        }

        getMaze(sr, sc + 1, dr, dc, psf + "h");
        getMaze(sr + 1, sc, dr, dc, psf + "v");

    }

    public static ArrayList<String> getMaze2(int sr, int sc, int dr, int dc) {
        if (sr > dr || sc > dc) {
            ArrayList<String> bArrL = new ArrayList<>();
            return bArrL;
        } else if (sr == dr && sc == dc) {
            ArrayList<String> bArrL = new ArrayList<>();
            bArrL.add("");
            return bArrL;
        }

        ArrayList<String> myArrL = new ArrayList<>();

        ArrayList<String> sliceH = getMaze2(sr, sc + 1, dr, dc);
        for (String slices : sliceH) {
            myArrL.add("h" + slices);
        }

        ArrayList<String> sliceV = getMaze2(sr + 1, sc, dr, dc);
        for (String slices : sliceV) {
            myArrL.add("v" + slices);
        }

        return myArrL;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        // mehtod 1

        // getMaze(0, 0, r - 1, c - 1, "");
        // System.out.println(res);

        // method 2

        ArrayList<String> res = getMaze2(0, 0, r - 1, c - 1);
        System.out.println(res);
    }
}