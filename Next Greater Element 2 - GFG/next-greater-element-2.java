//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] nextGreaterElement(int n, int arr[]) {
        // code here
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        for(int i=2*n-1;i>=0;i--){
            if(st.isEmpty()){
                res[i%n]=-1;                
            }
            else{
                if(st.peek()>arr[i%n]){
                    res[i%n]=st.peek();
                }else{
                    while(!st.isEmpty()&&st.peek()<=arr[i%n]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        res[i%n]=-1;
                    }else{
                       res[i%n]=st.peek();
   
                    }
                }
            }
            st.push(arr[i%n]);
        }
        return res;
    }
}
