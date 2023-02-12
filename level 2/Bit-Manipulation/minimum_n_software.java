import java.io.*;
import java.util.*;

public class minimum_n_software {
    // cp - current person
    // int[] people -mask array holding skill mask of people
    // onesol - answer array of people number
    // skills - mask of total skills by people in array

    static ArrayList<Integer> sol = new ArrayList<>();

    public static void solution(int[] people, int cp, ArrayList<Integer> onesol, int skills, int n) {
        if (cp == people.length) {
            int c = (1 << n) - 1;
            if (c == skills) {
                if (onesol.size() < sol.size() || sol.size() == 0) {
                    sol = new ArrayList<>(onesol);
                }
            }
            return;
        }
        solution(people, cp + 1, onesol, skills, n);

        onesol.add(cp);
        solution(people, cp + 1, onesol, (skills | people[cp]), n);
        onesol.remove(onesol.size() - 1);

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<String, Integer> smap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            smap.put(scn.next(), i);
        }

        int np = scn.nextInt();
        int[] people = new int[np];
        for (int i = 0; i < np; i++) {
            int personSkills = scn.nextInt();
            for (int j = 0; j < personSkills; j++) {
                String skill = scn.next();
                int snum = smap.get(skill);
                people[i] = people[i] | (1 << snum);
            }
        }

        solution(people, 0, new ArrayList<>(), 0, n);
        System.out.println(sol);

    }
}