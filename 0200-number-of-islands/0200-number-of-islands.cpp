class Solution {
public:
    void helper(vector<vector<char>>& grid,vector<vector<int>>& visited, int i, int j ) {
        if(i<0 || i>=grid.size() || j<0 || j>=grid[0].size()) return;
        if(visited[i][j]==1 || grid[i][j]=='0') return;
        visited[i][j]=1;
        helper(grid,visited,i-1,j);
        helper(grid,visited,i+1,j);
        helper(grid,visited,i,j-1);
        helper(grid,visited,i,j+1);
    }
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<int>> visited(grid.size(),vector<int>(grid[0].size(),0));
        int ans = 0;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]=='1' && visited[i][j]==0) {
                    ans++;
                    helper(grid,visited,i,j);
                }
            }
        }
        return ans;
    }
};