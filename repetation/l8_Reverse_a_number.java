import java.util.*;
import java.io.*;

public class l8_Reverse_a_number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        while (num > 0) {
            int d = num % 10;
            num /= 10;
            System.out.println(d);
        }
    }
}