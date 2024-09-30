class CustomStack {
    int ar[]=new int[1000];
    int max=0;
    int top=0;
    public CustomStack(int maxSize) {
        max=maxSize;
    }
    
    public void push(int x) {
        if(top<max)
        {
            ar[top]=x;
            top=top+1;
        }
    }
    
    public int pop() {
        if(top>0)
        {
            top=top-1;
            return ar[top];
        }
        return -1;
        
    }
    
    public void increment(int k, int val) {
        if(k<top)
        {
            for(int i=0;i<k;i++)
            {
                ar[i]=ar[i]+val;
            }
        }
        else
        {
            for(int i=0;i<top;i++)
            {
                ar[i]=ar[i]+val;
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
