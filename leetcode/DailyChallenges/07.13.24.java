class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] arr=new int[positions.length][4];
        for(int i=0;i<positions.length;i++){
            arr[i][0]=i;
            arr[i][1]=positions[i];
            arr[i][2]=healths[i];
            arr[i][3]=directions.charAt(i)=='R'?0:1;
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<positions.length;i++){
            //right moving
            if(stack.isEmpty()||arr[i][3]==0){
                                     //index->0      health->1       direction->2   
                stack.push(new int[]{arr[i][0],arr[i][2],arr[i][3]});
            }
            //leftMoving
            else{
                int health=arr[i][2];
                boolean shouldIAdd=true;
                while(stack.size()>0){
                    if(stack.peek()[2]!=0){
                        break;
                    }
                    else if(stack.peek()[1]>health){
                        int[] dum=stack.pop();
                        dum[1]=dum[1]-1;
                        stack.push(dum);
                        shouldIAdd=false;
                        break;
                    }
                    else if(stack.peek()[1]==health){
                        stack.pop();
                        shouldIAdd=false;
                        break;
                    }
                    else{
                        stack.pop();
                        health--;
                    }
                }
                if(shouldIAdd) stack.push(new int[]{arr[i][0],health,arr[i][3]});

            }

        }
        int[][] finalArr=new int[stack.size()][2];
        int index=0;
        while(stack.size()>0){
            int[] a=stack.pop();
            finalArr[index][0]=a[0];
            finalArr[index][1]=a[1];
            index++;
        }
        Arrays.sort(finalArr,(a,b)->a[0]-b[0]);
        List<Integer> l=new ArrayList<>();
        for(int[] a:finalArr){
            l.add(a[1]);
        }
        return l;
    }
}
