import java.util.*;
import java.io.*;

public class l90_print_permuatation {
    public static void permutes(String s, String psf) {
        if (s.length() == 0) {
            System.out.println(psf);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1, s.length());
            permutes(ros, psf + x);
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        permutes(s, "");
    }
}