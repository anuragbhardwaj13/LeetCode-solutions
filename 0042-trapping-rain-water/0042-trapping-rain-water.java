class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
         int[] prefix=new int[n];
        int[] suffix=new int[n];
        int pre_max=Integer.MIN_VALUE;
        int suf_max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>=pre_max){
                pre_max=arr[i];
            }
            prefix[i]=pre_max;

        }
//        System.out.println(Arrays.toString(Arrays.stream(prefix).toArray()));
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=suf_max){
                suf_max=arr[i];
            }
            suffix[i]=suf_max;
        }
//        System.out.println(Arrays.toString(Arrays.stream(suffix).toArray()));


        int count=0;
        for(int i=0;i<n;i++){
            count+=(Math.min(prefix[i],suffix[i])-arr[i]);
        }
        return count;
    }
}