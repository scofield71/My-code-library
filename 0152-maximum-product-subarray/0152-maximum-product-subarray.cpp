class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int ans = INT_MIN;
        long long maxProd = 1;
        long long secondMaxProd = 0;
        for(auto it:nums) {
            maxProd*=(long long)it;
            secondMaxProd*=(long long)it;
            ans = max({(long long)ans,maxProd,secondMaxProd==0?INT_MIN:secondMaxProd});
            if(maxProd<0 && secondMaxProd==0) secondMaxProd=1;
            else if(maxProd==0) {
                maxProd=1;
                secondMaxProd=0;
            } 
        }
        return ans;
    }
};