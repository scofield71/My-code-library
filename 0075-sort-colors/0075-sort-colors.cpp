class Solution {
public:
    void sortColors(vector<int>& nums) {
        int i=0,j=nums.size()-1,k=0;
        while(k<=j) {
            if(nums[i]==0) {
                i++;
                if(k<i) k++;
                continue;
            }
            if(nums[j]==2) {
                j--;
                continue;
            }
            if(nums[k]==0) {
                swap(nums[i],nums[k]);
                i++;
                k++;
            } else if(nums[k]==2) {
                swap(nums[k],nums[j]);
                j--;
            } else {
                k++;
            }
        }
    }
};