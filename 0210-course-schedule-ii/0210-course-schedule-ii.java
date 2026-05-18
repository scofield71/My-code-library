class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int[] degree = new int[numCourses+1];
        for(int[] pair:prerequisites) {
            int a = pair[0];
            int b = pair[1];
            // adjList[a].add(b);
            adjList.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            degree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(degree[i]==0) q.add(i);
        }
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                int val = q.poll();
                if(adjList.containsKey(val)) {
                    for(Integer k : adjList.get(val)) {
                        degree[k]--;
                        if(degree[k]==0) {
                            q.add(k);
                        }
                    }
                }
                size--;
            }
        }
        for(int i=0;i<numCourses;i++) if(degree[i]>0) return false;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(!canFinish(numCourses,prerequisites)) return new int[0];
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int[] degree = new int[numCourses+1];
        for(int[] pair:prerequisites) {
            int a = pair[0];
            int b = pair[1];
            // adjList[a].add(b);
            adjList.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            degree[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            if(degree[i]==0) {
                q.add(i);
                arr.add(i);
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            while(size>0) {
                int val = q.poll();
                if(adjList.containsKey(val)) {
                    for(Integer k : adjList.get(val)) {
                        degree[k]--;
                        if(degree[k]==0) {
                            q.add(k);
                            arr.add(k);
                        }
                    }
                }
                size--;
            }
        }
        // Collections.sort(arr,Collections.reverseOrder());
        int[] ans = new int[arr.size()];
        for(int i=0;i<arr.size();i++) ans[i]=arr.get(arr.size()-i-1);
        return ans;
    }
}