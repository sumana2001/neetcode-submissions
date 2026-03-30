class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        int idx=0;
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                result[idx++]=nums[dq.peekFirst()];
            }
        }
        return result;
    }
}