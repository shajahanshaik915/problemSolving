class Solution {
    public String losingPlayer(int x, int y) {
        boolean alice=false;
        while(x>0&&y>3){
            x-=1;
            y-=4;
            alice=!alice;
        }
        if(alice) return "Alice";
        return "Bob";
    }
}
