class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(n-1!=edges.length) return false;
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int[] e:edges){
            if(!union(e[0],e[1])) return false;
        }
        return true;
    }

    public boolean union(int u, int v){
        int lu=find(u);
        int lv=find(v);
        if(lu==lv) return false;
        parent[lu]=lv;
        return true;
    }

    public int find(int i){
        if(parent[i]==i) return i;
        parent[i]=find(parent[i]);
        return parent[i];
    }
}
