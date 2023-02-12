import java.util.*;
import java.io.*;

public class l66_remove_prime {
    public static void remPrime(ArrayList<Integer> arrL) {
        for (int i = 0; i < arrL.size(); i++) {
            if (isPrime(arrL.get(i)) == true) {
                arrL.remove(arrL.get(i));
                i = i - 1;
            }
        }

        System.out.println(arrL);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> arrL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrL.add(scn.nextInt());
        }
        remPrime(arrL);
    }
}