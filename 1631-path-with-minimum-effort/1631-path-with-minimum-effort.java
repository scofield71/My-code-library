class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.get(0),b.get(0)));
        int[][] visited = new int[heights.length][heights[0].length];
        for (int i=0;i<heights.length;i++) {
            for (int j=0;j<heights[0].length;j++)
                visited[i][j]=0;
        }
        pq.offer(new ArrayList<>(List.of(0,0,0)));
        while(pq.size()>0) {
            int cost = pq.peek().get(0);
            int row = pq.peek().get(1);
            int col = pq.peek().get(2);
            pq.poll();
            if (visited[row][col]!=0) continue;
            visited[row][col]=1;
            if (row==(heights.length-1) && col==(heights[0].length-1)) return cost;
            if (row-1>=0) 
                pq.offer(new ArrayList<>(List.of(Math.max(cost,Math.abs(heights[row][col]-heights[row-1][col])),row-1,col)));
            if (row+1<heights.length)
                pq.offer(new ArrayList<>(List.of(Math.max(cost,Math.abs(heights[row][col]-heights[row+1][col])),row+1,col)));
            if (col-1>=0) 
                pq.offer(new ArrayList<>(List.of(Math.max(cost,Math.abs(heights[row][col]-heights[row][col-1])),row,col-1)));
            if (col+1<heights[0].length)
                pq.offer(new ArrayList<>(List.of(Math.max(cost,Math.abs(heights[row][col]-heights[row][col+1])),row,col+1)));
        }
        return -1;
    }
}