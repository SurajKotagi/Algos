import java.util.*;
import java.io.*;

public class l33_anybase_to_decimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // method 1

        // int n = scn.nextInt();
        // int b = scn.nextInt();

        // int c = 0;
        // int res = 0;
        // while (n > 0) {
        // int d = n % 10;
        // res += d * Math.pow(b, c);

        // c++;
        // n /= 10;
        // }
        // System.out.print(res);

        // method 2

        String n = scn.next();
        int b = scn.nextInt();

        System.out.print(Integer.parseInt(n, b));
    }
}