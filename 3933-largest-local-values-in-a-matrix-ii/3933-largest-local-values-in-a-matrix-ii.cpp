class Solution {
public:
    int countLocalMaximums(vector<vector<int>>& matrix) {
        vector<vector<vector<int>>> buckets(201,vector<vector<int>>());
        for(int i=0;i<matrix.size();i++) {
            for(int j=0;j<matrix[0].size();j++) {
                buckets[matrix[i][j]].push_back({i,j});
            }
        }
        int ans = 0;
        for(int i=1;i<=200;i++) {
            for(auto& it:buckets[i]) {
                int ip=it[0],jp=it[1];
                bool possible = true;
                for(int j=i+1;j<=200;j++) {
                    for(auto& pt:buckets[j]) {
                        int p=pt[0],q=pt[1];
                        int ar = abs(p-ip);
                        int ac = abs(q-jp);
                        if(ar<=i && ac<=i) {
                            if(ar==i && ac==i) continue;
                            possible = false;
                            break;
                        }

                    }
                    if(!possible) break;
                }
                if(possible) ans++;
            }
        }
        return ans;
    }
};