class Solution {
public:
    bool isPalindrome(string s) {
        string value="";
        for(auto it:s) {
            if(it>='a' && it<='z') value+=it;
            if(it>='A' && it<='Z') value+=std::tolower(it);
            if(it>='0' && it<='9') value+=it;
        }
        string rv = value;
        reverse(rv.begin(),rv.end());
        return rv==value;
    }
};