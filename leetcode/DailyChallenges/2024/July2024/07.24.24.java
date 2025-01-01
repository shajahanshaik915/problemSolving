class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[][] a=new int[nums.length][2];
        int n=nums.length;
        //index,value.....
        for(int i=0;i<n;i++){
            a[i][0]=i;
            a[i][1]=helper(nums[i],mapping);
        }
        Arrays.sort(a,(a1,b1)->{
           if(a1[1]==b1[1]) return a1[0]-b1[0];
            return a1[1]-b1[1];
        });
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=nums[a[i][0]];
        }
        return answer;
    }
    public static int helper(int number,int[] mapping){
        String s=""+number;
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            ch[i]=(char)(mapping[ch[i]-'0']+'0');
        }
        return Integer.parseInt(new String(ch));
    }
}
