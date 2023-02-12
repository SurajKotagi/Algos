import java.util.*;
import java.io.*;

public class Maths {
    public static Boolean isPalindromeNumber(int n) {
        // negetive numbers are not palindromes
        if (n < 0)
            return false;

        // make coppy of n
        int copy = n;

        // find the max base
        long max_base_of_n = 1;
        while (n > 0) {
            n = n / 10;
            max_base_of_n = max_base_of_n * 10;
        }
        max_base_of_n = max_base_of_n / 10;

        // rev the number
        n = copy;
        long rev = 0;
        while (n > 0) {
            int mod = n % 10;
            rev = rev + (mod * max_base_of_n);

            max_base_of_n = max_base_of_n / 10;
            n = n / 10;
        }

        n = copy;
        return rev == n;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(10));
    }
}
