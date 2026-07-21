class KthLargest {
    PriorityQueue<Integer> minHeap;
    int capacity;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        capacity = k;
        for (int i=0;i<nums.length;i++) {
            if (minHeap.size()<k) minHeap.offer(nums[i]);
            else {
                if (minHeap.peek()<nums[i]) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.size()<capacity) minHeap.offer(val);
        else {
            if (minHeap.peek()<val) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */