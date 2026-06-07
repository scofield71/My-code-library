class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        queue<vector<int>> q;
        int waterCells = 0, landCells = 0;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==0) waterCells++;
                else {
                    landCells++;
                    q.push({i,j});
                }
            }
        }
        if (waterCells==0 || landCells==0) return -1;
        int ans = 0;
        int m = grid.size(), n = grid[0].size();
        while(q.size()>0) {
            int size = q.size();
            while(size>0) {
                int a = q.front()[0], b = q.front()[1];
                q.pop();
                if(a>0 && grid[a-1][b]==0) {
                    grid[a-1][b]=1;
                    q.push({a-1,b});
                }
                if(a<m-1 && grid[a+1][b]==0) {
                    grid[a+1][b]=1;
                    q.push({a+1,b});
                }
                if(b>0 && grid[a][b-1]==0) {
                    grid[a][b-1]=1;
                    q.push({a,b-1});
                }
                if(b<n-1 && grid[a][b+1]==0) {
                    grid[a][b+1]=1;
                    q.push({a,b+1});
                }
                size--;
            }
            ans++;
        }
        return ans-1;
    }
};