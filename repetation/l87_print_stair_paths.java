import java.util.*;
import java.io.*;

public class l87_print_stair_paths {
    public static void printSP(int n, String psf) {
        if (n <= 0) {
            if (n == 0) {
                System.out.println(psf);
            }
            return;
        }

        printSP(n - 1, psf + "1");
        printSP(n - 2, psf + "2");
        printSP(n - 3, psf + "3");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printSP(n, "");
    }
}