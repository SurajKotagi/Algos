import java.util.*;
import java.io.*;

public class pow {
    public static void main(String[] args) {

    }

    public double Pow(double x, int n) {
        // base case
        if (n == 0)
            return 1;
        // edge case
        if (n == Integer.MIN_VALUE) {
            x = 1 / (x * x);
            n = Integer.MAX_VALUE;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double n1 = Pow(x, n / 2);

        return (n % 2 == 0) ? n1 * n1 : n1 * n1 * x;
    }

}