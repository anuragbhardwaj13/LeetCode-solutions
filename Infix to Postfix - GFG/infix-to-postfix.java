//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        Stack<Character> st=new Stack<>();
        String res="";
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res+=ch;
            }
            else if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                while(!st.isEmpty()&&st.peek()!='('){
                    res+=st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty()&&getPrecedence(ch)<=getPrecedence(st.peek())){
                    res+=st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
        
    }
    public static int getPrecedence(char ch){
        if(ch=='^'){
            return 3;
        }else if(ch=='*' || ch=='/'){
            return 2;
        }else if(ch=='+' || ch=='-'){
                    return 1;
        }else{
            return -1;
        }
    }
    
}