import java.io.*;
import java.util.*;

public class combination_2 {
  // ci - current index
  // ti - total indexes available
  // li - last index
  // boxes[] - array of n boxes which can be filled

  public static void combinations(int[] boxes, int ci, int ti, int li) {
    // base case
    if (ci > ti) {
      for (int x : boxes) {
        if (x == 0) {
          System.out.print("_ ");
        } else {
          System.out.print("i ");
        }
      }
      System.out.println();
      return;
    }
    // i i _ _
    // i _ i _
    // i _ _ i
    // _ i i _
    // _ i _ i
    // _ _ i i
    for (int i = li + 1; i < boxes.length; i++) {
      if (boxes[i] == 0) {
        boxes[i] = 1;
        // for (int x : boxes) {
        // if (x == 0) {
        // System.out.print("_ ");
        // } else {
        // System.out.print("i ");
        // }
        // }
        // System.out.println();
        combinations(boxes, ci + 1, ti, i);
        boxes[i] = 0;
        // for (int x : boxes) {
        // if (x == 0) {
        // System.out.print("_ ");
        // } else {
        // System.out.print("i ");
        // }
        // }
        // System.out.println();
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}