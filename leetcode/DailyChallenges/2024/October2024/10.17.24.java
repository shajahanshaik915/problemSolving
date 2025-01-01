class Solution {
    public int maximumSwap(int num) {
        String numString=""+num;
        int[] a=new int[numString.length()];
        for(int i=0;i<a.length;i++){
            a[i]=numString.charAt(i)-'0';
        }
        int[] maxElInRight=new int[a.length];
        maxElInRight[a.length-1]=a.length-1;
        for(int i=a.length-2;i>=0;i--){
            if(a[i]<=a[maxElInRight[i+1]]){
                maxElInRight[i]=maxElInRight[i+1];
            }
            else{
                maxElInRight[i]=i;
            }
            //System.out.println(maxElInRight[i]);
        }
        int max=num;
        for(int i=0;i<a.length;i++){
            if(a[maxElInRight[i]]>a[i]){
                int temp=a[maxElInRight[i]];
                a[maxElInRight[i]]=a[i];
                a[i]=temp;
                return helper(a);
            }
        }
        return num;
    }
    public int helper(int[] a){
        String s="";
        for(int b:a) s+=b;
        return Integer.parseInt(s);
    }
}


   
