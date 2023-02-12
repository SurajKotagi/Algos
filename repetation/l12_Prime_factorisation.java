import java.util.*;
import java.io.*;

public class l12_Prime_factorisation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        long i = 2;
        while (n != 1) {
            if (n % i == 0) {
                n /= i;
                System.out.print(i + " ");
            } else {
                i++;
            }
        }
    }
}