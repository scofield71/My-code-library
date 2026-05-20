class DSU{
    public:
    vector<int> parent;
    vector<int> capacity;
    DSU(int size) {
        for(int i=0;i<=size;i++) {
            parent.push_back(i);
            capacity.push_back(0);
        }
    }

    int findParent(int val) {
        if (parent[val]==val) return val;
        return parent[val]=findParent(parent[val]);
    }

    void unifyNodes(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px==py) return;
        if(capacity[px]>capacity[py]) {
            parent[px]=py;
            capacity[px]+=capacity[py];
        } else {
            parent[py]=px;
            capacity[py]+=capacity[px];
        }
    }
};
class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        DSU dsu(edges.size());
        for(auto it:edges) {
            int a = dsu.findParent(it[0]);
            int b = dsu.findParent(it[1]);
            if(a==b) return {it[0],it[1]};
            dsu.unifyNodes(it[0],it[1]);
        }
        return {-1,-1};
    }
};