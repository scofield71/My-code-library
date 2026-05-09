class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int,int> ourmap;
        int i=0,j=0;
        while(j<nums.size()) {
            int kmp = j-i;
            if(kmp<=k) {
                if(ourmap[nums[j]]>0) return true;
                ourmap[nums[j]]++;
            } else {
                ourmap[nums[i]]--;
                i++;
                if(ourmap[nums[j]]>0) return true;
                ourmap[nums[j]]++;
            }
            j++;
        }
        return false;
    }
};