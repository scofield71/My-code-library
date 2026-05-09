class Solution {
public:
    int maxArea(vector<int>& height) {
        int i=0,j=height.size()-1;
        int ans = 0;
        while(i<j) {
            int a = height[i], b = height[j];
            int actual = min(a,b);
            ans = max(ans,actual*(j-i));
            if(a>b) j--;
            else if(b>a) i++;
            else {
                if(height[i+1]>=height[j-1]) i++;
                else j--;
            }
        }
        return ans;
    }
};