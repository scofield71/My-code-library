class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<ArrayList<Integer>>> graph = new HashMap<>();
        for (int i=0;i<times.length;i++) {
            if (graph.containsKey(times[i][0])) {
                graph.get(times[i][0]).add(new ArrayList(List.of(times[i][1],times[i][2])));
            } else {
                graph.put(times[i][0], new ArrayList<ArrayList<Integer>>());
                graph.get(times[i][0]).add(new ArrayList(List.of(times[i][1],times[i][2])));
            }
        }
        int[] time = new int[n+1];
        for(int i=1;i<=n;i++) time[i]=-1;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(k);
        time[k]=0;
        while (dq.size()>0) {
            Integer node = dq.poll();
            int timeTaken = time[node];
            if (graph.containsKey(node)) {
                for (ArrayList<Integer> nearby : graph.get(node)) {
                    Integer target = nearby.get(0);
                    Integer timeElapsed = nearby.get(1);
                    int timeRequired = timeTaken + timeElapsed;
                    if (time[target]==-1) {
                        time[target]=timeRequired;
                        dq.offer(target);
                    } else if (time[target]>timeRequired) {
                        time[target]=timeRequired;
                        dq.offer(target);
                    }
                }
            }
        }
        int maxTime = 0;
        for (int i=1;i<=n;i++) {
            if (time[i]==-1) return -1;
            maxTime = Math.max(maxTime,time[i]);
        }
        return maxTime;
    }
}