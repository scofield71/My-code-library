class Solution {
    private final long MOD = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        long[] sumarray = new long[s.length()];
        for(int i=0;i<s.length();i++) {
            if (i==0) {
                sumarray[i]=s.charAt(i)-'0';
            } else {
                sumarray[i] = sumarray[i-1] + s.charAt(i)-'0';
            }
        }
        long[] powerarray = new long[s.length()+1];
        powerarray[0]=1;
        for(int i=1;i<=s.length();i++) {
            powerarray[i]=powerarray[i-1]*10;
            powerarray[i]%=MOD;
        }
        long[] digits = new long[s.length()];
        for(int i=0;i<s.length();i++) {
            if(i>0) {
                digits[i]=digits[i-1];
            } 
            if (s.charAt(i)!='0') digits[i]++;
        }
        long[] valuearray = new long[s.length()];
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i)!='0') {
                if (i>0) {
                    valuearray[i] = valuearray[i-1]*10 + (s.charAt(i)-'0');
                    valuearray[i]%=MOD;
                } else {
                    valuearray[i]=(s.charAt(i)-'0');
                }
            } else {
                if (i==0) valuearray[i]=0;
                else valuearray[i]=valuearray[i-1];
            }
        }
        int[] ans = new int[queries.length];
        for (int i=0;i<queries.length;i++) {
            if (queries[i][0]==0) {
                long tmp = sumarray[queries[i][1]]*valuearray[queries[i][1]];
                tmp%=MOD;
                ans[i]=(int)tmp;
            } else {
                long powerdigits = digits[queries[i][1]]-digits[queries[i][0]-1];
                long bigVal = valuearray[queries[i][1]];
                long smallVal = (valuearray[queries[i][0]-1]*powerarray[(int)powerdigits])%MOD;
                long val = (bigVal-smallVal + MOD)%MOD;
                long sum = sumarray[queries[i][1]]-sumarray[queries[i][0]-1];
                long a = (val*sum)%MOD;
                ans[i]=(int)a;
            }
        }
        return ans;
    }
}