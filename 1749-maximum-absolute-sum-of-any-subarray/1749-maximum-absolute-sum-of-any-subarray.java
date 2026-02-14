class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = Math.abs(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            minEnding = Math.min(nums[i], minEnding + nums[i]);

            ans = Math.max(ans,
                    Math.max(Math.abs(maxEnding), Math.abs(minEnding)));
        }

        return ans;
    }
}
