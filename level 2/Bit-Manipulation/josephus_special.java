import java.io.*;
import java.util.*;

public class josephus_special {

    public static int solution(int n) {
        // every 2nd person is killed
        // if we represent n ans 2^x + l , where x is max pssible value
        // the survivor = 2l + 1

        // example for n = 6
        // firstly all numbers with last bit 0 are killed
        // the last bit of the last person tells who is going to be killed in next
        // iteration
        // the numbers with same bit(in 2nd last position) as of last persons last bit
        // are safe
        // this procedure continues

        // firstly all members with 0 at last are killed
        // 001
        // 010
        // 011
        // 100
        // 101
        // 110

        // last member is (110)

        // 001
        // 011
        // 101

        // 11(0)<-- tells that all members with 1 at 2nd last position will be killed in
        // next iteration

        // 001
        // 101

        // 1(1)0 tells that all members with 0 at the 3rd last position are going to be
        // killed
        // 101

        // so we can see from above that in 110 the deciding factor is (10)
        // (10) = 100 + 10
        // where 100 --> 2^x
        // 10 = l
        // ans = 2l + 1 i.e 10 + 10 = 100 >> 100 + 1 = 101

        int l = n - mpow(n);
        // System.out.println(l);
        return (2 * l + 1);
    }

    public static int mpow(int n) {
        // int mp = 0;
        int i = 2;
        while (i <= n) {
            // mp++;
            i = i * 2;
        }
        return i / 2;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(solution(n));
    }

}