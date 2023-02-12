import java.io.*;
import java.util.*;

public class nthpalindromicnumberinbinary {

    public static int NthPalindromicBinary(int n) {
        // 2^(l-1) / 2 = number of palindromes of length l

        // length of nth palindrome is need to be find
        int l = 1;
        int nval = 1;

        while (nval < n) {
            l++;
            nval += (1 << (l - 1) / 2);
        }
        nval -= (1 << (l - 1) / 2);// -----> very very hard to get (easy if you thourugh;y study)
        // System.out.println(nval);
        // System.out.println(l);
        int offset = n - nval - 1;
        // System.out.println(offset);

        int palindrome = (1 << (l - 1)); // important 7 shifts leeds to 10000000
        int left_three = (offset << (l / 2));
        palindrome = palindrome | left_three;

        int rev = rev(palindrome >> (l / 2));
        int ans = (rev | palindrome);

        return ans;
    }

    public static int rev(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev | (n & 1);

            n = n >> 1;
            rev = rev << 1;
        }
        rev = rev >> 1;
        return rev;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NthPalindromicBinary(n));
    }

}