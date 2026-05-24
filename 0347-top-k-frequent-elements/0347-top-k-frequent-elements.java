class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> ourmap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            ourmap.putIfAbsent(nums[i],0);
            int val = ourmap.get(nums[i]);
            val++;
            ourmap.put(nums[i],val);
        }
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.get(0),b.get(0)));
        for(Integer key : ourmap.keySet()) {
            int val = ourmap.get(key);
            if(pq.size()<k) {
                pq.offer(List.of(val,key));
            } else {
                if(pq.peek().get(0)<val) {
                    pq.poll();
                    pq.offer(List.of(val,key));
                }
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i] = pq.peek().get(1);
            pq.poll();
            i++;
        }
        return ans;
    }
}