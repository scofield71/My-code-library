class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long n1Sum = 0, n2Sum = 0;
        long empty1 = 0, empty2 = 0;
        for(int i=0;i<nums1.length;i++) {
            n1Sum+=(long)nums1[i];
            if(nums1[i]==0) empty1++;
        }
        for(int i=0;i<nums2.length;i++) {
            n2Sum+=(long)nums2[i];
            if(nums2[i]==0) empty2++;
        }
        if (empty1>0 && empty2>0) {
            long n1=n1Sum+empty1;
            long n2=n2Sum+empty2;
            return Math.max(n1,n2);
        }
        if (empty1==0 && empty2==0) return (n1Sum==n2Sum)?n1Sum:-1;
        if(empty1==0) {
            long n2=n2Sum+empty2;
            return n2<=n1Sum?n1Sum:-1;
        }
        long n1=n1Sum+empty1;
        return n1<=n2Sum?n2Sum:-1;
    }
}