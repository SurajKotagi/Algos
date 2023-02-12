import java.util.*;
import java.io.*;

public class l65_print_all_permutation_of_string_itereatively {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        // method 1

        // boolean[] visited = new boolean[s.length()];
        // rec(s, "", visited, 0, 0);

        // method 2 (unique algorithm)

        int n = s.length();
        int f = fact(n);

        for (int i = 0; i < f; i++) {
            StringBuilder str = new StringBuilder(s);
            int temp = i;
            int d = n;
            while (d != 0) {
                int loc = temp % d;
                temp /= d;

                d--;
                System.out.print(str.charAt(loc));
                str.deleteCharAt(loc);
            }
            System.out.println();
        }
    }

    public static int fact(int n) {
        int ans = 1;
        for (int i = n; i >= 1; i--) {
            ans *= i;
        }
        return ans;
    }

    public static void rec(String s, String res, boolean[] visited, int n, int idx) {
        if (n == s.length()) {
            System.out.println(res);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                rec(s, res + s.charAt(i), visited, n + 1, i);
                visited[i] = false;
            }
        }
    }
}