import java.util.*;
import java.io.*;

public class a1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += scn.nextInt();
            sum2 += scn.nextInt();
            sum3 += scn.nextInt();
        }
        if (sum1 == 0 && sum2 == 0 && sum3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}