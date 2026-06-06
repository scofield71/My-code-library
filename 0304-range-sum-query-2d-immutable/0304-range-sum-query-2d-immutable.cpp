class NumMatrix {
public:
    vector<vector<int>> range;
    NumMatrix(vector<vector<int>>& matrix) {
        vector<vector<int>> prefix;
        for(int i=0;i<matrix.size();i++) {
            vector<int> val(matrix[0].size(),0);
            vector<int> val2(matrix[0].size(),0);
            range.push_back(val);
            prefix.push_back(val2);
        }
        for(int i=0;i<matrix.size();i++) {
            prefix[i][0]=matrix[i][0];
            for(int j=1;j<matrix[i].size();j++) prefix[i][j]=prefix[i][j-1] + matrix[i][j];
        }
        for(int i=0;i<range.size();i++) {
            for(int j=0;j<range[0].size();j++) {
                if(i==0) range[i][j]=prefix[i][j];
                else {
                    range[i][j]=prefix[i][j]+range[i-1][j];
                }
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int totalAns = range[row2][col2];
        int toRemove = 0;
        if(row1!=0 && col1!=0) toRemove=range[row1-1][col1-1];
        int beforecol1 = 0;
        if(col1!=0) beforecol1=range[row2][col1-1];
        int beforerow1 = 0;
        if(row1!=0) beforerow1=range[row1-1][col2];
        return totalAns-beforecol1-beforerow1+toRemove;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */