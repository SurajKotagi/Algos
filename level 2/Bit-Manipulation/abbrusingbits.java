import java.io.*;
import java.util.*;

public class abbrusingbits {

    public static void solve(String str) {
        // in binary int the numbering starts from right towards left, in string its
        // from left to right
        // 01234 - suraj
        // pep pe1 p1p p2 1ep 1e1 2p 3
        // 000 001 010 011 100 101 110 111

        // 0 means - count is added(if not 0) then character is added
        // 1 mean count is incremented

        for (int b = 0; b < (1 << str.length()); b++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                if (((1 << (str.length() - i - 1) & b) == 0)) { // bit is off
                    if (count > 0) {
                        sb.append(count);
                        sb.append(str.charAt(i));
                        count = 0;
                    } else {
                        sb.append(str.charAt(i));
                    }
                } else {
                    count++;
                }
            }
            if (count > 0) {
                sb.append(count);
            }
            System.out.println(sb);
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}