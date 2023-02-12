import java.util.*;
import java.io.*;

public class combinationpermutationpractice {
    public static void main(String[] args) {
        int[] sample1 = { 1, 2, 3 };
        int[] sample2 = { 1, 2, 1 };
        int[] sample3 = { 1, 2, 1, 3, 4 };
        int[] sample4 = { 1, 2, 1, 3, 4 };

        // normal_combinations(-1, sample2, 3, 2, "");

        // normal_combinations2(0, sample1, 4, 2, "");

        // Arrays.sort(sample2);
        // unique_combinations(0, sample2, 3, 2, "");

        // boolean[] visited = new boolean[3];
        // normal_permutations(0, sample2, 3, 3, "", visited);

        // boolean[] visited = new boolean[3];
        // normal_permutations2(0, sample1, 0, 3, 2, "", visited);

        boolean[] visited = new boolean[3];
        unique_permutations(0, sample2, 3, 2, "", visited);

    }

    public static void normal_combinations(int idx, int[] arr, int n, int r, String psf) {
        if (psf.length() == r) {
            System.out.println(psf);
            return;
        }

        for (int i = idx + 1; i < n; i++) {
            normal_combinations(i, arr, n, r, psf + arr[i] + "");
        }
    }

    public static void normal_combinations2(int idx, int[] arr, int n, int r, String psf) {
        if (psf.length() == r) {
            System.out.println(psf);
            return;
        }
        if (idx == arr.length) {
            return;
        }
        // can come / can leave
        normal_combinations2(idx + 1, arr, n, r, psf + arr[idx]);
        normal_combinations2(idx + 1, arr, n, r, psf);
    }

    public static void unique_combinations(int idx, int[] arr, int n, int r, String psf) {
        if (psf.length() == r) {
            System.out.println(psf);
            return;
        }
        if (idx == arr.length) {
            return;
        }
        for (int i = idx; i < n; i++) {
            if (i > idx && arr[i - 1] == arr[i])
                continue;
            unique_combinations(i + 1, arr, n, r, psf + arr[i]);
        }
    }

    public static void normal_permutations(int idx, int[] arr, int n, int r, String psf, boolean[] visited) {

        if (psf.length() == r) {
            System.out.println(psf);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                normal_permutations(idx + 1, arr, n, r, psf + arr[i], visited);
                visited[i] = false;
            }
        }
    }

    public static void normal_permutations2(int idx, int[] arr, int selected, int n, int r, String psf,
            boolean[] visited) {
        if (idx == arr.length) {
            if (selected == r) {
                System.out.println(psf);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                normal_permutations2(idx + 1, arr, selected + 1, n, r, psf + arr[i], visited);
                visited[i] = false;
            }
        }
        normal_permutations2(idx + 1, arr, selected, n, r, psf + "_", visited);
    }

    public static void unique_permutations(int idx, int[] arr, int n, int r, String psf, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                unique_permutations(idx + 1, arr, n, r, psf + arr[i], visited);
                visited[i] = false;
            }
        }
    }
}