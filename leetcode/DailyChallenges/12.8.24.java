class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int[] suffix=new int[n];
        int[] starttime=new int[n];
        suffix[n-1]=events[n-1][2];
        starttime[n-1]=events[n-1][0];
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1],events[i][2]);
            starttime[i]=events[i][0];
        }
        int max=0;
        for(int i=0;i<n;i++){
            int nextEventStart=events[i][1]+1;
            int index=binarySearch(starttime,i+1,nextEventStart);
            if(index<n){
                max=Math.max(max,events[i][2]+suffix[index]);
            }
            max=Math.max(max,events[i][2]);
        }
        return max;
    }

    public int binarySearch(int[] a,int start,int target){
        int i=start,j=a.length-1,ans=a.length;
        while(i<=j){
            int mid=(i+j)/2;
            if(a[mid]>=target){
                ans=mid;
                j=mid-1;
            }
            else i=mid+1;
        }
        
        return ans;
    }
}
