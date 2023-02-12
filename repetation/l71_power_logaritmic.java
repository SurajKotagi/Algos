import java.util.*;
import java.io.*;

public class l71_power_logaritmic {
    public static int rec(int x, int n, int p) {
        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            p = rec(x, n / 2, p) * rec(x, n / 2, p);
        } else {
            p = rec(x, n / 2, p) * rec(x, n / 2, p) * x;
        }

        return p;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();

        int ans = rec(x, n, 1);
        System.out.println(ans);
    }
}