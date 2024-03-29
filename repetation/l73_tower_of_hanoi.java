import java.util.*;
import java.io.*;

public class l73_tower_of_hanoi {
    public static void toh(int n, int t1, int t2, int t3) {
        if (n == 0) {
            return;
        }

        toh(n - 1, t1, t3, t2);
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        toh(n - 1, t3, t2, t1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int t1 = scn.nextInt();
        int t2 = scn.nextInt();
        int t3 = scn.nextInt();

        toh(n, t1, t2, t3);
    }
}