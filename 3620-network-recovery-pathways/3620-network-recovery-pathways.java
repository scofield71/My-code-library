record Pair<K, V>(K first, V second) {}
class Solution {
    public boolean isPossible(int[][] edges, boolean[] online, long k, int minAns) {
        HashMap<Integer,ArrayList<Pair<Integer,Integer>>> map = new HashMap<>();
        for (int i=0;i<edges.length;i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int cost = edges[i][2];
            if (!online[source] || !online[dest]) continue;
            map.putIfAbsent(source,new ArrayList<Pair<Integer,Integer>>());
            map.get(source).add(new Pair<>(dest,cost));
        }
        for (int i=0;i<edges.length;i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int cost = edges[i][2];
            if (!online[source] || !online[dest]) continue;
            map.putIfAbsent(source,new ArrayList<Pair<Integer,Integer>>());
            map.get(source).add(new Pair<>(dest,cost));
        }
        long[] costs = new long[online.length];
        PriorityQueue<Pair<Long,Long>> pq = new PriorityQueue<>((a,b) -> Long.compare(a.second(),b.second()));
        for(int i=1;i<online.length;i++) costs[i]=Long.MAX_VALUE;
        pq.offer(new Pair<>(0l,0l));
        costs[0]=0;
        while(!pq.isEmpty()) {
            long node = pq.peek().first();
            long cost = pq.peek().second();
            pq.poll();
            if (cost > costs[(int)node]) continue;
            // System.out.println(node + " " + cost);
            if (map.containsKey((int)node)) {
                for(Pair<Integer,Integer> radar : map.get((int)node)) {
                    int tnode = radar.first();
                    long tnodeCost = cost + (long)radar.second();
                    // System.out.println(radar.second());
                    if ((costs[tnode]>tnodeCost) && tnodeCost<=k && radar.second()>=minAns) {
                        costs[tnode] = tnodeCost;
                        pq.offer(new Pair<>((long)tnode,tnodeCost));
                    }
                }
            }
        }
        // System.out.println(costs[online.length-1] + " " + minAns);
        return costs[online.length-1]!=-1 && costs[online.length-1]<=k;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int low = 0, high = Integer.MAX_VALUE-1;
        int ans = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(isPossible(edges,online,k,mid)) {
                low=mid+1;
                ans = Math.max(ans,mid);
            }
            else high=mid-1;
            // System.out.println(low + " " + high);
        }
        return ans==Integer.MAX_VALUE-1 ? -1 : ans;
    }
}