class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int len=rectangles.length;
        int[][] vertical=new int[len][2],horizontal=new int[len][2];
        for(int i=0;i<rectangles.length;i++){
             int[] rect=rectangles[i];
            vertical[i][0]=rect[0];
            vertical[i][1]=rect[2];
            horizontal[i][0]=rect[1];
            horizontal[i][1]=rect[3];
        }
        Arrays.sort(horizontal,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        Arrays.sort(vertical,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        return helper(vertical)||helper(horizontal);
    }
    public boolean helper(int[][] a){
        int n=a.length,i=0,count=0;
        while(i<n){
            int end=a[i][1];
            i++;
            while(i<n&&end>a[i][0]){
                end=Math.max(a[i][1],end);
                i++;
            }
            count++;
        }
        return count>=3;
        
    }
}
