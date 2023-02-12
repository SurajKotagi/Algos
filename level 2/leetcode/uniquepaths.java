class Solution {
    public int uniquePaths(int m, int n) {
        count = 0;
        solution(0, 0, m - 1, n - 1);
        return count;
    }

    static int count = 0;

    // r - row
    // c - column
    // dr - destination row
    // dc - destination column
    public static void solution(int r, int c, int dr, int dc) {
        // Handelling wrong calls
        if (r > dr || c > dc) {
            return;
        }
        // Base case
        if (r == dr && c == dc) {
            count++;
            return;
        }

        // there are to options for a robot to move

        // call for Right Move
        solution(r, c + 1, dr, dc);

        // call for Down Move
        solution(r + 1, c, dr, dc);

    }
}
