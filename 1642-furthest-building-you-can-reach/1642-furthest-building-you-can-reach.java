class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<heights.length;i++) {
            if(i+1<heights.length && heights[i]>=heights[i+1]) continue;
            if(i+1==heights.length) return i;
            int work = heights[i+1]-heights[i];
            if(pq.size()<ladders) {
                pq.offer(work);
            } else {
                if(!pq.isEmpty() && work>pq.peek()) {
                    int val = pq.poll();
                    pq.offer(work);
                    if(bricks<val) return i;
                    else bricks-=val;
                } else {
                    if(bricks>=work) {
                        bricks-=work;
                    } else return i;
                }
            }
        }
        return heights.length-1;
    }
}