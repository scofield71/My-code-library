class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if(grid[0][0]==1 || grid[grid.size()-1][grid[0].size()-1]==1) return -1;
        queue<vector<int>> q;
        vector<vector<int>> visited(grid.size(),vector<int>(grid[0].size(),0));
        q.push({0,0});
        visited[0][0]=1;
        int ans = 0;
        int m = grid.size();
        int n = grid[0].size();
        while(q.size()>0) {
            int size = q.size();
            while(size>0) {
                int a = q.front()[0];
                int b = q.front()[1];
                if(a==m-1 && b==n-1) return ans+1;
                q.pop();
                for(int i=a-1;i<=a+1;i++) {
                    for(int j=b-1;j<=b+1;j++) {
                        if(i<0 || i>=m || j<0 || j>=n || (a==i && b==j)) continue;
                        if(visited[i][j]==0 && grid[i][j]==0) {
                            visited[i][j]=1;
                            q.push({i,j});
                        }
                    }
                }
                size--;
            }
            ans++;
        }
        return -1;
    }
};