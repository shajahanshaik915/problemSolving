class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k==0) return new int[code.length];
        List<Integer> l=new ArrayList<>();
        if(k<0){
            for(int a:code) l.add(a);
            for(int a:code) l.add(a);
        }
        else{
            for(int i=code.length-1;i>=0;i--) l.add(code[i]);
            for(int i=code.length-1;i>=0;i--) l.add(code[i]);
        }
        //System.out.println(l);
        int[] ans=helper(l,Math.abs(k));
        //for(int b:ans) System.out.print(b+" ");
        if(k>0){
            reverse(ans);
        }
        return ans;
    }
    public int[] helper(List<Integer> l,int k){
        int n=l.size()/2;
        int[] ans=new int[n];
        int index=0,i=n-k,j=i,sum=0;
        while(j<2*n&&index<n){
            while(j-i+1<k){
                sum+=l.get(j);
                j++;
            }
            sum+=l.get(j);
            ans[index++]=sum;
            sum-=l.get(i);
            i++;
            j++;
        }
        return ans;
    }
    public void reverse(int[] a){
        int i=0,j=a.length-1;
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }
}
