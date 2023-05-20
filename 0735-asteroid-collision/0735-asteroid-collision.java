class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        for(int a:asteroids){
            if(a<0){
                while(!s.isEmpty()&& s.peek()>0 && s.peek()<Math.abs(a)){
                    s.pop();
                }
                if(s.isEmpty()|| s.peek()<0){
                    s.push(a);
                }else if(s.peek()==Math.abs(a)){
                    s.pop();
                }else{
                    continue;
                }
            }else{
                s.push(a);
            }
        }
        
        int[] res=new int[s.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i]=s.pop();
        }
        return res;
    }
}