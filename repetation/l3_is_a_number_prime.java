import java.util.*;
import java.io.*;

public class l3_is_a_number_prime {
    public static void isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println("not prime");
                return;
            }
        }
        System.out.println("prime");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        // while (t != 0) {
        // isPrime(scn.nextInt());
        // t--;
        // }

        // method 2
        for (int i = 1; i <= t; i++) {
            int n = scn.nextInt();
            int count = 0;

            if (n == 1) {
                System.out.println("prime");
                continue;
            }
            for (int j = 1; j <= n; j++) {
                if (n % j == 0) {
                    count++;
                }
            }

            if (count == 2) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
        }
    }
}