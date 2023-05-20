//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            long res = obj.subarrayRanges(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long subarrayRanges(int n, int[] nums) {
        // code here
         long sum=0;

    Stack<Integer> st=new Stack<>();
    int[] prevMin=new int[n];
    int[] prevMax=new int[n];
    int[] nextMin=new int[n];
    int[] nextMax=new int[n];
    Arrays.fill(prevMin , -1);
    Arrays.fill(nextMin , n);
    Arrays.fill(prevMax , -1 );
    Arrays.fill(nextMax , n);
    //calculate left min
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevMin[i]=st.peek();
            }
            st.push(i);
        }
        //empty stack here
        while(!st.isEmpty()){
            st.pop();
        }
    //calculate right min
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextMin[i]=st.peek();
            }
            st.push(i);
        }
        //empty stack here
        while(!st.isEmpty()){
            st.pop();
        }
        //calculate left max
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevMax[i]=st.peek();
            }
            st.push(i);
        }
        //empty stack here
        while(!st.isEmpty()){
            st.pop();
        }
    //calculate right max
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextMax[i]=st.peek();
            }
            st.push(i);
        }
        //empty stack here
        while(!st.isEmpty()){
            st.pop();
        }
        
        for(int i=0;i<n;i++){
            long lMin=i-prevMin[i];
            long rMin=nextMin[i]-i;
            long lMax=i-prevMax[i];
            long rMax=nextMax[i]-i;
            
            sum+=(lMax*rMax-lMin*rMin)*nums[i];
        }
        return sum;
    }
}
