class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int len = (1 << n) - 1;      // 2^n - 1
        int mid = (len / 2) + 1;     // middle position
        
        if (k == mid) return '1';
        
        if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            int mirror = len - k + 1;
            char ch = findKthBit(n - 1, mirror);
            return ch == '0' ? '1' : '0';   // invert
        }
    }
}