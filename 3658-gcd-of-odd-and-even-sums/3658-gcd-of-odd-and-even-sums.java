class Solution {
    public int findGCD(int x,int y) {
        if (x<y) return findGCD(y,x);
        if (y==1) return y;
        if (x%y==0) return y;
        return findGCD(y,x%y);
    }
    public int gcdOfOddEvenSums(int n) {
        int evenSum = n*(n+1);
        int oddSum = (int)Math.pow(n,2);
        return findGCD(evenSum,oddSum);
    }
}