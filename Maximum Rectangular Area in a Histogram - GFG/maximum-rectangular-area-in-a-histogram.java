//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        // your code 
        long[] leftSmall=new long[(int)n];
        long[] rightSmall=new long[(int)n];
        Stack<Integer> st=new Stack<>();
         for(int i=0;i<(int)n;i++){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftSmall[i]=0;

            }else {
                leftSmall[i]=st.peek()+1;
            }
            st.push(i);

        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i=(int)n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightSmall[i]=n-1;

            }else {
                rightSmall[i]=st.peek()-1;
            }
            st.push(i);

        }
        long maxArea=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            long w=rightSmall[i]-leftSmall[i]+1;
            long area=w*arr[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
        
}



