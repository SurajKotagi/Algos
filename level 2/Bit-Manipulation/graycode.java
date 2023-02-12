import java.util.*;

public class graycode {
    // pres - arraylist of gray codes of n-1
    // cres - current list of graycodes
    public static List<String> grayCode(int n) {
        // base case
        // we have 0 and 1 in list for n = 1

        if (n == 1) {
            List<String> bl = new ArrayList<>();
            bl.add("0");
            bl.add("1");
            return bl;
        }

        List<String> pres = grayCode(n - 1);

        List<String> cres = new ArrayList<>();

        for (int i = 0; i < pres.size(); i++) {
            String val = pres.get(i);
            cres.add("0" + val);
        }
        for (int i = cres.size() - 1; i >= 0; i--) {
            String val = pres.get(i);
            cres.add("1" + val);
        }
        return cres;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if (n == 0) {
            List<Integer> h = new ArrayList<>();
            h.add(0);
            System.out.println(h);
            return;
        }
        List<String> ans = grayCode(n);
        Collections.sort(ans);

        List<Integer> Ans = new ArrayList<>();
        for (String x : ans) {
            Ans.add(Integer.parseInt(x, 2));
        }
        System.out.println(Ans);
    }
}