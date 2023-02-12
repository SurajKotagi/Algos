import java.util.*;
import java.io.*;

public class l86_print_kpc {
    static String[] keys = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printKPC(String s, String psf) {
        if (s.length() == 0) {
            System.out.println(psf);
            return;
        }

        int x = Integer.parseInt(s.charAt(0) + "");
        String xs = keys[x];

        for (int i = 0; i < xs.length(); i++) {
            char c = xs.charAt(i);
            printKPC(s.substring(1, s.length()), psf + c);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        printKPC(s, "");
    }
}