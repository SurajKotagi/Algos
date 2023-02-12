import java.util.*;
import java.io.*;

public class l82_get_stair_paths {
    static ArrayList<String> res = new ArrayList<>();

    public static void rec(int n, String psf) {
        if (n == 0) {
            res.add(psf);
            return;
        } else if (n < 0) {
            return;
        }

        rec(n - 1, psf + "1");
        rec(n - 2, psf + "2");
        rec(n - 3, psf + "3");
    }

    public static ArrayList<String> rec2(int n) {
        if (n <= 0) {
            ArrayList<String> bArrL = new ArrayList<>();
            if (n == 0) {
                bArrL.add("");
                return bArrL;
            } else {
                return bArrL;
            }

        }

        ArrayList<String> slice1 = rec2(n - 1);
        ArrayList<String> slice2 = rec2(n - 2);
        ArrayList<String> slice3 = rec2(n - 3);

        ArrayList<String> myArrL = new ArrayList<>();

        for (String slices : slice1) {
            myArrL.add("1" + slices);
        }
        for (String slices : slice2) {
            myArrL.add("2" + slices);
        }
        for (String slices : slice3) {
            myArrL.add("3" + slices);
        }

        return myArrL;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // method 1

        // rec(n, "");
        // System.out.println(res);

        // method 2

        ArrayList<String> res = rec2(n);
        System.out.println(res);
    }
}