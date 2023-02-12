import java.util.*;
import java.io.*;

public class l9_inverse_of_number {
    public static int dec_giver(int n) {
        int res = 1;
        while (n != 0) {
            res *= 10;
            n -= 1;
        }
        return res /= 10;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        // method 1

        // int res = 0;
        // int n = 1;
        // while (num > 0) {
        // int d = num % 10;
        // res += n * dec_giver(d);

        // n++;
        // num /= 10;
        // }
        // System.out.println(res);

        // method 2

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        int c = 1;
        while (num > 0) {
            int d = num % 10;
            map.put(d, i);
            i++;
            num /= 10;
            c *= 10;
        }
        c /= 10;

        int res = 0;
        for (int k = i - 1; k >= 1; k--) {
            res += map.get(k) * c;
            c /= 10;
        }
        System.out.println(res);
    }
}