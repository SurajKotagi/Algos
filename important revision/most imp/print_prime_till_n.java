import java.util.*;
import java.io.*;

public class print_prime_till_n {
    public static void main(String[] args) {
        // Algorithm (Not optimised)
        // dont go for checking every number is prime or not approach
        // make boolean dp of length n
        // start outerloop from 2 and if that index is false in dp increase the count
        // start the inner loop from 2 and while i * j < n mark i * j th indexs as false

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        boolean[] dp = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    dp[i * j] = true;
                }
            }
        }
        System.out.println(count);

        // optimised
        int res = notPrimeCount(n);
        System.out.println(res);
    }

    // optimised
    public static int notPrimeCount(int n) {

        boolean[] notPrime = new boolean[n];

        // to skip all multiples of two start the loop from 3
        // dont forget to include count of 2
        // take square root of n as the upper bound

        if (n <= 2)
            return 0;
        int count = 1; // as 2 is a prime number
        int upperbd = (int) Math.sqrt(n);

        // start the loop from 3 and increment it by 2 everytime
        for (int i = 3; i < n; i += 2) {
            if (notPrime[i] == true)
                continue;

            count++;

            // to avoid the i*i overflow problem when n itself is very big number
            if (i > upperbd)
                continue;

            // now start from i * i as numbers before them are already marked
            // everytime j is incremented by 2*i as sum of odd numbers is even and we need
            // to skip it
            for (int j = i * i; j < n; j += 2 * i) {
                notPrime[j] = true;
            }
        }
        return count;

    }
}