class Solution {
    private boolean isEatingPossible(int[] piles, int speed, int h) {
        long sum = 0;
        for (int i=0;i<piles.length;i++) {
            long hours = (int)Math.ceil(((double)(piles[i]*1.0))/(speed*1.0));
            sum+=hours;
        }
        return sum<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1, high = piles[piles.length-1];
        while(low<=high) {
            int mid = low + (high-low)/2;
            boolean canEat = isEatingPossible(piles,mid,h);
            if(!canEat) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}