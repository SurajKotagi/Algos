import java.io.*;
import java.util.*;

public class permutation_words_1 {
    // cb - current box for which we are deciding
    // tb - total boxes available
    // asf - answer so far (whenever we decide to put character in box we add that
    // ch to this string)

    public static void generateWords(int cb, int tb, HashMap<Character, Integer> fmap, String asf) {
        // base case
        // when all boxes are filled we can print asf i.e
        if (cb > tb) {
            System.out.println(asf);
            return;
        }

        // when we are told to find arrangements of words there is no option available
        // for box to remain empty,because all boxes need to used
        // options available are ,we can put any ch of word to cbox
        // note: repeted characters are put only once (aabc and aabc are the same)

        // for loop for calling for all possible options for current box
        for (char key : fmap.keySet()) {
            if (fmap.get(key) > 0) {
                fmap.put(key, fmap.get(key) - 1);
                generateWords(cb + 1, tb, fmap, asf + key);
                fmap.put(key, fmap.get(key) + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // the letters of the word are put ino hash map with their frequency
        HashMap<Character, Integer> fmap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (fmap.containsKey(ch)) {
                fmap.put(ch, fmap.get(ch) + 1);
            } else {
                fmap.put(ch, 1);
            }
        }

        generateWords(1, str.length(), fmap, "");
    }

}