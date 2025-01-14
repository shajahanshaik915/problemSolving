class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans=new int[A.length];
        Set<Integer> set1=new HashSet<>(),set2=new HashSet<>();
        for(int i=0;i<ans.length;i++){
            int a=A[i],b=B[i];
            if(a==b){
                ans[i]+=1;
                if(i-1>=0) ans[i]+=ans[i-1];
            }else if(set1.contains(b)||set2.contains(a)){
                ans[i]+=set1.contains(b)&&set2.contains(a)?2:1;
                if(i-1>=0) ans[i]+=ans[i-1];
            }
            else if(i-1>=0) ans[i]=ans[i-1];
            
            set1.add(a);
            set2.add(b);
        }
        return ans;
    }
}
