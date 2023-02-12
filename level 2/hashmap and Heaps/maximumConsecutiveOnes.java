import java.util.*;

public class maximumConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int count = 0;
        int j = -1;
        int mlen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
            while (count > 1) {
                j++;
                if (arr[j] == 0) {
                    count--;
                }
            }
            mlen = Math.max(mlen, i - j);
        }
        return mlen;
    }

}
