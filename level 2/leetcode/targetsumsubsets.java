class Solution {

    private void solution(int idx, int target, int[] arr, List<Integer> ans, List<List<Integer>> res) {
        // base case
        if (idx == arr.length) {
            if (target == 0)
                res.add(ans);
            return;
        }

        // if the target is greater than the current element we can use current element
        // to reduce target
        if (target >= arr[idx]) {
            ans.add(arr[idx]);
            solution(idx, target - arr[idx], arr, ans, res);
            ans.remove(ans.size() - 1);
        }
        solution(idx + 1, target, arr, ans, res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solution(0, target, candidates, new ArrayList<>(), res);
        return res;
    }
}