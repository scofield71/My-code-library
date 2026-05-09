class Solution {
public:
    vector<int> leftMax(vector<int>& height) {
        vector<int> ans(height.size(),-1);
        int maxVal = height[0];
        ans[0]=maxVal;
        for(int i=1;i<height.size();i++) {
            maxVal = max(maxVal,height[i]);
            ans[i]=maxVal;
        }
        return ans;
    }
    vector<int> rightMax(vector<int>& height) {
        vector<int> ans(height.size(),-1);
        int maxVal = height[height.size()-1];
        ans[height.size()-1]=maxVal;
        for(int i=height.size()-2;i>=0;i--) {
            maxVal = max(maxVal,height[i]);
            ans[i]=maxVal;
        }
        return ans;
    }
    int trap(vector<int>& height) {
        vector<int> prevMax = leftMax(height);
        vector<int> nextMax = rightMax(height);
        int ans = 0;
        for(int i=0;i<height.size();i++) {
            ans+=(min(nextMax[i],prevMax[i])-height[i]);
        }
        return ans;
    }
};