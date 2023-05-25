//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int l=0;
        int r=0;
        int size=txt.length();
        int k=pat.length();
        int res=0;
        HashMap<Character,Integer> pattern=new HashMap<>();
        for(int i=0;i<pat.length();i++){
            char c=pat.charAt(i);
            if(pattern.containsKey(c)){
                pattern.put(c,pattern.get(c)+1);
            }else{
                pattern.put(c,1);
            }
        }
       int count=pattern.size();
       while(r<size){
           char c=txt.charAt(r);
           if(pattern.containsKey(c)){
               pattern.put(c,pattern.get(c)-1);
               if(pattern.get(c)==0){
                   count--;
               }
           }
           
           if(r-l+1==k){
               if(count==0){
                   res++;
               }
               
               if(pattern.containsKey(txt.charAt(l))){
                   pattern.put(txt.charAt(l),pattern.get(txt.charAt(l))+1);
                   if(pattern.get(txt.charAt(l))==1){
                       count++;
                   }
               }
               l++;
           }
           r++;
       }
       return res;
    }
    
}