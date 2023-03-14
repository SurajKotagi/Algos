import java.util.*;
import java.io.*;

public class Functions_and_Arrays {
    public static void main(String[] args) {
        /*
         * ANY BASE TO DECIMAL CONVERTER
         * DECIMAL TO ANY BASE CONVERTER
         * ANY BASE ADDER
         */

    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    // ANY BASE TO DECIMAL CONVERTER |
    ////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * (interger value need to be converted , current base of that integer)
     * returns value in decimal
     */
    public static int anyBaseToDecimal(int n, int base) {
        int ans = 0;
        int count = 0;

        while (n > 0) {
            int mod = n % 10;
            n = n / 10;

            ans = ans + (int) (mod * Math.pow(base, count));
            count++;
        }
        return ans;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    // DECIMAL TO ANY BASE CONVERTER |
    ////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * (integer value which is in decimal, base to which it needs to be converted)
     * returns value in particular base
     */
    public static int decimalToAnyBase(int n, int base) {
        int count = 1;
        int ans = 0;

        while (n > 0) {
            int mod = n % base;
            n = n / base;

            ans = ans + mod * count;
            count = count * 10;
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    // ANY BASE ADDER |
    ////////////////////////////////////////////////////////////////////////////////////////////

    /*
     * (base in which two numbers are availible, number 1, number 2)
     * returns added value
     */
    public static int getSum(int b, int n1, int n2) {
        int n1ToDec = anyBaseToDecimal(n1, b);
        int n2ToDec = anyBaseToDecimal(n2, b);

        int sumInDec = n1ToDec + n2ToDec;

        int sumInBase = decimalToAnyBase(sumInDec, b);
        return sumInBase;
    }
}