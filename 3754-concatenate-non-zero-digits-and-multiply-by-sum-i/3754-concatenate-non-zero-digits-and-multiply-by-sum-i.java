class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int x = 0;
        String num = String.valueOf(n);
        for (int i=0;i<num.length();i++) {
            if (num.charAt(i)!='0') {
                sum+=(num.charAt(i)-'0');
                x = x*10 + num.charAt(i)-'0';
            }
        }
        long ans = (long)x*(long)sum;
        return ans;
    }
}