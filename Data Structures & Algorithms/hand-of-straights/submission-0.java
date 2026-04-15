class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(hand[i],mp.getOrDefault(hand[i],0)+1);
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(mp.keySet());
        while(!minHeap.isEmpty()){
            int start=minHeap.peek();
            for(int i=0;i<groupSize;i++){
                int cur=start+i;
                if(!mp.containsKey(cur)) return false;
                mp.put(cur,mp.get(cur)-1);
                if(mp.get(cur)==0){
                    if(cur!=minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}
