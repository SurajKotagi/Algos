import java.util.*;
import java.io.*;

public class l26_pattern_15 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sp = n / 2;
        int d = 1;
        for (int i = 1; i <= n; i++) {
            int x = 0;
            if (i <= n / 2) {
                x = i;
            } else {
                x = n - i + 1;
            }

            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= d; j++) {
                System.out.print(x + "\t");
                if (j <= d / 2) {
                    x += 1;
                } else {
                    x -= 1;
                }
            }
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            if (i <= n / 2) {
                sp--;
                d += 2;
            } else {
                sp++;
                d -= 2;
            }
            System.out.println();
        }

    }
}