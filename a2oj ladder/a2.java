import java.util.*;
import java.io.*;

public class a2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int loc_i = 0;
        int loc_j = 0;

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                int x = scn.nextInt();
                if (x == 1) {
                    loc_i = i;
                    loc_j = j;
                }
            }
        }

        int moves = 0;
        if (loc_i > 3) {
            moves += loc_i - 3;
        } else {
            moves += 3 - loc_i;
        }

        if (loc_j > 3) {
            moves += loc_j - 3;
        } else {
            moves += 3 - loc_j;
        }
        System.out.println(moves);
    }
}