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
    // public int minMeetingRooms(List<Interval> intervals) {
    //     if(intervals.size()==0) return 0;
    //     intervals.sort((a,b)->a.start-b.start);
    //     PriorityQueue<Integer> heap=new PriorityQueue<>();
    //     heap.add(intervals.get(0).end);
    //     for(int i=1;i<intervals.size();i++){
    //         if(intervals.get(i).start >= heap.peek()){
    //             heap.poll();
    //         }
    //         heap.add(intervals.get(i).end);
    //     }
    //     return heap.size();
    // }
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size()==0) return 0;
        List<Integer> starts=new ArrayList<>();
        List<Integer> ends=new ArrayList<>();
        intervals.sort((a,b)->a.start-b.start);
        for(int i=0;i<intervals.size();i++){
            starts.add(intervals.get(i).start);
            ends.add(intervals.get(i).end);
        }
        int count=0,s=0,e=ends.size()-1,maxCount=0;
        while(s<=e){
            if(starts.get(s)<ends.get(e)){
                s++;
                count++;
            } else {
                e++;
            }
            maxCount=Math.max(count,maxCount);

        }
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
