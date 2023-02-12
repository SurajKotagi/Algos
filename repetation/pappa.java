import java.util.*;
import java.io.*;

public class pappa {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double x = 0;
        String ans = "";
        double main_amnt = 115966.87;
        while (true) {
            x = scn.nextDouble();
            if (x == -1)
                break;
            main_amnt -= x;
            ans += main_amnt + "\n";
        }
        System.out.println(ans);
    }
}