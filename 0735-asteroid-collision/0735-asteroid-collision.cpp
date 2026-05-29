class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> stk;
        for(auto& it:asteroids) {
            if(it>=0) stk.push(it);
            else {
                while(stk.size()>0 && (stk.top()>0) && stk.top()<abs(it)) stk.pop();
                if(stk.size()>0 && stk.top()==abs(it)) {
                    stk.pop();
                } else if(stk.size()>0 && stk.top()<0) stk.push(it);
                else if(stk.size()==0) stk.push(it);
            }
        }
        vector<int> ans;
        while(stk.size()>0) {
            ans.push_back(stk.top());
            stk.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};