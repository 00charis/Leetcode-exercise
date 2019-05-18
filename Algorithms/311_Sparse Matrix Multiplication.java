//稀疏矩阵相乘
//代码自己写的
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int M = A.length;
        int N = A[0].length;
        int K = B[0].length;
        
        int[][] ret = new int[M][K];
        
        for(int m = 0; m < M; m++){
            for(int k = 0; k < K; k++){
                for(int n = 0; n < N; n++){
                    if(A[m][n] != 0){
                        ret[m][k] += A[m][n] * B[n][k];
                    }
                }
            }
        }
        return ret;
    }
}