class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // prefix sums for rows and cols
        int[][] rowPref = new int[m][n + 1];
        int[][] colPref = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPref[i][j + 1] = rowPref[i][j] + grid[i][j];
                colPref[i + 1][j] = colPref[i][j] + grid[i][j];
            }
        }

        // prefix sums for diagonals (main and anti)
        int[][] diag1 = new int[m + 1][n + 1];     // top-left to bottom-right
        int[][] diag2 = new int[m + 1][n + 1];     // top-right to bottom-left (use shifted indexing)

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        // Try largest size first
        int maxSize = Math.min(m, n);
        for (int k = maxSize; k >= 2; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {
                    if (isMagic(grid, r, c, k, rowPref, colPref, diag1, diag2)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagic(int[][] grid, int r, int c, int k,
                            int[][] rowPref, int[][] colPref,
                            int[][] diag1, int[][] diag2) {

        int target = rowSum(rowPref, r, c, c + k - 1);

        // check all rows
        for (int i = r; i < r + k; i++) {
            if (rowSum(rowPref, i, c, c + k - 1) != target) return false;
        }

        // check all cols
        for (int j = c; j < c + k; j++) {
            if (colSum(colPref, j, r, r + k - 1) != target) return false;
        }

        // main diagonal
        int d1 = diag1[r + k][c + k] - diag1[r][c];
        if (d1 != target) return false;

        // anti diagonal
        int d2 = diag2[r + k][c] - diag2[r][c + k];
        return d2 == target;
    }

    private int rowSum(int[][] rowPref, int row, int l, int r) {
        return rowPref[row][r + 1] - rowPref[row][l];
    }

    private int colSum(int[][] colPref, int col, int top, int bottom) {
        return colPref[bottom + 1][col] - colPref[top][col];
    }
}
