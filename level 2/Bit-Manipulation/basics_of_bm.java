import java.io.*;
import java.util.*;

public class basics_of_bm {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int i = scn.nextInt();
        int j = scn.nextInt();
        int k = scn.nextInt();
        int m = scn.nextInt();

        // for making ON ith bit of n
        int onmask = (1 << i);

        // for switching OFF jth bit of n
        int offmask = ~(1 << j);

        // toggling kth bit
        int toggler = (1 << k);

        // check mth bit
        int checker = (1 << m);

        // ON
        System.out.println(n | onmask);

        // OFF
        System.out.println(n & offmask);

        // toggle
        System.out.println(n ^ toggler);

        // check
        // (important) you cannot check (n&checker) == 1 beacause after & its not always
        // 1
        System.out.println((n & checker) == 0 ? false : true);
    }

}