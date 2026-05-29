class Solution {
public:
    bool checkBipartite(int node, vector<vector<int>>& graph, set<int>& grapha, set<int>& graphb, vector<int>& visited) {
        visited[node]=1;
        int side = 0;
        queue<int> q;
        q.push(node);
        grapha.insert(node);
        side++;
        while(q.size()>0) {
            int size = q.size();
            while(size>0) {
                int fnode = q.front();
                q.pop();
                for(auto& it:graph[fnode]) {
                    if(it==fnode) continue;
                    if(side%2==0) {
                        if(graphb.find(it)!=graphb.end()) return false;
                        if(visited[it]==1) continue;
                        else{
                            visited[it]=1;
                            grapha.insert(it);
                            q.push(it);
                        }
                    } else {
                        if(grapha.find(it)!=grapha.end()) return false;
                        if(visited[it]==1) continue;
                        else {
                            visited[it]=1;
                            graphb.insert(it);
                            q.push(it);
                        }
                    }
                }
                size--;
            }
            side++;
        }
        return true;
    }
    bool isBipartite(vector<vector<int>>& graph) {
        set<int> grapha;
        set<int> graphb;
        vector<int> visited(graph.size(),0);
        for(int i=0;i<graph.size();i++) {
            if(visited[i]==1) continue;
            if(!checkBipartite(i,graph,grapha,graphb,visited)) return false;
        }
        return true;
    }
};