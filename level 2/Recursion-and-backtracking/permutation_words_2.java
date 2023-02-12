import java.io.*;
import java.util.*;

public class permutation_words_2 {

  // idx - showing the index of letter for which we are deciding
  // str - the word whose arrangements we are finding
  // boxes[] - representing all spots which need to be filled
  // lastOccurence - last occurence map of all the character, defaultly set to -1
  // (gets updated)

  // int this approach we will search for what all choices a letter can make to
  // enter to spot
  public static void generateWords(int idx, String str, Character[] boxes,
      HashMap<Character, Integer> lastOccurence) {

    // base case
    // the recursion ends when we dedide for all letters in string
    if (idx == str.length()) {
      for (char x : boxes) {
        System.out.print(x);
      }
      System.out.println();
      return;
    }

    // getting character at current focusing position
    char ch = str.charAt(idx);

    // getting last occurence of that character
    // -1 indicating that its not used before
    int fch = lastOccurence.get(ch);

    // if there are four boxes and letter 'a' is not used before then it can go in
    // 0th box or 1 or 2 or 3rd box
    // if its used at index 1 then it can go in only 3 or 4
    // i.e boxes available are those who are next to its last occurence

    for (int i = fch + 1; i < boxes.length; i++) {
      // we have to make sure that box is null (important)
      if (boxes[i] == null) {
        lastOccurence.put(ch, i);
        // putting character at ith box
        boxes[i] = ch;
        generateWords(idx + 1, str, boxes, lastOccurence);
        // removing character from the ith index of box
        boxes[i] = null;
        lastOccurence.put(ch, fch);
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for (char ch : str.toCharArray()) {
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}