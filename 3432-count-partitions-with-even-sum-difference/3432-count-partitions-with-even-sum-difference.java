class Solution {
    public int countPartitions(int[] nums) {
        int leftSum = 0;
        int rightSum = sum(nums);
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            leftSum += nums[i];
            rightSum -=nums[i];
            if((rightSum-leftSum) %2==0) count++;
        }
        return count;
    }

    public int sum(int[]nums){
        int sum =0;
        for(int num:nums){
            sum += num;
        }
        return sum;
    }
}