import java.util.*;
import java.io.*;

public class l23_pattern_12 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int n1 = 0;
        int n2 = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    System.out.print(n1 + "\t");
                } else if (i == 2 && j == 1) {
                    System.out.print(n2 + "\t");
                } else if (j <= i) {
                    System.out.print(n1 + n2 + "\t");
                    int temp = n2;
                    n2 = n1 + n2;
                    n1 = temp;
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}