class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int max=height[0];
        int[] highestInLeft=new int[n];
        highestInLeft[0]=-1;
        for(int i=1;i<n;i++){
            if(height[i]<max) highestInLeft[i]=max;
            else{
                highestInLeft[i]=-1;
                max=height[i];
            }
        }
        max=height[n-1];
        int[] highestInRight=new int[n];
        highestInRight[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            if(height[i]<max) highestInRight[i]=max;
            else{
                highestInRight[i]=-1;
                max=height[i];
            }
            //System.out.print(highestInRight[i]+" ");
        }
        int count=0;
        for(int i=1;i<n-1;i++){
            if(highestInRight[i]==-1||highestInLeft[i]==-1) continue;
            else{
                count+= Math.min(highestInRight[i],highestInLeft[i])-height[i];
            }
        }
        return count;
    }
}
