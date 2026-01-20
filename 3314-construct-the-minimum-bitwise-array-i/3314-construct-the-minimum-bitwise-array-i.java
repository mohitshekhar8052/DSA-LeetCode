import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            
            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }
            int p = 0;
            while (((x >> p) & 1) == 1) {
                p++;
            }

            ans[i] = x - (1 << (p - 1));
        }

        return ans;
    }
}
