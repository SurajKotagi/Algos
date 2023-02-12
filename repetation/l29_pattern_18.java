import java.util.*;
import java.io.*;

public class l29_pattern_18 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sp = 0;
        int s = n;
        int ms = n - 4;
        for (int i = 1; i <= n; i++) {
            if (i <= n / 2) {
                if (i == 1) {
                    for (int j = 1; j <= n; j++) {
                        System.out.print("*\t");
                    }

                } else {
                    for (int j = 1; j <= sp; j++) {
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                    for (int j = 1; j <= ms; j++) {
                        System.out.print("\t");
                    }
                    System.out.print("*\t");
                    ms -= 2;
                }
            } else {
                for (int j = 1; j <= sp; j++) {
                    System.out.print("\t");
                }
                for (int j = 1; j <= s; j++) {
                    System.out.print("*\t");
                }
                for (int j = 1; j <= sp; j++) {
                    System.out.print("\t");
                }
            }

            if (i <= n / 2) {
                s -= 2;
                sp += 1;
            } else {
                s += 2;
                sp -= 1;
            }
            System.out.println();
        }
    }
}