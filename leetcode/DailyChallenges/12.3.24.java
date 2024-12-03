class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int index=0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char ch=arr[i];
            if(index<spaces.length&&i==spaces[index]){
                sb.append(" ");
                index++;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
