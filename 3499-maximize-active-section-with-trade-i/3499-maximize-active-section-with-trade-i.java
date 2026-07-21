class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int markleft = -1, markright = -1, count = 0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i)=='1') {
                // System.out.println(i);
                boolean leftzero = false;
                boolean rightzero = false;
                int j=i-1;
                while(j>=0) {
                    if (s.charAt(j)=='1') break;
                    leftzero = true;
                    j--;
                }
                int k=i+1;
                while(k<s.length() && s.charAt(k)=='1') k++;
                int moveahead = k-1;
                int tmpCount = moveahead-i+1;
                while(k<s.length()) {
                    if (s.charAt(k)=='1') break;
                    rightzero = true;
                    k++;
                }
                i=moveahead;
                if (leftzero && rightzero) {
                    int tmp = k-j-1;
                    if (markleft==-1 && markright==-1) {
                        markleft=j+1;
                        markright=k-1;
                        count = tmp-tmpCount;
                    } else {
                        int toFill = tmp-tmpCount;
                        if (toFill>count) {
                            markleft=j+1;
                            markright=k-1;
                            count = toFill;
                        } 
                    }
                }
            }
        }
        int ans = 0;
        System.out.println(markleft + " " + markright + " " + count);
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)=='1') {
                if (markleft==-1 && markright==-1) ans++;
                else if (i<markleft || i>markright) ans++;
            }
        }
        if (markright!=-1) ans+=(markright-markleft+1);
        return ans;
    }
}