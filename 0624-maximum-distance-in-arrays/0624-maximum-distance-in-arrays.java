class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        Collections.sort(arrays,(a,b) -> Integer.compare(a.get(0),b.get(0)));
        Integer mini = arrays.get(0).get(0);
        Integer maxi = Integer.MIN_VALUE;
        for(int i=1;i<arrays.size();i++) {
            maxi = Math.max(maxi,arrays.get(i).get(arrays.get(i).size()-1));
        }
        // return Math.abs(maxi-mini);
        return Math.max(Math.abs(maxi-mini),Math.abs(arrays.get(0).get(arrays.get(0).size()-1)-arrays.get(1).get(0)));
    }
}