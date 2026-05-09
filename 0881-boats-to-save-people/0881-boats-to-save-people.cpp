class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        int i=0,j=people.size()-1;
        sort(people.begin(),people.end());
        int ans = 0;
        while(i<j) {
            int sum = people[i]+people[j];
            if(sum<=limit) {
                i++;
                j--;
            } else j--;
            ans++;
        }
        if(i==j) ans++;
        return ans;
    }
};