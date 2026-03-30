class Solution {
    public int maxArea(int[] heights) {
        int start=0;
        int end=heights.length-1;
        int maxArea=0;
        while(start<end){
            int curr=(end-start)*Math.min(heights[start],heights[end]);
            maxArea=Math.max(maxArea,curr);
            if(heights[start]>heights[end]) end--;
            else start++;
        }
        return maxArea;
    }
}
