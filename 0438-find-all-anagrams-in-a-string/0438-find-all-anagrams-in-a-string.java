class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
         int l=0;
        int r=0;
        List<Integer> res=new ArrayList<>();
        int size=txt.length();
        int k=pat.length();
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
                   res.add(l);
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