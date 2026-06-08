class Solution {
public:
    int minSpeedOnTime(vector<int>& dist, double hour) {
        int start = 1, end = 1e8;
        int ans = 1e8;
        while(start<=end) {
            double mid = start + (end-start)/2;
            double h = 0;
            for(int i=0;i<dist.size();i++) {
                if(i<dist.size()-1) h+=ceil((double)((double)dist[i]/mid));
                else h+=(double)((double)dist[i]/mid);
            }
            if(h>hour) start=mid+1;
            else {
                ans = min(ans,(int)mid);
                end=mid-1;
            }
        }
        double h = 0;
        for(int i=0;i<dist.size();i++) {
            if(i<dist.size()-1) h+=ceil((double)((double)dist[i]/start));
            else h+=(double)((double)dist[i]/start);
        }
        // cout<<h<<endl;
        if(h>hour) return -1;
        return start;
    }
};