class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res=new ArrayList<>();
        int i=0;
        for(;i<intervals.length;i++){
            if(intervals[i][1]>=newInterval[0]){
                break;
            }
            int[] arr=intervals[i];
            res.add(arr);
        }
        int j=i;
        for(;i<intervals.length;i++){
            if(intervals[i][0]<=newInterval[1]){
                newInterval[0]=Math.min(newInterval[0],intervals[j][0]);
                newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            } else {
                break;
            }
        }
        res.add(newInterval);
        for(;i<intervals.length;i++){
            res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
