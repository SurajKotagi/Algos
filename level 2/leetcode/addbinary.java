import java.util.*;
import java.io.*;

public class addbinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while (i >= 0 || j >= 0) {
            int sum = c;
            if (i >= 0) {
                sum += Integer.parseInt(a.charAt(i--) + "");
            }
            if (j >= 0) {
                sum += Integer.parseInt(b.charAt(j--) + "");
            }

            c = sum / 2;
            sum %= 2;

            sb.append(sum);
        }

        if (c > 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}