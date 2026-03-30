class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(maxHeap.size()-minHeap.size()>1 || (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())){
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size()-maxHeap.size()>1){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()>maxHeap.size()){
            return (double) minHeap.peek();
        } else if(minHeap.size()<maxHeap.size()){
            return (double) maxHeap.peek(); 
        } else {
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        }
    }
}
