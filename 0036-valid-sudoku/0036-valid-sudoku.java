class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> map = new HashSet<>();
        for(int i =0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!map.add(board[i][j]+"in row" + i)){
                    return false;
                }
                if(!map.add(board[i][j]+"in col" +j)){
                    return false;
                }
                if(!map.add(board[i][j] +"in sb"+ i/3 + j/3)){
                    return false;
                }
            }
        }
        return true;
    }
}