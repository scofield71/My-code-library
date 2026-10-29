
class Solution {

    static class Pair{
        public int dest;
        public int cost;
        public Pair(int a, int b) {
            dest = a;
            cost = b;
        }
    }

    static class Status{
        public int location;
        public int stop;
        public int cost;
        public Status(int a,int b,int c) {
            location=a;
            stop=b;
            cost=c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,ArrayList<Pair>> stops = new HashMap<>();
        for (int i=0;i<flights.length;i++) {
            stops.putIfAbsent(flights[i][0],new ArrayList<Pair>());
            stops.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        PriorityQueue<Status> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        pq.offer(new Status(src,0,0));
        // int[] visited = new int[n+1];
        // for (int i=0;i<=n;i++) visited[i]=Integer.MAX_VALUE;
        // visited[src]=0;
        int[][] visited = new int[n+1][k+2];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=k+1;j++) {
                if (i!=src) visited[i][j]=Integer.MAX_VALUE;
                else visited[i][j]=0;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            Status s = pq.poll();
            if (s.location==dst) return s.cost;
            if (s.stop>k) continue;
            if (stops.containsKey(s.location)) {
                for(Pair p:stops.get(s.location)) {
                    int cost = s.cost + p.cost;
                    int dest = p.dest;
                    int stop = s.stop+1;
                    if (visited[dest][stop]>cost) {
                        visited[dest][stop] = cost;
                        pq.offer(new Status(dest,stop,cost));
                    }
                }
            }
        }
        return -1;
    }
}