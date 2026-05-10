class Solution {
public:
    bool isPrime(int n) {
       
        if (n <= 1) return false;
        
        if (n <= 3) return true;
       
        if (n % 2 == 0 || n % 3 == 0) return false;
    
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
    long long minArraySum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        long long ans = 0;
        for(int i=nums.size()-1;i>=0;i--) {
            long long val = nums[i];
            if(isPrime(val) && nums[0]!=1) {
                ans+=val;
                continue;
            }
            for(int j=0;j<=i;j++) {
                if(nums[i]%nums[j]==0) {
                    val = nums[j];
                    break;
                }
            }
            ans+=val;
        }
        return ans;
    }
};