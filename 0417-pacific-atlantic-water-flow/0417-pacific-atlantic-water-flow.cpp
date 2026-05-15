class Solution {
public:
    void dfs(vector<vector<int>>& ocean, vector<vector<int>>& heights, int i, int j) {
        // if(i<0 || i>=heights.size() || j<0 || j>=heights[0].size()) return;
        if(ocean[i][j]!=-1) return;
        ocean[i][j]=1;
        if (i-1>=0 && heights[i][j]<=heights[i-1][j]) dfs(ocean,heights,i-1,j);
        if (i+1<heights.size() && heights[i][j]<=heights[i+1][j]) dfs(ocean,heights,i+1,j);
        if (j-1>=0 && heights[i][j]<=heights[i][j-1]) dfs(ocean,heights,i,j-1);
        if (j+1<heights[0].size() && heights[i][j]<=heights[i][j+1]) dfs(ocean,heights,i,j+1);
    }
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        vector<vector<int>> pacific(heights.size(),vector<int>(heights[0].size(),-1));
        vector<vector<int>> atlantic(heights.size(),vector<int>(heights[0].size(),-1));
        for(int i=0;i<heights.size();i++) {
            for(int j=0;j<heights[0].size();j++) {
                if(i==0) {
                    dfs(pacific, heights,i, j);
                }
                if(i==heights.size()-1) {
                    dfs(atlantic,heights,i,j);
                }
                if(j==0) {
                    dfs(pacific,heights,i,j);
                }
                if(j==heights[0].size()-1) {
                    dfs(atlantic,heights,i,j);
                }
            }
        }
        vector<vector<int>> ans;
        for(int i=0;i<heights.size();i++) {
            for(int j=0;j<heights[0].size();j++) {
                if(pacific[i][j]==1 && atlantic[i][j]==1) {
                    ans.push_back({i,j});
                }
            }
        }
        return ans;
    }
};