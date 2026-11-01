class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int minV = Integer.MAX_VALUE;
        int cnt = 0;
        long ans = 0;
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j]<0) cnt++;
                ans+=(long)Math.abs(matrix[i][j]);
                minV = Math.min(minV,Math.abs(matrix[i][j]));
            }
        }
        if (cnt%2==1) ans-=(long)2*minV;
        return ans;
    }
}