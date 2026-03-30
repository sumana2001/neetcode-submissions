class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int trapped=0;
        int maxStart=0,start=0;
        int maxEnd=0,end=n-1;
        while(start<end){
            if(height[start]<height[end]){
                if(height[start]<maxStart){
                    trapped+=maxStart-height[start];
                } else {
                    maxStart=height[start];
                }
                start++;
            } else {
                if(height[end]<maxEnd){
                    trapped+=maxEnd-height[end];
                } else {
                    maxEnd=height[end];
                }
                end--;
            }
        }
        return trapped;
    }
}
