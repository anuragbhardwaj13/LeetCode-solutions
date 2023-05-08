//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> nums, int N){
        // code here
        // ArrayList<Integer> curr = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		printSS( 0, 0,nums,nums.size(), ans);
		Collections.sort(ans);
        return ans;
    }
    public static void printSS(int index, int sum, ArrayList<Integer> arr, int n,
            List<Integer> ans) {
        if (index == n) {
            ans.add(sum);
            return;
        }
        // list.add(arr.get(index));
        printSS(index + 1, sum+arr.get(index), arr, n, ans);
        // list.remove(list.size() - 1);
        printSS(index + 1, sum, arr, n, ans);
    }
}
    