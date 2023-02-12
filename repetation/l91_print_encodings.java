import java.util.*;
import java.io.*;

public class l91_print_encodings {
    public static void printEnc(String s, String psf) {
        if (s.length() == 1) {
            int lc = Integer.parseInt(s.charAt(0) + "");
            if (lc < 10 && lc != 0) {
                System.out.println(psf + (char) (lc + 'a' - 1));
            }
            return;
        } else if (s.length() == 0) {
            System.out.println(psf);
            return;
        }

        String slice = s.substring(0, 2);
        int char2 = Integer.parseInt(slice + "");
        int char1st = Integer.parseInt(slice.charAt(0) + "");S

        if (char1st != 0) {
            String sep1 = (char) (char1st + 'a' - 1) + "";
            printEnc(s.substring(1, s.length()), psf + sep1);

            if (char2 < 27) {
                printEnc(s.substring(2, s.length()), psf + (char) (char2 + 'a' - 1));
            }
        } else {
            return;
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        printEnc(s, "");
    }
}