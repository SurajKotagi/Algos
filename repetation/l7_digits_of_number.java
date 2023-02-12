import java.util.*;

public class l7_digits_of_number {
    public static void rec(String s) {
        if (s.length() == 0) {
            return;
        }

        char x = s.charAt(0);
        System.out.println(x);
        rec(s.substring(1, s.length()));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        // method 1

        // int temp = num;

        // int count = 1;
        // while (num > 0) {
        // count *= 10;
        // num /= 10;
        // }
        // count /= 10;

        // int rev_num = 0;
        // while (temp > 0) {
        // int d = temp % 10;
        // rev_num += d * count;

        // temp /= 10;
        // count /= 10;
        // }

        // while (rev_num > 0) {
        // int d = rev_num % 10;
        // System.out.println(d);
        // rev_num /= 10;
        // }

        // method 2

        // String s = num + "";
        // for (int i = 0; i < s.length(); i++) {
        // System.out.println(s.charAt(i));
        // }

        // method 3

        // char[] arr = (num + "").toCharArray();
        // for (char val : arr) {
        // System.out.println(val);
        // }

        // method 4

        // rec(num + "");
    }
}