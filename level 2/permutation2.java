import java.io.*;
import java.util.*;

public class permutation2 {

    // cb - current box
    // tb - total number of boxes (n)
    // items array - boolean array representing whether element is used or not
    // ssf - selections so far
    // ts - total selections to be made (r)
    // asf - answer so far
    public static void permutations(int cb, int tb, boolean[] items, int ssf, int ts, String asf) {
        // base case
        // all boxes are filled i.e current box > total boxes
        if (cb > tb) {
            // we have to check selections so far made are equal to selections need to be
            // made
            if (ssf == ts) {
                System.out.println(asf);
            }
            return; // dont forget this 😂
        }

        // current box can be filled by any one of the item or it may remain empty

        // choice - that any one item can be placed in it
        // for loop for calling for all items
        for (int i = 0; i < items.length; i++) { // here other than ts we can use items.length also
            // we have to check whether item is already used
            if (items[i] == false) {
                items[i] = true;
                permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1)); // bracket is most important
                items[i] = false;
            }
        }

        // choice - to remain empty
        permutations(cb + 1, tb, items, ssf, ts, asf + "0");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(1, nboxes, new boolean[ritems], 0, ritems, "");
    }

}