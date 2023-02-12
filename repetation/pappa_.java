import java.util.*;
import java.io.*;

public class pappa_ {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double x = 0;
        double sum = 0;
        double main_amnt = 176716.87;
        while (true) {
            x = scn.nextDouble();
            if (x == -1)
                break;
            sum += x;
            // a//ns += main_amnt + "\n";
        }
        System.out.println(sum);
    }
}