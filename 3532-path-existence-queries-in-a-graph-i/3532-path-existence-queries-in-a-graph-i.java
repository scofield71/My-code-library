class UnionFind {
    public int[] parent;
    public int[] rank;
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i=0;i<n;i++) {
            parent[i]=i;
            rank[i]=1;
        }
    }

    public int findParent(int node) {
        if (parent[node]==node) return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unify(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if (pa==pb) return;
        if (rank[pa]>rank[pb]) {
            parent[pb] = pa;
            rank[pa]+=rank[pb];
        } else {
            parent[pa] = pb;
            rank[pb]+=rank[pa];
        }
    }
}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        for (int i=1;i<nums.length;i++) {
            if (nums[i]-nums[i-1]<=maxDiff) uf.unify(i,i-1);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i=0;i<queries.length;i++) {
            int pa = uf.findParent(queries[i][0]);
            int pb = uf.findParent(queries[i][1]);
            ans[i]=(pa==pb);
        }
        return ans;
    }
}