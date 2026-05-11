class Solution {
public:
    bool isInorder(string a,string b,vector<int>& weight) {
        int len = min(a.length(),b.length());
        int i = 0;
        while(i<len) {
            int w1 = weight[a[i]-'a'];
            int w2 = weight[b[i]-'a'];
            if(w1<w2) return true;
            else if(w1>w2) return false;
            i++;
        }
        if(a.length()>b.length()) return false;
        return true;
    }
    bool isAlienSorted(vector<string>& words, string order) {
        vector<int> weight(26,0);
        for(int i=0;i<order.length();i++) {
            weight[order[i]-'a']=i;
        }
        for(int i=0;i<words.size();i++) {
            for(int j=i+1;j<words.size();j++) {
                if(!isInorder(words[i],words[j],weight)) return false;
            }
        }
        return true;
    }
};