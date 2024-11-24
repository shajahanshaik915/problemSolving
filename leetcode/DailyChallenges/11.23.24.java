class Solution {
    public char[][] rotateTheBox(char[][] box) {
       char[][] ans=new char[box[0].length][box.length];
       int n=box.length,m=box[0].length;
       for(int i=n-1;i>=0;i--){
        int obstacle=m;
        for(int j=m-1;j>=0;j--){
            if(box[i][j]=='.'){
                continue;
            }
            else if(box[i][j]=='#'){
                obstacle--;
                ans[obstacle][n-1-i]='#';
            }
            else{
                obstacle=j;
                ans[j][n-1-i]='*';
            }
        }
       }
       for(int i=0;i<ans.length;i++){
        for(int j=0;j<ans[0].length;j++){
            if(ans[i][j]!='#'&&ans[i][j]!='*') ans[i][j]='.';
        }
       }
       return ans;
    }
}
