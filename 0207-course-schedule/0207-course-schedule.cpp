class Solution {
public:
    bool isCyclic(vector<vector<int>>& outDegree, vector<int>& cycleVisited, vector<int>& visited, int node) {
        if(cycleVisited[node]==1) return true;
        if(visited[node]==1) return false;
        visited[node]=1;
        cycleVisited[node]=1;
        for(int i=0;i<outDegree[node].size();i++) {
            bool tmpCycle = isCyclic(outDegree,cycleVisited,visited,outDegree[node][i]);
            if(tmpCycle) return true;
        }
        cycleVisited[node]=0;
        return false;
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> outDegree(numCourses+1,vector<int>());
        for(auto it:prerequisites) outDegree[it[1]].push_back(it[0]);
        vector<int> visited(numCourses+1,0);
        for(int i=1;i<=numCourses;i++) {
            if(visited[i]==0) {
                vector<int> cycleVisited(numCourses+1,0);
                bool cyclePresent = isCyclic(outDegree,cycleVisited, visited, i);
                if(cyclePresent) return false;
            }
        }
        return true;
    }
};