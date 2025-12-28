class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        int r = n-1;
        int c =0;
        int cnt = 0;
        while(r>=0 && c<m){
            if(grid[r][c] < 0){
                --r;
                cnt += m-c;
            }else{
                ++c;
            }
        }
        return cnt;
    }
}