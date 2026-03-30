class Twitter {
    private int time;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer,Set<Integer>> followMap;
    public Twitter() {
        this.time=0;
        this.tweetMap=new HashMap<>();
        this.followMap=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId,k->new ArrayList<>()).add(new int[]{time,tweetId});
        time++;
    }
    //[userId, index, time, tweetId]
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[2]-a[2]);
        Set<Integer> users=new HashSet<>();
        users.add(userId);
        if(followMap.containsKey(userId)){
            users.addAll(followMap.get(userId));
        }
        for(int user:users){
            if(!tweetMap.containsKey(user)){
                continue;
            }
            List<int[]> tweets=tweetMap.get(user);
            int index=tweets.size()-1;
            int[] tweet=tweets.get(index);
            maxHeap.offer(new int[]{user,index,tweet[0],tweet[1]});
        }
        while(!maxHeap.isEmpty() && res.size()<10){
            int[] top=maxHeap.poll();
            int user=top[0];
            int index=top[1];
            int tweetId=top[3];
            res.add(tweetId);
            if(index-1>=0){
                List<int[]> tweets=tweetMap.get(user);
                int[] prev=tweets.get(index-1);
                maxHeap.offer(new int[]{user,index-1,prev[0],prev[1]});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.computeIfAbsent(followerId,k->new HashSet<>()).remove(followeeId);
        }
    }
}
