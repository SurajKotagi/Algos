import java.util.*;
import java.io.*;

public class prime_factorisation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int number = scn.nextInt();
        for (int i = 2; i * i < number; i++) {
            while (number % i == 0) {
                System.out.println(i);
                number = number / i;
            }
        }
        if (number != 1) {
            System.out.println(number);
        }
    }
}