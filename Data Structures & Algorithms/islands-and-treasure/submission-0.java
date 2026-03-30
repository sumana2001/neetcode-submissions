class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) q.add(new int[]{i,j});
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] top=q.poll();
            int val=grid[top[0]][top[1]];
            for(int[] d:directions){
                int ni=top[0]+d[0];
                int nj=top[1]+d[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==2147483647){
                    grid[ni][nj]=val+1;
                    q.add(new int[]{ni,nj});
                }
            }
        }
    }
}
