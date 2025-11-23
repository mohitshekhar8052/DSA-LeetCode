class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int val : nums) {
            int[] next = dp.clone();
            for (int r = 0; r < 3; r++) {
                if (dp[r] != Integer.MIN_VALUE) {
                    int newSum = dp[r] + val;
                    int newRem = (r + val % 3) % 3;
                    next[newRem] = Math.max(next[newRem], newSum);
                }
            }
            dp = next;
        }
        return Math.max(dp[0], 0);
    }
}
