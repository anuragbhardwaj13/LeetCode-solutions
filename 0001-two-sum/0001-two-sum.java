class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int ts=target-nums[i];
            if(map.containsKey(ts)){
                return new int[]{i,map.get(ts)};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}