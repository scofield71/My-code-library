class Solution {
    public static final int MOD = 1000000007;

    public int maxScore(List<String> board, int i, int j,int[][] mem,boolean[][] visited) {
        if (i<0 || i>=board.size() || j<0 || j>=board.get(0).length()) return -1;
        if (i==0 && j==0) return 0;
        if (visited[i][j]==true) return -1;
        if (board.get(i).charAt(j)=='X') return -1;
        if (mem[i][j]!=-10) return mem[i][j];
        visited[i][j]=true;
        int a = maxScore(board,i-1,j,mem,visited);
        int b = -1;
        int c = maxScore(board,i,j-1,mem,visited);
        int d = maxScore(board,i-1,j-1,mem,visited);
        int val = Math.max(Math.max(a,b),Math.max(c,d));
        visited[i][j]=false;
        if (val==-1) return mem[i][j]=-1;
        if(board.get(i).charAt(j)=='S') return mem[i][j]=val;
        return mem[i][j] = board.get(i).charAt(j)-'0' + val;
    }

    public int countPaths(List<String> board, int i, int j,boolean[][] visited, int sum,int[][][] paths) {
        if (i<0 || i>=board.size() || j<0 || j>=board.get(0).length()) return 0;
        if (board.get(i).charAt(j)=='X') return 0;
        if (sum<0) return 0;
        if (i==0 && j==0) {
            if (sum==0) return 1;
            return 0;
        }
        if (paths[i][j][sum]!=-1) return paths[i][j][sum];
        if (visited[i][j]==true) return 0;
        visited[i][j]=true;
        int val = 0;
        if (board.get(i).charAt(j)!='S') val = board.get(i).charAt(j)-'0';
        int a = countPaths(board,i-1,j,visited,sum-val,paths);
        int b = 0;
        int c = countPaths(board,i,j-1,visited,sum-val,paths);
        int d = countPaths(board,i-1,j-1,visited,sum-val,paths);
        visited[i][j]=false;
        return paths[i][j][sum]=(a+b+c+d)%MOD;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int[][] mem = new int[board.size()][board.get(0).length()];
        for(int i=0;i<board.size();i++) {
            for(int j=0;j<board.get(0).length();j++) mem[i][j]=-10;
        }
        boolean[][] visited = new boolean[board.size()][board.get(0).length()];
        int score = maxScore(board,board.size()-1,board.get(0).length()-1,mem,visited);
        int[] ans = new int[2];
        ans[0]= (score==-1) ? 0 : score;
        for(int i=0;i<board.size();i++) {
            for(int j=0;j<board.get(0).length();j++) visited[i][j]=false;
        }
        int[][][] paths = new int[board.size()][board.get(0).length()][ans[0]+1];
        for(int i=0;i<board.size();i++) {
            for(int j=0;j<board.get(0).length();j++) {
                for (int k=0;k<ans[0]+1;k++) paths[i][j][k]=-1;
            }
        }
        ans[1] = countPaths(board,board.size()-1,board.get(0).length()-1,visited,ans[0],paths);
        return ans;
    }
}