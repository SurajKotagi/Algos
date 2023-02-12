import java.util.*;
import java.io.*;

public class l51_2d_arrays_demo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(scn.nextInt() + "\t");
            }
            System.out.println();
        }
    }
}