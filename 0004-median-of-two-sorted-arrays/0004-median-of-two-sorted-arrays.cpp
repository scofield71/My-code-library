class Solution {
public:
    int findKthElement(vector<int>& nums1, vector<int>& nums2, int k) {
        if(nums1.size()>nums2.size()) return findKthElement(nums2,nums1,k);
        int m = nums1.size();
        int n = nums2.size();
        int low = max(0,k-n);
        int high = min(m,k);
        while(low<=high) {
            int cut1 = low + (high-low)/2;
            int cut2  = k - cut1;
            int l1 = (cut1==0) ? INT_MIN:nums1[cut1-1];
            int l2 = (cut2==0) ? INT_MIN:nums2[cut2-1];
            int r1 = (cut1!=m) ? nums1[cut1] : INT_MAX;
            int r2 = (cut2!=n) ? nums2[cut2] : INT_MAX;
            if(l1>r2) high=cut1-1;
            else if(l2>r1) low=cut1+1;
            else return max(l1,l2);
        }
        return -1;
    }
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if((m+n)%2==1) {
            return findKthElement(nums1,nums2,(m+n)/2 + 1);
        }
        double a = findKthElement(nums1,nums2,(m+n)/2);
        double b = findKthElement(nums1,nums2,((m+n)/2)+1);
        return (a+b)/2;
    }
};