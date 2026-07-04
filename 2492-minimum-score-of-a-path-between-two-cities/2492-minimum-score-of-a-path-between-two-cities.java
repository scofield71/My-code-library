class Solution {
    public int minScore(int n, int[][] roads) {
        int[] visited = new int[n+1];
        for(int i=1;i<=n;i++) visited[i]=Integer.MAX_VALUE;
        HashMap<Integer,ArrayList<Pair<Integer,Integer>>> ourmap = new HashMap<>();
        for (int i=0;i<roads.length;i++) {
            ourmap.putIfAbsent(roads[i][0],new ArrayList<Pair<Integer,Integer>>());
            ourmap.putIfAbsent(roads[i][1],new ArrayList<Pair<Integer,Integer>>());
            ourmap.get(roads[i][0]).add(new Pair<Integer,Integer>(roads[i][1],roads[i][2]));
            ourmap.get(roads[i][1]).add(new Pair<Integer,Integer>(roads[i][0],roads[i][2]));
        } 
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(),b.getValue()));
        pq.offer(new Pair<Integer,Integer>(1,Integer.MAX_VALUE));
        while(!pq.isEmpty()) {
            int node = pq.peek().getKey();
            int cost = pq.peek().getValue();
            pq.poll();
            if (ourmap.containsKey(node)) {
                // System.out.println("Hi");
                for (Pair<Integer,Integer> p : ourmap.get(node)) {
                    int tnode = p.getKey();
                    int tcost = p.getValue();
                    int reachingCost = Math.min(cost,tcost);
                    if (visited[tnode]>reachingCost) {
                        visited[tnode] = reachingCost;
                        pq.offer(new Pair<Integer,Integer>(tnode,reachingCost));
                    }
                }
            }
        }
        return visited[n];
    }
}