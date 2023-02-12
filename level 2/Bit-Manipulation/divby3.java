import java.io.*;
import java.util.*;

public class divby3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        // algorithm
        // 11 is binary of three, if number is divisible by 11 in binary then it is
        // divisible by three in decimal
        // number is divisible by 11 in binary if number of even - odd bits is multiple
        // of 11

        int even = 0;
        int odd = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - '0';
            if (val % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int delta = even - odd;
        if (delta % 11 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}