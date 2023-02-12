import java.io.*;
import java.util.*;

public class pepcoderandbits {
    public static long ncr(long n, long r) {
        if (n < r) {
            return 0L;
        }

        long res = 1L;

        for (long i = 0L; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }

        return res;
    }

    public static long solution(long n, long k, long within) {
        // long is from 0 to 64 so initially within is 63
        // means we are checking within all 63 bits

        // base case
        if (within == 0) {
            return 0;
        }

        // now we have to check msb of the number is 1 or 0
        // preparing mask
        long mask = 1l << within;

        long final_res = 0;

        if ((mask & n) == 0) { // indicating msb is 0
            // just pass the call to next iteration
            final_res = solution(n, k, within - 1);
        } else {
            // numbers smaller than 1xxx and having same bits on as of 1xxx has two chances
            // 1. msb is 0 and there are same no. of set bits after 0 as of 1xxx
            // 2. msb is 1 and there are -1 the as that of 1xxx set bits

            // call by taking msb as (1)
            long res1 = solution(n, k - 1, within - 1);

            // if we take msb as 0 then
            // for number to be smaller than 1xxx and having same bits on there are ncr
            // chances
            long res2 = ncr(within, k); // <-- (imp) easy

            final_res = res1 + res2;

        }
        return final_res;
    }

    public static long csb(long n) {
        long res = 0;

        while (n > 0) {
            long rsb = n & -n;
            n -= rsb;
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        long k = csb(n);
        System.out.println(solution(n, k, 63));
    }

}