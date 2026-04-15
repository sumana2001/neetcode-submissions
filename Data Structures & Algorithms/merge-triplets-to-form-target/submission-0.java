class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x=false,y=false,z=false;
        for(int i=0;i<triplets.length;i++){
            if(target[0]<triplets[i][0] ||target[1]<triplets[i][1] ||target[2]<triplets[i][2]) continue;
            if(target[0]==triplets[i][0]){
                x=true;
            }
            if(target[1]==triplets[i][1]){
                y=true;
            }
            if(target[2]==triplets[i][2]){
                z=true;
            }
        }
        return x && y && z;
    }
}
