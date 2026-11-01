class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        solve(0, candidates, target, ds, ans);

        return ans;
    }

    public void solve(int index, int[] arr, int target,
                      List<Integer> ds, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (index == arr.length || target < 0) {
            return;
        }

        // Pick: same index (multiple picks allowed)
        ds.add(arr[index]);
        solve(index, arr, target - arr[index], ds, ans);

        // Backtrack
        ds.remove(ds.size() - 1);

        // Not Pick: move to next index
        solve(index + 1, arr, target, ds, ans);
    }
}