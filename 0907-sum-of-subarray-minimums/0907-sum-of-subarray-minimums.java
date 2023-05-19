class Pairs{
    int element;
    int mini;
    public Pairs(int el,int min){
        element=el;
        mini=min;
    }
}
class Solution {
    public long m = (int)Math.pow(10,9)+7;
    public int sumSubarrayMins(int[] arr) {
        int[] left=new int[arr.length];
        int[] right=new int[arr.length];
        ArrayDeque<Pairs> stack1=new ArrayDeque<>();
        ArrayDeque<Pairs> stack2=new ArrayDeque<>();

        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            int count=1;
            while(stack1.size()!=0&&stack1.peek().element>curr){
                count+=stack1.peek().mini;
                stack1.pop();
            }
            stack1.push(new Pairs(curr,count));
            left[i]=count;
        }
        for(int i=arr.length-1;i>=0;i--){
            int curr=arr[i];
            int count=1;
            while(stack2.size()!=0&&stack2.peek().element>=curr){
                count+=stack2.peek().mini;
                stack2.pop();
            }
            stack2.push(new Pairs(curr,count));
            right[i]=count;
        }

        long ans =0;
        for(int i=0;i<arr.length;i++)
            ans= (ans+left[i]*right[i]*(long)arr[i])%m;
        
        return (int)ans;
    }
}