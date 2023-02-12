import java.io.*;
import java.util.*;

public class permutation1 {

    public static void permutations(int[] boxes, int level, int pairOf) {
        if (level > pairOf) {
            for (int x : boxes) {
                System.out.print(x);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = level; // values 1 can go in four boxes provided that previously 0 is present in box
                permutations(boxes, level + 1, pairOf);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }

}