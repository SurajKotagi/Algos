import java.io.*;
import java.util.*;

public class employeeandmanager {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        HashMap<String, String> hm = new HashMap<>();
        String ceo = "";
        for (int i = 0; i < n; i++) {
            String emp = scn.next();
            String man = scn.next();

            if (emp.equals(man) == true) {
                ceo = man;
            } else {
                hm.put(emp, man);
            }
        }
        // System.out.println(ceo);

        HashMap<String, HashSet<String>> tree = new HashMap<>();
        for (String emp : hm.keySet()) {
            String man = hm.get(emp);

            if (tree.containsKey(man) == true) {
                HashSet<String> hs = tree.get(man);
                hs.add(emp);
                tree.put(man, hs);
            } else {
                HashSet<String> hs = new HashSet<>();
                hs.add(emp);
                tree.put(man, hs);
            }
        }

        HashMap<String, Integer> workersUnderMe = new HashMap<>();
        int res = getSize(tree, ceo, workersUnderMe);
        for (String people : workersUnderMe.keySet()) {
            System.out.println(people + " " + workersUnderMe.get(people));
        }
    }

    public static int getSize(HashMap<String, HashSet<String>> tree, String ceo,
            HashMap<String, Integer> workersUnderMe) {
        if (tree.containsKey(ceo) == false) {
            workersUnderMe.put(ceo, 0);
            return 1;
        }

        int cs = 0;
        for (String Child : tree.get(ceo)) {
            cs += getSize(tree, Child, workersUnderMe);
        }
        workersUnderMe.put(ceo, cs);
        return cs + 1;

    }

}