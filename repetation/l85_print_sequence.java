import java.util.*;
import java.io.*;

public class l85_print_sequence {
    public static void printSS(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }

        String ros = s.substring(1, s.length());
        printSS(ros, ans + s.charAt(0));
        printSS(ros, ans);
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        printSS(s, "");
    }
}