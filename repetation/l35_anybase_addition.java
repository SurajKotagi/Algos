import java.util.*;
import java.io.*;

public class l35_anybase_addition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int res = 0;
        int mul = 1;
        int c = 0;
        while (n1 > 0 && n2 > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;

            int sdig = d1 + d2 + c;

            if (sdig < b) {
                c = 0;
            } else {
                c = 1;
                sdig %= b;
            }
            res += sdig * mul;

            n1 /= 10;
            n2 /= 10;
            mul *= 10;
        }
        while (n2 > 0) {
            int d = n2 % 10;

            int sdig = d + c;

            if (sdig < b) {
                c = 0;
            } else {
                c = 1;
                sdig %= b;
            }
            res += sdig * mul;

            n2 /= 10;
            mul *= 10;
        }
        while (n1 > 0) {
            int d = n1 % 10;

            int sdig = d + c;

            if (sdig < b) {
                c = 0;
            } else {
                c = 1;
                sdig %= b;
            }
            res += sdig * mul;

            n1 /= 10;
            mul *= 10;
        }
        if (c == 1) {
            res += c * mul;
        }
        System.out.println(res);
    }
}