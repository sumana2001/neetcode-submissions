class Solution {

    class Edge {
        int node;
        int weight;
        Edge(int n, int w){
            this.node=n;
            this.weight=w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] t:times){
            int u=t[0]-1;
            int v=t[1]-1;
            int w=t[2];
            graph.get(u).add(new Edge(v,w));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((p1,p2)->p1[1]-p2[1]);
        pq.offer(new int[]{k-1,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            if(curr[1]>dist[node]) continue;
            for(Edge e:graph.get(node)){
                int newTime=curr[1]+e.weight;
                if(newTime<dist[e.node]){
                    dist[e.node]=newTime;
                    pq.offer(new int[]{e.node,newTime});
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            if(dist[i]>max){
                max=dist[i];
            }
        }
        return max;
    }
}
