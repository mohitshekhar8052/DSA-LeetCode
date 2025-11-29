class Solution {
    public int minOperations(int[] nums, int k) {
        int operation = 0;
        for(int i=0; i< nums.length;i++){
            operation = (operation + nums[i]%k) % k;
        }
        return operation;
    }
}