class Solution {
    int n;
    Integer DP[][];
    public int maxSumDivThree(int[] nums) {
        this.n = nums.length;
        this.DP = new Integer[n][3];
        int ans = solve(nums,0,0);
        return (ans<0)?0:ans;
    }

    public int solve(int nums[],int idx, int mod){
        if(idx == nums.length){
            return(mod == 0)?0:Integer.MIN_VALUE;
        }
        if(DP[idx][mod] != null){
            return DP[idx][mod];
        }
        int exclude = solve(nums, idx + 1, mod);

        int child = solve(nums, idx + 1, (mod + (nums[idx] % 3)) % 3);
        int include = (child == Integer.MIN_VALUE) ? Integer.MIN_VALUE : nums[idx] + child;

        int res = Math.max(include, exclude);
        DP[idx][mod] = res;
        return res;
    }
}