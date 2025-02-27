class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set=new HashSet<>();
        for(int a:arr) set.add(a);

        int max=0,n=arr.length;
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                
                if(i==j) continue;
                int a=arr[i],b=arr[j],size=2;
                
                while(a-b<b&&set.contains(a-b)){
                    int dummy=a-b;
                    a=b;
                    b=dummy;
                    size++;
                    
                }
                
                
                if(size>2) max=Math.max(max,size);
            }
        }
        return max;
    }
}
