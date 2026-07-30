class Solution {
    public int minimumPushes(String word) {
        int[] f = new int[26];
        for(int i=0;i<word.length();i++) {
            int val = Integer.valueOf(word.charAt(i)-'a');
            f[val]++;
        }
        Arrays.sort(f);
        int i = 0, j = 25;
        while(i<=j) {
            int tmp = f[i];
            f[i]=f[j];
            f[j]=tmp;
            i++;
            j--;
        }
        int ans = 0;
        for (i=0;i<26;i++) {
            if (f[i]==0) break;
            if (i<8) {
                ans+=f[i];
            } else if (i>=8 && i<=15) {
                ans+=2*f[i];
            } else if (i>=16 && i<=23) {
                ans+=3*f[i];
            } else {
                ans+=4*f[i];
            }
        }
        return ans;
    }
}