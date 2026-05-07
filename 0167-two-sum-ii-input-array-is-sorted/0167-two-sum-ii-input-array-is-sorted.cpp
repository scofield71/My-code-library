class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int i=0,j=numbers.size()-1;
        while(i<j) {
            int t = numbers[i]+numbers[j];
            if(t>target) j--;
            else if(t<target) i++;
            else {
                return {i+1,j+1};
            }
        }
        return {-1,-1};
    }
};