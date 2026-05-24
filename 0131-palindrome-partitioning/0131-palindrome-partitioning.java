class Solution {
    boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    void helper(String s, List<List<String>> ans, List<String> current, int ndx) {
        if(ndx==s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=ndx;i<s.length();i++) {
            String tmpStr = s.substring(ndx,i+1);
            if(isPalindrome(s,ndx,i)) {
                current.add(tmpStr);
                helper(s,ans,current,i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();
        helper(s,ans,current,0);
        return ans;
    }
}