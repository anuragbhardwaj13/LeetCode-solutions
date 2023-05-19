//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends

class Pairs{
    int element;
    int mini;
    public Pairs(int el,int min){
        element=el;
        mini=min;
    }
}

class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int arr[], int n)
    {
        // Your code here
        int[] left=new int[arr.length];
                ArrayDeque<Pairs> stack1=new ArrayDeque<>();
for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            int count=1;
            while(stack1.size()!=0&&stack1.peek().element <= curr){
                count+=stack1.peek().mini;
                stack1.pop();
            }
            stack1.push(new Pairs(curr,count));
            left[i]=count;
        }
        return left;
    }
    
}