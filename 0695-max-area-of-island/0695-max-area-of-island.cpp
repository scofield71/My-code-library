class Solution {
public:
    int helper(vector<vector<int>>& grid,vector<vector<int>>& visited, int i, int j ) {
        if(i<0 || i>=grid.size() || j<0 || j>=grid[0].size()) return 0;
        if(visited[i][j]==1 || grid[i][j]==0) return 0 ;
        visited[i][j]=1;
        int a = helper(grid,visited,i-1,j);
        int b = helper(grid,visited,i+1,j);
        int c = helper(grid,visited,i,j-1);
        int d = helper(grid,visited,i,j+1);
        return 1 + a + b + c + d;
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        vector<vector<int>> visited(grid.size(),vector<int>(grid[0].size(),0));
        int ans = 0;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==1 && visited[i][j]==0) {
                    int tmpAns = helper(grid,visited,i,j);
                    ans = max(ans,tmpAns);
                }
            }
        }
        return ans;
    }
};