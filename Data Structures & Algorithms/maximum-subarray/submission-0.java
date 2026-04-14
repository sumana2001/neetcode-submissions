class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            curSum=Math.max(curSum+nums[i],nums[i]);
            maxSum=Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}
