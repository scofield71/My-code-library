class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(mid>0 && nums[mid-1]==nums[mid]) {
                if(mid%2==0) {
                    high=mid-1;
                } else {
                    low=mid+1;
                }
            } else if(mid<(nums.length-1) && nums[mid+1]==nums[mid]) {
                if(mid%2==0) {
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            } else return nums[mid];
        }
        return 1;
    }
}