class Solution {
    public int maximumGap(int[] nums) {

        Arrays.sort(nums);

        int maxGap = 0;

        for (int i = 1; i < nums.length; i++) {

            int diff = nums[i] - nums[i - 1];

            if (diff > maxGap) {
                maxGap = diff;
            }
        }

        return maxGap;
    }
}