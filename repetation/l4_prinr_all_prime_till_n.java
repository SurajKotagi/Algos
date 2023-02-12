import java.util.*;
import java.io.*;

public class l4_prinr_all_prime_till_n {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int l = scn.nextInt();
        int h = scn.nextInt();

        // boolean[] isnotPrime = new boolean[h + 1];
        // prime(isnotPrime, h);
        // for (int i = l; i <= h; i++) {
        // if (isnotPrime[i] == false) {
        // System.out.println(i);
        // }
        // }

        // for (int i = l; i <= h; i++) {
        // if (isPrime(i) == true) {
        // System.out.println(i);
        // }
        // }

        best(h);
        for (int i = l; i <= h; i++) {
            if (i == 2) {
                System.out.println(i);
            } else if (i % 2 == 1 && notPrime[i / 2] == 0) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void prime(boolean[] isnotPrime, int h) {
        for (int i = 2; i * i <= h; i++) {
            if (isnotPrime[i] == false) {
                for (int j = i * i; j <= h; j += i) {
                    if (isnotPrime[j] == false) {
                        isnotPrime[j] = true;
                    }
                }
            }
        }
    }

    static int[] notPrime = new int[500001];

    public static void best(int n) {
        notPrime[0] = 1;
        for (int i = 3; i * i <= n; i += 2) {
            if (notPrime[i / 2] == 0) {
                for (int j = i * 3; j <= n; j += 2 * i) {
                    notPrime[j / 2] = 1;
                }
            }
        }
    }
}
