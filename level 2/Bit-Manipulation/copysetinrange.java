import java.io.*;
import java.util.*;

public class copysetinrange {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int left = scn.nextInt();
        int right = scn.nextInt();

        int x = (1 << (right - left + 1));
        int y = x - 1;
        int mask1 = y << (left - 1);

        int mask2 = a & mask1;

        b |= mask2;

        System.out.println(b);

    }

}