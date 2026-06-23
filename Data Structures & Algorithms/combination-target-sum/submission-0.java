class Solution {
    List<Integer> sol = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return res;
    }

    private void backtrack(int[] nums, int idx, int sum, int target) {
        if (sum > target)
            return;

        if (sum == target) {
            res.add(new ArrayList<>(sol));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            sol.add(nums[i]);
            backtrack(nums, i, sum + nums[i], target);
            sol.remove(sol.size() - 1);
        }
    }
}
