import java.util.*;
import java.io.*;

public class l80_getsubsequence {
    static ArrayList<String> ans = new ArrayList<>();

    public static void getSS(String s, int st, int j, int len, String psf) {
        if (st == len) {
            ans.add(psf);
            return;
        }
        getSS(s, st + 1, j + 1, len, psf);
        getSS(s, st + 1, j + 1, len, psf + s.charAt(j));
    }

    public static ArrayList<String> getSS2(String s) {
        if (s.length() == 0) {
            ArrayList<String> bArrL = new ArrayList<>();
            bArrL.add("");
            return bArrL;
        }

        ArrayList<String> slice = getSS2(s.substring(1, s.length()));

        ArrayList<String> myArrL = new ArrayList<String>();
        for (String slices : slice) {
            myArrL.add("" + slices);
        }
        for (String slices : slice) {
            myArrL.add(s.charAt(0) + slices);
        }
        return myArrL;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        // Method 1

        // getSS(s, 0, 0, s.length(), "");
        // System.out.println(ans);

        // Method 2
        ArrayList<String> res = getSS2(s);
        System.out.println(res);
    }

}