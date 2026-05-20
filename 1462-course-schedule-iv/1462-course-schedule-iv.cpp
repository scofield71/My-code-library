class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        vector<vector<int>> base(numCourses+1,vector<int>(numCourses+1,0));
        for(auto it:prerequisites) base[it[0]][it[1]]=1;
        // vector<vector<int>> possible(numCourses+1,vector<int>(numCourses+1,0));
        for(int k=0;k<numCourses;k++) {
            for(int i=0;i<numCourses;i++) {
                // if(i==j) continue;
                for(int j=0;j<numCourses;j++) {
                    // if(k==i || k==j) continue;
                    if(base[i][k]==1 && base[k][j]==1) {
                        base[i][j]=1;
                    }
                }
            }
        }
        vector<bool> ans(queries.size(),false);
        for(int i=0;i<queries.size();i++) ans[i]=(base[queries[i][0]][queries[i][1]]==1);
        return ans;
    }
};