class Solution {
    private boolean isPalindrome(String s, int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        backtrack(0,new ArrayList<>(),s);
        return res;
    }
    private void backtrack(int start, List<String> sb, String s){
        if(start==s.length()){
            res.add(new ArrayList<>(sb));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                sb.add(s.substring(start,i+1));
                backtrack(i+1,sb,s);
                sb.remove(sb.size()-1);
            }
        }
    }
}
