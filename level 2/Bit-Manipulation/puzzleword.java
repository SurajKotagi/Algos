import java.io.*;
import java.util.*;

public class puzzleword {
    // conditions to be valid
    // word should contain first character of puzzle
    // puzzle should contain all characters of word

    public static ArrayList<Integer> solution(String[] words, String[] puzzles) {
        // making hashmap of characters and masks of words which contain that character
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();

        // making hashmap ready for operation
        for (char ch = 'a'; ch <= 'z'; ch++) {
            hm.put(ch, new ArrayList<>());
        }

        // making masks of words
        for (String word : words) {

            int wmask = 0;

            // note: 'c' - 'a' gives 2
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                wmask = wmask | (1 << idx);
            }

            // adding the created mask to the corresponding arraylists
            // to prevent duplication of masks in arraylist we make hashset

            // cwordhs - hashset for current word,only monitors repetation of character in
            // current word
            // fresh hashset gets created for next iteration word
            HashSet<Character> cwordhs = new HashSet<>();
            for (char ch : word.toCharArray()) {
                if (cwordhs.contains(ch) == false) {
                    cwordhs.add(ch);
                    // adding word to character array map
                    ArrayList<Integer> pal = hm.get(ch); // previous arrayList for character
                    pal.add(wmask);
                    hm.put(ch, pal);
                }
            }
        }
        // by the above code the masks of all the words are added to the respective
        // arrraylists in the hm
        //
        // now for each puzzle we have to check the matches
        // if the puzzle is for example suraj then we check in only 's' characters
        // arraylist for matches

        ArrayList<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            // making mask or puzzle
            int pmask = 0;

            // note: 'c' - 'a' gives 2
            for (char ch : puzzle.toCharArray()) {
                int idx = ch - 'a';
                pmask = pmask | (1 << idx);
            }

            char ch = puzzle.charAt(0);
            ArrayList<Integer> mal = hm.get(ch); // mal - match arrayList

            int match_count = 0;
            for (int m : mal) {
                if ((m & pmask) == m) {
                    match_count++;
                }
            }
            ans.add(match_count);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        int m = scn.nextInt();
        String[] puzzles = new String[m];
        for (int i = 0; i < m; i++) {
            puzzles[i] = scn.next();
        }

        ArrayList<Integer> ans = solution(words, puzzles);
        for (int i = 0; i < m; i++) {
            System.out.println(puzzles[i] + " -> " + ans.get(i));
        }

    }

}