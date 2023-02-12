import java.util.*;
import java.io.*;

public class tester {
    public static void main(String[] args) {
        String str = "1001001 23455";
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                continue;
            } else if (ch >= '0' && ch <= '9') {
                int j = i;
                i--;
                while (i >= 0 && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i--;
                }
                i++;
                System.out.println(Long.parseLong(str.substring(i, j + 1)));
            }
        }
        System.out.println('1' - '0');
    }
}
