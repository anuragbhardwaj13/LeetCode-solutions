//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
         int[] prefix=new int[n];
        int[] suffix=new int[n];
        int pre_max=Integer.MIN_VALUE;
        int suf_max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>=pre_max){
                pre_max=arr[i];
            }
            prefix[i]=pre_max;

        }
//        System.out.println(Arrays.toString(Arrays.stream(prefix).toArray()));
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=suf_max){
                suf_max=arr[i];
            }
            suffix[i]=suf_max;
        }
//        System.out.println(Arrays.toString(Arrays.stream(suffix).toArray()));


        long count=0;
        for(int i=0;i<n;i++){
            count+=((long)Math.min(prefix[i],suffix[i])-(long)arr[i]);
        }
        return count;
    } 
}


