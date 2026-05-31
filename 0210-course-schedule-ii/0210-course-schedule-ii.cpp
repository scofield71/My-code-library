class Solution {
public:
    bool isCyclePresent(unordered_map<int,vector<int>>& ourmap, vector<int>& visited, vector<int>& cycleVisited, int node, vector<int>& order) {
        if(cycleVisited[node]==1) return true;
        if(visited[node]==1) return false;
        visited[node]=1;
        cycleVisited[node]=1;
        for(auto it:ourmap[node]) {
            bool isCycle = isCyclePresent(ourmap,visited,cycleVisited,it,order);
            if(isCycle) return true;
        }
        order.push_back(node);
        cycleVisited[node]=0;
        return false;
    }
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites, vector<int>& order) {
        unordered_map<int,vector<int>> ourmap;
        for(auto it:prerequisites) {
            ourmap[it[1]].push_back(it[0]);
        }
        vector<int> visited(numCourses,0);
        for(int i=0;i<numCourses;i++) {
            if(visited[i]==0) {
                vector<int> cycleVisited(numCourses,0);
                bool isCycle = isCyclePresent(ourmap,visited,cycleVisited,i,order);
                if(isCycle) return false;
            }
        }
        return true;
    }
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> order;
        if(!canFinish(numCourses,prerequisites,order)) {
            vector<int> ans;
            return ans;
        }
        reverse(order.begin(),order.end());
        return order;
    }
};