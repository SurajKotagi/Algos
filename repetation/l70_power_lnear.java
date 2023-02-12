import java.util.*;
import java.io.*;

public class l70_power_lnear {
    public static void pow(int x, int n, int p) {
        if (n == 0) {
            System.out.println(p);
            return;
        }

        p = p * x;
        pow(x, n - 1, p);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();

        pow(x, n, 1);
    }
}