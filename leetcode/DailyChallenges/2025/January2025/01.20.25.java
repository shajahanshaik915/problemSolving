class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> pos = new HashMap<>();
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        
        
        // Store positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos.put(mat[i][j], new int[]{i, j});
            }
        }
        
        // Check each number
        for (int i = 0; i < arr.length; i++) {
            int[] p = pos.get(arr[i]);
            rowCnt[p[0]]++;
            colCnt[p[1]]++;
            
            if (rowCnt[p[0]] == n || colCnt[p[1]] == m) {
                return i;
            }
        }
        return -1;
    }
}
