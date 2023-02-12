import java.util.*;
import java.io.*;

public class l31_digit_frequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();

        int c = 0;
        while (n > 0) {
            int x = n % 10;
            if (x == d)
                c++;
            n /= 10;
        }
        System.out.println(c);
    }
}