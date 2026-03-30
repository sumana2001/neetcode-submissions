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
        intervals.sort((a,b)->a.start-b.start);
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        heap.add(intervals.get(0).end);
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start >= heap.peek()){
                heap.poll();
            }
            heap.add(intervals.get(i).end);
        }
        return heap.size();
    }
}
