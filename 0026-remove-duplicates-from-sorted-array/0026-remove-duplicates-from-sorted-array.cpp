class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        int k=1;
        int i=0;
        while(k<nums.size()) {
            if (nums[k]!=nums[i]) {
                nums[i+1]=nums[k];
                i++;
            }
            k++;
        }
        return i+1;
    }
};