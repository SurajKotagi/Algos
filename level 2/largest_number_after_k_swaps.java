import java.io.*;
import java.util.*;

public class largest_number_after_k_swaps {

    static String max;

    public static void findMaximum(String str, int k) {

        if (Integer.parseInt(str) > Integer.parseInt(max))
            max = str;

        if (k == 0)
            return;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    String swapped = swap(str, i, j);
                    findMaximum(swapped, k - 1);
                }
            }
        }
    }

    public static String swap(String s, int i, int j) {
        String start = s.substring(0, i);
        String middle = s.substring(i + 1, j);
        String end = s.substring(j + 1);

        char ati = s.charAt(i);
        char atj = s.charAt(j);

        return start + atj + middle + ati + end;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        findMaximum(str, k);
        System.out.println(max);
    }

}