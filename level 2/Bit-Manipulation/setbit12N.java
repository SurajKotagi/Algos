import java.io.*;
import java.util.*;

public class setbit12N {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }
    // mp - max power
    // sbw2rmp - set bits within 2 raito max power
    // msbsbor - msb set bits of remaining ones
    // sbbrc - set bits by recursive call
    // redn - reduced n

    public static int solution(int n) {
        // algorithm
        // find maximum power of 2 which is less than or equal to n
        // number of set bits in those van be given as max power * 2 ^(max power - 1)
        // now add msb 1s of n - 2^maxpower - 1
        // reduce n to n - 2^maxpower and call for solution
        // base case is that for n == 0 there are no set bits

        // base case
        if (n == 0) {
            return 0;
        }

        int mp = maxPow(n);
        // System.out.println(mp);

        // calculating set bits within 2^mp
        int sbw2rmp = (1 << (mp - 1)) * mp;

        // calculating msb set bits of remaining ones
        int msbsbor = n - (1 << mp) + 1;

        // reducing n --> n - (1 << mp)
        int redn = n - (1 << mp);
        int sbbrc = solution(redn);

        return sbw2rmp + msbsbor + sbbrc;
    }

    public static int maxPow(int n) {
        int p = 0;

        while ((1 << p) <= n) {
            p++;
        }
        // p goes till maxpower + 1 so
        return p - 1;
    }

}