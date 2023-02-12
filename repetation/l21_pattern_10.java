import java.util.*;
import java.io.*;

public class l21_pattern_10 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int ss = (n / 2) - 1;
        int ms = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                int sp = n / 2;
                for (int k = 1; k <= sp; k++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int k = 1; k <= sp; k++) {
                    System.out.print("\t");
                }
            } else {
                for (int k = 1; k <= ss; k++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int k = 1; k <= ms; k++) {
                    System.out.print("\t");
                }
                System.out.print("*\t");
                for (int k = 1; k <= ss; k++) {
                    System.out.print("\t");
                }

                if (i <= n / 2) {
                    ss -= 1;
                    ms += 2;
                } else {
                    ss += 1;
                    ms -= 2;
                }

            }

            System.out.println();
        }
    }
}