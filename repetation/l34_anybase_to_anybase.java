import java.util.*;
import java.io.*;

public class l34_anybase_to_anybase {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();

        int ndec = 0;
        int p = 0;
        while (n > 0) {
            int d = n % 10;
            ndec += d * Math.pow(b1, p);

            n /= 10;
            p++;
        }

        int res = 0;
        int mul = 1;
        while (ndec > 0) {
            int d = ndec % b2;
            res += d * mul;

            ndec /= b2;
            mul *= 10;
        }
        System.out.println(res);
    }
}