class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i =0;i<n;i++){
            int num = nums.get(i);
            if(num % 2 == 0){
                ans[i] = -1;
                continue;
            }
            int bit = 1;
            int curr = 0;
            while((num & bit) > 0){
                curr = (num & (~bit));
                bit = bit<<1;
            }
            ans[i] =curr;
        }
        return ans;

    }
}