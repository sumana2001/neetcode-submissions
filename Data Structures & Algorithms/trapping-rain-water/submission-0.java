class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(height[i],max);
            prefix[i]=max;
        }
        max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            max=Math.max(height[i],max);
            suffix[i]=max;
        }
        int trapped=0;
        for(int i=0;i<n;i++){
            trapped+=Math.min(prefix[i],suffix[i])-height[i];
        }
        return trapped;
    }
}
