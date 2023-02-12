import java.io.*;
import java.util.*;

public class combination {
    // cb - current box
    // tb - total boxes
    // ssf - selected so far
    // ts - total selctions
    // asf - answer so far
    public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
        // base case
        // if all boxes have made their decisions i.e current box > total boxes
        if (cb > tb) {
            // still we have to make sure that we need ts selections in our answer
            // selections so far is equal to selections we want
            if (ssf == ts) {
                System.out.println(asf);
            }
            return;
        }

        // call that box wants to store value in it
        combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
        // call that box dont wants to hold any value
        combinations(cb + 1, tb, ssf, ts, asf + "-");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(1, nboxes, 0, ritems, "");
    }

}