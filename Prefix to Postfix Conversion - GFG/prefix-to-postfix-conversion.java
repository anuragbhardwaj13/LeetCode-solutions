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
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        String infix=preToInfix(pre_exp);
        String postfix=infixToPostfix(infix);
        return postfix;
    }
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(!checkOperator(ch)){
                st.push(ch+"");
            }else if(checkOperator(ch)){
                String str='('+st.pop()+ch+st.pop()+')';
                st.push(str);
            }
        }
        return st.pop();
        
    }
    public static boolean checkOperator(char x){
         switch(x){
        case '+':
        case '-':
        case '/':
        case '*':
        case '^':
        case '%':
            return true;
    }
    return false;
    }
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
