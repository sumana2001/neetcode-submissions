class Solution {
    int parent[];
    int res;
    public int countComponents(int n, int[][] edges) {
        res=n;
        parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int[] e:edges){
            union(e[0],e[1]);
        }
        return res;
    }

    public void union(int u,int v){
        int lu=find(u);
        int lv=find(v);
        if(lu==lv) return;
        parent[lu]=lv;
        res--;
    }

    public int find(int i){
        if(parent[i]==i) return i;
        parent[i]=find(parent[i]);
        return parent[i];
    }
}
