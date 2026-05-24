class Solution {
    public double helper(int[] nums1, int[] nums2, int k) {
        int ack = k;
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) return helper(nums2,nums1,k);
        int low=Math.max(0,ack-n);
        int high=Math.min(ack,m);
        while(low<=high) {
            int cut1 = (low+high)/2;
            int cut2 = k-cut1;
            int l1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = cut1==m ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2==n ? Integer.MAX_VALUE : nums2[cut2];
            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
            else if(l1>r2) high=cut1-1;
            else low=cut1+1;
        }
        return 1;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if((m+n)%2==0) {
            double a = helper(nums1,nums2,(m+n)/2);
            double b = helper(nums1,nums2,((m+n)/2)+1);
            return (a+b)/2.0;
        }
        return helper(nums1,nums2,(m+n)/2 + 1);
    }
}