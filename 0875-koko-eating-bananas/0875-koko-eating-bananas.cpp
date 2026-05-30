class Solution {
public:
    bool canFinishEating(vector<int>& piles, long long h, long long curh) {
        long long totalHours = 0;
        for(int i=0;i<piles.size();i++) {
            totalHours+=(long long)ceil((piles[i]*1.0)/curh);
        }
        return totalHours<=h;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        sort(piles.begin(),piles.end());
        if(piles.size()==h) return piles[piles.size()-1];
        int low = 1, high = piles[piles.size()-1];
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(canFinishEating(piles,h,mid)) {
                high = mid-1;
            } else low = mid+1;
        }
        return low;
    }
};