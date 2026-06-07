class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<vector<int>> q;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid[0].size();j++) {
                if(grid[i][j]==2) q.push({i,j});
            }
        }
        // if(q.size()==0) return 0;
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        while(q.size()>0) {
            int size = q.size();
            while(size>0) {
                int a = q.front()[0];
                int b = q.front()[1];
                q.pop();
                if(a>0 && grid[a-1][b]==1) {
                    grid[a-1][b]=2;
                    q.push({a-1,b});
                }
                if(a<m-1 && grid[a+1][b]==1) {
                    grid[a+1][b]=2;
                    q.push({a+1,b});
                }
                if(b>0 && grid[a][b-1]==1) {
                    grid[a][b-1]=2;
                    q.push({a,b-1});
                }
                if(b<n-1 && grid[a][b+1]==1) {
                    grid[a][b+1]=2;
                    q.push({a,b+1});
                }
                size--;
            }
            ans++;
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) if(grid[i][j]==1) return -1;
        }
        return ans-1<0 ? 0 :ans-1;
    }
};