class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for(int bit=0;bit<32;bit++){
            int ones = 0;
            for(int num : nums){
                if((num>>bit&1)==1){
                    ones++;
                }
            }
            int zeros = n-ones;
            ans = ans+ ones*zeros;
        }
        return ans;
    }
}