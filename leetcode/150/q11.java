class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,max=0;
        while(i<j){
            //System.out.println(i+" "+j+" max"+max);
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
    }
}
