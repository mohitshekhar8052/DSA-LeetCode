class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // prefix sum: ps[i][j] = sum of submatrix (0,0) to (i-1,j-1)
        long[][] ps = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int lo = 0, hi = Math.min(m, n);

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (existsSquare(ps, m, n, mid, threshold)) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }

    private boolean existsSquare(long[][] ps, int m, int n, int len, int threshold) {
        if (len == 0) return true;

        for (int i = len; i <= m; i++) {
            for (int j = len; j <= n; j++) {
                long sum = ps[i][j] - ps[i - len][j] - ps[i][j - len] + ps[i - len][j - len];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
