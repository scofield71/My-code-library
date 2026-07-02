class Solution {
    public boolean helper(List<List<Integer>> grid, int health, int i, int j,int[][] visited) {
        if (i<0 || i>=grid.size() || j<0 || j>=grid.get(0).size()) return false;
        if (health<1) return false;
        if (visited[i][j]==1) return false;
        int newHealth = health - grid.get(i).get(j);
        if (i==grid.size()-1 && j==grid.get(0).size()-1) {  
            return newHealth>=1;
        }
        visited[i][j]=1;
        boolean a = helper(grid,newHealth,i+1,j,visited);
        boolean b = helper(grid,newHealth,i,j+1,visited);
        boolean c = helper(grid,newHealth,i-1,j,visited);
        boolean d = helper(grid,newHealth,i,j-1,visited);
        visited[i][j]=0;
        return a|b|c|d;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>((a,b) -> a.get(0).compareTo(b.get(0)));
        pq.offer(List.of(grid.get(0).get(0),0,0));
        int rcost = 0;
        int[][] mincost = new int[grid.size()][grid.get(0).size()];
        for (int i=0;i<grid.size();i++) {
            for(int j=0;j<grid.get(0).size();j++) mincost[i][j]=1000000;
        }
        while(!pq.isEmpty()) {
            int cost = pq.peek().get(0);
            int i = pq.peek().get(1);
            int j = pq.peek().get(2);
            pq.poll();
            if(i==grid.size()-1 && j==grid.get(0).size()-1) {
                rcost = cost;
                break;
            }
            if(i>0) {
                int newCost = cost + grid.get(i-1).get(j);
                if (mincost[i-1][j]>newCost) {
                    pq.offer(List.of(newCost,i-1,j));
                    mincost[i-1][j]=newCost;
                }
            } 
            if (i<grid.size()-1) {
                int newCost = cost + grid.get(i+1).get(j);
                if (mincost[i+1][j]>newCost) {
                pq.offer(List.of(newCost,i+1,j));
                mincost[i+1][j]=newCost;
                }
            }
            if (j>0) {
                int newCost = cost + grid.get(i).get(j-1);
                if(mincost[i][j-1]>newCost) {
                pq.offer(List.of(newCost,i,j-1));
                mincost[i][j-1]=newCost;
                }
            }
            if (j<grid.get(0).size()-1) {
                int newCost = cost + grid.get(i).get(j+1);
                if(mincost[i][j+1]>newCost) {
                pq.offer(List.of(newCost,i,j+1));
                mincost[i][j+1]=newCost;
                }
            }
        }
        return rcost+1<=health;
    }
}