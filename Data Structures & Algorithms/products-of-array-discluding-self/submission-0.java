class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int[] su=new int[n];
        int[] res=new int[n];
        pre[0]=1;
        su[n-1]=1;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            su[i]=su[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            res[i]=pre[i]*su[i];
        }
        return res;
    }
}  
