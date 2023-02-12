import java.util.*;
import java.io.*;

public class hm {
    public static void main(String[] args) {
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // Arrays.sort(nums1);
        // hm.put(nums1[0], hm.getOrDefault(nums1[0], 0) + 1);
        // for (int i = 1; i < nums1.length; i++) {
        // if (nums1[i] != nums1[i - 1]) {
        // hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        // }
        // }
        // Arrays.sort(nums2);
        // hm.put(nums2[0], hm.getOrDefault(nums2[0], 0) + 1);
        // for (int i = 1; i < nums2.length; i++) {
        // if (nums2[i] != nums2[i - 1]) {
        // hm.put(nums2[i], hm.getOrDefault(nums2[i], 0) + 1);
        // }
        // }
        // Arrays.sort(nums3);
        // hm.put(nums3[0], hm.getOrDefault(nums3[0], 0) + 1);
        // for (int i = 1; i < nums3.length; i++) {
        // if (nums3[i] != nums3[i - 1]) {
        // hm.put(nums3[i], hm.getOrDefault(nums3[i], 0) + 1);
        // }
        // }
        // List<Integer> sol = new ArrayList<>();
        // for (int key : hm.keySet()) {
        // if (hm.get(key) >= 2) {
        // sol.add(key);
        // }
        // }
        // return sol;

        // method 2
        HashMap<Integer, Integer> hm = new HashMap<>();
        Set<Integer> set1 = new HashSet<>(Arrays.asList(nums1));
        for (int val : set1) {
            hm.put(val, 1);
        }
        Set<Integer> set2 = new HashSet<>(Arrays.asList(nums2));
        for (int val : set2) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        Set<Integer> set3 = new HashSet<>(Arrays.asList(nums3));
        for (int val : set3) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        List<Integer> sol = new ArrayList<>();
        for (int key : hm.keySet()) {
            if (hm.get(key) >= 2) {
                sol.add(key);
            }
        }
        return sol;
    }
}