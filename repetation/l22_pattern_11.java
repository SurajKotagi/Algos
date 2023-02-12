import java.util.*;
import java.io.*;

public class l22_pattern_11 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int x = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i) {
                    System.out.print(x + "\t");
                    x++;
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}