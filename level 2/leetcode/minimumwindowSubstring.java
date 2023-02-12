class Solution {
    public String minWindow(String s, String t) {
        // shortifying
        int slen = s.length();
        int tlen = t.length();

        // preparing t string frequency map
        Hashmap<Character, Integer> tfmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char x = t.charAt(i);
            tfmap.put(x, tfmap.getOrDefault(x, 0) + 1);
        }

        // iterating through s string
        int i = 0, j = 0;

        // map for s string character frequencies
        HashMap<Character, Integer> sfmap = new HashMap<>();

        int match_count = 0;
        String min_substring = "";
        int min_ss_len = Integer.MAX_VALUE;
        while (i < slen) {
            // putting ith element to sfmap
            char x = s.charAt(i);

            // checking whether its in t string
            if (tfmap.cotainsKey(x) == true) {
                sfmap.put(x, sfmap.getOrDefault(x, 0) + 1);

                // checking whether it was usefull put
                int xcount = sfmap.get(x);
                int pcount = tfmap.get(x);
                if (xcount <= pcount) {
                    match_count = match_count + 1;
                } else {

                }

                // checking whether all characters of t are in s
                if (match_count == tlen) {
                    // taking that substring out
                    String sub_string = s.substring(j, i + 1);
                    int sslen = sub_string.length();

                    // checking whether its minimum length substring
                    if (sslen < min_ss_len) {
                        min_substring = sub_string;
                        min_ss_len = sslen;
                    } else {

                    }

                    // moving j forward
                    while (j <= i) {
                        // removing/reducing jth element from sfmap

                        char c = s.charAt(j);
                        if (sfmap.contains(c) == true) {
                            int ccount = sfmap.get(c);

                            // if its 1 then remove else reduce
                            if (ccount == 1) {
                                sfmap.remove(c);
                            } else {
                                sfmap.put(c, sfmap.get(c) - 1);
                            }

                            // checking still the substring is valid one
                            if (sfmap.containsKey(c) == false) {
                                j++;
                                break;
                            } else {
                                // p - preffered
                                int new_c_count = sfmap.get(c);
                                int p_count = tfmap.get(c);
                                if (new_c_count >= p_count) {
                                    // taking that substring out
                                    String sub_string2 = s.substring(j, i + 1);
                                    int sslen2 = sub_string2.length();

                                    // checking whether its minimum length substring
                                    if (sslen2 < min_ss_len) {
                                        min_substring = sub_string2;
                                        min_ss_len = sslen2;
                                    } else {

                                    }
                                    j++;
                                } else {
                                    j++;
                                    break;
                                }
                            }
                        } else {
                            j++;
                            // taking that substring out
                            String sub_string3 = s.substring(j, i + 1);
                            int sslen3 = sub_string3.length();

                            // checking whether its minimum length substring
                            if (sslen3 < min_ss_len) {
                                min_substring = sub_string3;
                                min_ss_len = sslen3;
                            } else {

                            }
                        }
                    }
                } else {

                }
                i = i + 1;
            } else {
                i = i + 1;
            }
        }
    }
}