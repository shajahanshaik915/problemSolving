class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        if(n%2==0&&m%2==0) return 0;
        else if(n%2==0&&m%2==1) return xor(nums1);
        else if(n%2==1&&m%2==0) return xor(nums2);
        else{
            int[] a=new int[n+m];
            for(int i=0;i<n;i++) a[i]=nums1[i];
            int index=n;
            for(int i=0;i<m;i++){
                a[index++]=nums2[i];
            }
            return xor(a);
        }
    }
    public int xor(int[] a){
        Map<Integer,Integer> m=new HashMap<>();
        for(int b:a) m.put(b,m.getOrDefault(b,0)+1);
        int xor=0;
        for(int b:m.keySet()){
            if(m.get(b)%2==1) xor^=b;
        }
        return xor;
    }
}
