class Solution {
    public String smallestPalindrome(String s) {
        int[] frequency = new int[26];
        for (int i=0;i<s.length();i++) frequency[s.charAt(i)-'a']++;
        char[] charArray = new char[s.length()];
        int i = 0, j = s.length()-1;
        for (int k=0;k<26;k++) {
            if (frequency[k]==0) continue;
            else {
                int x = (frequency[k]%2==0) ? frequency[k] : frequency[k]-1;
                int count=0;
                while(count<x) {
                    charArray[i]=(char)('a'+k);
                    charArray[j]=(char)('a'+k);
                    i++;
                    j--;
                    count+=2;
                }
                if (frequency[k]%2==1) {
                    int ndx = s.length()/2;
                    charArray[ndx]=(char)('a'+k);
                }
            } 
        }
        return String.valueOf(charArray);
    }
}