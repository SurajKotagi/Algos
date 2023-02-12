import java.util.*;
import java.io.*;

public class l37_anybase_multiplication {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int m = scn.nextInt();
        int n = scn.nextInt();

        ArrayList<Integer> res_arr = new ArrayList<>();

        while (n > 0) {
            int nd = n % 10;

            int res = 0;
            int temp = m;
            int mmul = 1;
            int c = 0;
            while (temp > 0) {
                int md = temp % 10;
                int mult = nd * md + c;
                int dig = 0;
                if (mult >= b) {
                    dig = mult % b;
                    c = mult / b;
                } else {
                    c = 0;
                    dig = mult;
                }
                res += dig * mmul;

                temp /= 10;
                mmul *= 10;
            }
            if (c > 0) {
                res += c * mmul;
            }
            res_arr.add(res);

            n /= 10;
        }

        int ores = 0;
        int omul = 1;
        for (int k : res_arr) {
            // System.out.println(k);
            ores = any_base_adder(ores, k * omul, b);
            omul *= 10;
        }
        System.out.println(ores);
    }

    public static int any_base_adder(int n1, int n2, int b) {
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
        return res;
    }
}