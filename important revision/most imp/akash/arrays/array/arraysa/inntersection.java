class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hs1 = new HashSet<>();
        for (int i : nums1) {
            hs1.add(i);
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for (int i : nums2) {
            hs2.add(i);
        }

        int count = 0;
        for (int i : hs2) {
            if (hs1.contains(i) == true) {
                count++;
            }
        }
        int[] res = new int[count];

        int x = 0;
        for (int i : hs2) {
            if (hs1.contains(i) == true) {
                res[x] = i;
                x++;
            }
        }
        return res;
    }
}