class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Arrays.fill(res,0);
        Deque<int[]> s=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(s.size()!=0 && temperatures[i]>s.peek()[0]){
                int[] curr=s.pop();
                res[curr[1]]=i-curr[1];
            }
            int[] curr=new int[2];
            curr[0]=temperatures[i];
            curr[1]=i;
            s.push(curr);
        } 
        return res;
    }
}
