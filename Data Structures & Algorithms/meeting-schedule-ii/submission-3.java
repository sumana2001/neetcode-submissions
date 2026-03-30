/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0) return 0;
        int n=intervals.size();
        int[] starts=new int[n];
        int[] ends=new int[n];
        for(int i=0;i<n;i++){
            starts[i]=intervals.get(i).start;
            ends[i]=intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count=0,maxCount=0,s=0,e=0;
        for(int i=0;i<n;i++){
            if(starts[s]<ends[e]){
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;
    }
}
