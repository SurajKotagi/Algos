import java.util.*;
import java.io.*;

public class l69_factorial {
    public static int fact(int n) {
        if (n == 1) {
            return 1;
        }

        int fact_t_nm1 = fact(n - 1);
        return fact_t_nm1 * n;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(fact(n));
    }
}