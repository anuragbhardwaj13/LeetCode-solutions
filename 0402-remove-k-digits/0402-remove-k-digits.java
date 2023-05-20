class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        if(k==num.length()){
            return "0";
        }
        
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            while(!st.isEmpty()&& k>0&& st.peek()>c){
                st.pop();
                k-=1;
            }
            if(!st.isEmpty() || c!='0'){
                st.push(c);
            }
            
        }
        while(k-->0&& !st.isEmpty()){
            st.pop();
        }
        
        if(st.isEmpty()){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}