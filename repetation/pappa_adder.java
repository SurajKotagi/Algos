import java.util.*;
import java.io.*;

public class pappa_adder {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int cnt = 0;
        double x = 0;
        double sum = 0;
        while (true) {
            if (cnt % 2 == 0) {
                x = scn.nextDouble();
                sum += x;
            } else {
                String s = scn.nextLine();
            }
            cnt++;
            System.out.println(sum);
        }

    }
}