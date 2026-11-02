class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        Arrays.sort(candidates);

        solve(0, candidates, target, ds, ans);

        return ans;
    }

    void solve(int index, int[] arr, int target,
               List<Integer> ds, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            // Pick
            ds.add(arr[i]);

            // Move to next index because each element can be used once
            solve(i + 1, arr, target - arr[i], ds, ans);

            // Backtrack
            ds.remove(ds.size() - 1);
        }
    }
}