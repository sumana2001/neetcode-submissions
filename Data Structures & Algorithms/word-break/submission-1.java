class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        Boolean memo[]=new Boolean[s.length()];
        return canBreak(s,0,set,memo);
    }
    private boolean canBreak(String s, int i, Set<String> set, Boolean[] memo){
        if(i==s.length()) return true;
        if(memo[i]!=null) return memo[i];
        for(int j=i;j<s.length();j++){
            String sub=s.substring(i,j+1);
            if(set.contains(sub) && canBreak(s,j+1,set,memo)){
                memo[i]=true;
                return memo[i];
            }
        }
        memo[i]=false;
        return memo[i];
    }
}
