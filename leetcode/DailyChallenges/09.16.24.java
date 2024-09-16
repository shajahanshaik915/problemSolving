class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<String> l=new ArrayList<>();
        for(String s:timePoints){
            if(s.substring(0,2).equals("00")) l.add("24:"+s.substring(3,5));
        }
        timePoints.addAll(l);
        Collections.sort(timePoints,(a,b)->{
            int aHours=Integer.parseInt(a.substring(0,2)),bHours=Integer.parseInt(b.substring(0,2));
            int aMinutes=Integer.parseInt(a.substring(3,5)),bMinutes=Integer.parseInt(b.substring(3,5));
            if(aHours==bHours) return aMinutes-bMinutes;
            return aHours-bHours;
        });
        //System.out.println(timePoints);
        int minDifference=Integer.MAX_VALUE;
        for(int i=1;i<timePoints.size();i++){
            minDifference=Math.min(minDifference,findDiff(timePoints.get(i),timePoints.get(i-1)));
        }
        
        int firstHours=Integer.parseInt(timePoints.get(0).substring(0,2))+24,lastHours=Integer.parseInt(timePoints.get(timePoints.size()-1).substring(0,2)),firstMinutes=Integer.parseInt(timePoints.get(0).substring(3,5)),lastMinutes=Integer.parseInt(timePoints.get(timePoints.size()-1).substring(3,5));
        
        if(l.size()==0||(l.size()>0&&lastHours!=24)){
            int diff=0;
            diff+=(60-lastMinutes)+firstMinutes;
            diff+=(firstHours-lastHours-1)*60;
            minDifference=Math.min(diff,minDifference);
        }
        return minDifference;
    }
    public int findDiff(String a,String b){
        if(a.equals(b)) return 0;
            int aHours=Integer.parseInt(a.substring(0,2)),bHours=Integer.parseInt(b.substring(0,2));
            int aMinutes=Integer.parseInt(a.substring(3,5)),bMinutes=Integer.parseInt(b.substring(3,5));
            int count=0;
            count+=(60-bMinutes)+aMinutes;
            count+=(aHours-bHours-1)*60;
            return count;
    }
}
