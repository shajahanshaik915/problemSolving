// Queue<TreeNode> q=new LinkedList<>();
//         q.add(tree);
//         while(q.size()>0){
//             int size=q.size();
//             while(size-->0){
//                 TreeNode node=q.poll();
//                 System.out.print("start: "+node.start+" end: "+node.end+" indexOfMax "+node.indexOfMax+" ");
//                 if(node.left!=null) q.add(node.left);
//                 if(node.right!=null) q.add(node.right);
//             }
//             System.out.println();
//         }

public class TreeNode{
    int start;
    int end;
    int indexOfMax;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int start,int end){
        this.start=start;
        this.end=end;
    }
    TreeNode(int start,int end,int indexOfMax){
        this.start=start;
        this.end=end;
        this.indexOfMax=indexOfMax;
    }
    TreeNode(int start,int end,int indexOfMax,TreeNode left,TreeNode right){
        this.start = start;
        this.end = end;
        this.indexOfMax = indexOfMax;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode tree;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n=heights.length;
        tree=constructSegmentTree(heights,0,n-1);
        int[] ans=new int[queries.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<queries.length;i++){
            int[] query=queries[i];
            int a = Math.min(query[0], query[1]);
            int b = Math.max(query[0], query[1]);

            if (a == b || heights[b] > heights[a]) {
                ans[i]=b;
            }
            else{
                int target=Math.max(heights[a],heights[b]);
                int start=b+1,end=n-1,res=n;
                //System.out.println("new Query "+start+" "+end);
                while(start<=end){
                    int mid=start-(start-end)/2;
                    
                    int maxInLeft=maxInRange(tree,start,mid,heights);
                    //System.out.println("start "+start+" mid: "+mid+" maxInLeft: "+maxInLeft);
                    if(heights[maxInLeft]>target){
                        end=mid-1;
                        res=Math.min(res,maxInLeft);
                    }
                    else{
                        start=mid+1;
                    }
                }
                ans[i]=res==n?-1:res;
            }
        }
        
        
        return ans;
    }
    public int maxInRange(TreeNode tree,int start,int end,int[] heights){
        if(start<=tree.start&&end>=tree.end){
            return tree.indexOfMax;
        }
        if(start>tree.end||end<tree.start){
            return -1;
        }
        int indexOfMaxInLeft=maxInRange(tree.left,start,end,heights);
        int indexOfMaxInRight=maxInRange(tree.right,start,end,heights);
        if(indexOfMaxInRight==-1) return indexOfMaxInLeft;
        if(indexOfMaxInLeft==-1) return indexOfMaxInRight;
        return heights[indexOfMaxInLeft]>=heights[indexOfMaxInRight]?indexOfMaxInLeft:indexOfMaxInRight;

    }
    public TreeNode constructSegmentTree(int[] heights,int start,int end){
        if(start==end){
            return new TreeNode(start,end,start);
        }
        TreeNode node=new TreeNode(start,end);
        int mid=start-(start-end)/2;
        TreeNode left=constructSegmentTree(heights,start,mid);
        TreeNode right=constructSegmentTree(heights,mid+1,end);
        node.left=left;
        node.right=right;
        node.indexOfMax=heights[left.indexOfMax]>heights[right.indexOfMax]?left.indexOfMax:right.indexOfMax;
        return node;
    }
}
