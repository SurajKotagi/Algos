import java.util.*;
import java.io.*;

public class tcs {
    public static void main(String[] args) {
        int n = 123;

        int temp = n;

        int count = 1;
        while (temp > 0) {
            count++;
            temp = temp / 10;
        }
        count--;

        int temp2 = n;
        int mul = 1;
        while (count != 0) {
            mul = mul * 10;
            count--;
        }
        mul = mul / 10;
        int temp3 = n;
        int rev = 0;
        while (temp3 > 0) {
            int d = temp3 % 10;
            rev += d * mul;
            temp3 /= 10;
            mul /= 10;
        }
        System.out.println(rev == n);
    }
}