import java.util.*;

public class longestsubarraywith0sum {

    public static int solution(int[] arr) {
        int max_len = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;

        HashMap<Integer, Integer> omap = new HashMap<>();
        omap.put(0, -1);
        while (i < arr.length) {
            // adding ith element
            sum += arr[i];

            // checking whether sum is previously present
            if (omap.containsKey(sum)) {
                max_len = Math.max(max_len, i - omap.get(sum));
            } else {
                omap.put(sum, i);
            }
            i = i + 1;
        }
        return (max_len == Integer.MIN_VALUE) ? 0 : max_len;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
