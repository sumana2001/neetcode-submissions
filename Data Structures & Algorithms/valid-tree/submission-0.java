class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length) return false;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int a=e[0];
            int b=e[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited=new boolean[n];
        boolean result=dfs(0,-1,visited,graph);
        if(result){
            for(int i=0;i<n;i++){
                if(!visited[i]) return false;
            }
            return true;
        }
        return false;
    }

    public boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> graph){
        visited[node]=true;
        for(int next: graph.get(node)){
            if(next==parent) continue;
            if(visited[next]) return false;
            if(!dfs(next,node,visited,graph)) return false;
        }
        return true;
    }
}
