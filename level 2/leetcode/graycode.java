import java.util.*;
import java.io.*;

public class graycode {
    public static void main(String[] args) {
        List<String> gc = grayCode(3);

        List<Integer> res = new ArrayList<>();
        for (String a : gc) {
            res.add(Integer.parseInt(a, 2));
        }
        System.out.println(res);
    }

    public static List<String> grayCode(int n) {
        if (n == 1) {
            List<String> bcase = new ArrayList<>();
            bcase.add("0");
            bcase.add("1");
            return bcase;
        }

        List<String> parr = grayCode(n - 1);
        // List<Integer> carr = new ArrayList<>();

        List<String> csarr = new ArrayList<>();
        for (int a = 0; a < parr.size(); a++) {
            csarr.add("0" + parr.get(a) + "");
        }

        for (int a = parr.size() - 1; a >= 0; a--) {
            csarr.add("1" + parr.get(a) + "");
        }

        return csarr;
    }
}
