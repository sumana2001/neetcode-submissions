class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=Integer.MIN_VALUE;
        int n=heights.length;
        Stack<int[]> s=new Stack<>();
        for(int i=0;i<n;i++){
            int j=i;
            while(!s.isEmpty() && s.peek()[1]>heights[i]){
                int[] high=s.pop();
                int area=(i-high[0])*high[1];
                maxArea=Math.max(area,maxArea);
                j=high[0];
            }
            int[] curr=new int[2];
            curr[0]=j;
            curr[1]=heights[i];
            s.push(curr);
        }
        while(!s.isEmpty()){
            int[] curr=s.pop();
            int area=(n-curr[0])*curr[1];
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}
