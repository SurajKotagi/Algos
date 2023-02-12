import java.util.*;
import java.io.*;

public class l81_get_kpc {
    static ArrayList<String> res = new ArrayList<>();

    public static void rec(String s, int i, int len, String[] keys, String psf) {
        if (i == len) {
            res.add(psf);
            return;
        }

        String x = keys[Integer.parseInt(s.charAt(i) + "")];
        for (int j = 0; j < x.length(); j++) {
            char c = x.charAt(j);
            rec(s, i + 1, len, keys, psf + c);
        }
    }

    public static ArrayList<String> rec2(String s, String[] keys) {
        if (s.length() == 0) {
            ArrayList<String> bArrL = new ArrayList<>();
            bArrL.add("");
            return bArrL;
        }

        ArrayList<String> slice = rec2(s.substring(1, s.length()), keys);

        String x = keys[Integer.parseInt(s.charAt(0) + "")];
        ArrayList<String> myArrL = new ArrayList<>();
        for (int i = 0; i < x.length(); i++) {
            for (String slices : slice) {
                myArrL.add(x.charAt(i) + slices);
            }
        }

        return myArrL;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        String[] keys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

        // rec(s, 0, s.length(), keys, "");
        // System.out.println(res);

        // method 2
        ArrayList<String> res = rec2(s, keys);
        System.out.println(res);
    }
}