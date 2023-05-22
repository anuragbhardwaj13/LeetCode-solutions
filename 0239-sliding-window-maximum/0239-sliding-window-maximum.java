class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> st=new ArrayDeque<>();
        int left=0;
        int right=0;
        ArrayList<Integer> resList=new ArrayList<>();
        int n=nums.length;
        while(right<n){
            while(!st.isEmpty() && nums[st.getLast()]<nums[right]){
                st.removeLast();
            }
            st.addLast(right);
            if(left>st.getFirst()){
                st.removeFirst();
            }
            if(right+1>=k){
                resList.add(nums[st.getFirst()]);
                left++;
            }
            right++;
        }
        int index=0;
        int[] res=new int[resList.size()];
        for(int i:resList){
            res[index++]=i;
        }
        return res;
        
    }
}