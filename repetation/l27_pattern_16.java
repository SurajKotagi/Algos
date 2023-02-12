import java.util.*;
import java.io.*;

public class l27_pattern_16 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sp = (2 * n) - 3;
        int d = 1;
        for (int i = 1; i <= n; i++) {
            int x = 1;
            if (i == n) {
                for (int j = 1; j <= 2 * n - 1; j++) {
                    System.out.print(x + "\t");
                    if (j <= (2 * n - 1) / 2) {
                        x += 1;
                    } else {
                        x -= 1;
                    }
                }
            } else {
                for (int j = 1; j <= d; j++) {
                    System.out.print(x + "\t");
                    x += 1;
                }
                for (int j = 1; j <= sp; j++) {
                    System.out.print("\t");
                    if (j <= sp / 2) {
                        x += 1;
                    } else {
                        x -= 1;
                    }
                }
                for (int j = 1; j <= d; j++) {
                    System.out.print(x + "\t");
                    x -= 1;
                }
            }
            sp -= 2;
            d += 1;
            System.out.println();
        }
    }
}