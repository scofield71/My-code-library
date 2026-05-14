class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int ans = 0;
        queue<pair<int,int>> q;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==2) q.push({i,j});
            }
        }
        while(q.size()>0) {
            int size = q.size();
            while(size>0) {
                int i = q.front().first;
                int j = q.front().second;
                q.pop();
                if(i-1>=0 && grid[i-1][j]==1) {
                    q.push({i-1,j});
                    grid[i-1][j]=2;
                }
                if(i+1<grid.size() && grid[i+1][j]==1) {
                    q.push({i+1,j});
                    grid[i+1][j]=2;
                }
                if(j-1>=0 && grid[i][j-1]==1) {
                    q.push({i,j-1});
                    grid[i][j-1]=2;
                }
                if(j+1<grid[0].size() && grid[i][j+1]==1) {
                    q.push({i,j+1});
                    grid[i][j+1]=2;
                }
                size--;
            }
            ans++;
        }
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==1) return -1;
            }
        }
        return ans==0 ? 0 : ans-1;
    }
};