class Solution {
    public void helper(char[][] board, int i, int j,int[][] visited) {
        if(visited[i][j]==1) return;
        visited[i][j]=1;
        if(i-1>=0 && board[i-1][j]=='O') helper(board,i-1,j,visited);
        if((i+1)<board.length && board[i+1][j]=='O') helper(board,i+1,j,visited);
        if((j-1)>=0 && board[i][j-1]=='O') helper(board,i,j-1,visited);
        if((j+1)<board[0].length && board[i][j+1]=='O') helper(board,i,j+1,visited);
    }
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            Arrays.fill(visited[i],0);
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(i==0 || i==(board.length-1) || j==0 || j==(board[0].length-1)) {
                    if(board[i][j]=='O' && visited[i][j]==0) helper(board,i,j,visited);
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='O' && visited[i][j]==0) board[i][j]='X';
            }
        }
    }
}