class Solution {
public:
    bool helper(string& s,int i,int j, bool canRemove) {
        if(i==j || i>j) return true;
        if(s[i]==s[j]) return helper(s,i+1,j-1,canRemove);
        bool ansa=false,ansb=false,ansc=false;
        if(j-1>i && s[i]==s[j-1] && canRemove) ansa = helper(s,i,j-1,false);
        if(i+1<j && s[i+1]==s[j] && canRemove) ansb = helper(s,i+1,j,false);
        if(i+1==j && canRemove) ansc = helper(s,i+1,j,false);
        return ansa||ansb||ansc;
    }
    bool validPalindrome(string s) {
        return helper(s,0,s.length()-1,true);  
    }
};