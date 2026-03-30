class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        backtrack(n,0,0, new StringBuilder());
        return res;
    }
    private void backtrack(int n, int open, int closed, StringBuilder s){
        if(s.length()==2*n){
            res.add(s.toString());
            return;
        }
        if(open<n){
            s.append('(');
            backtrack(n,open+1,closed,s);
            s.deleteCharAt(s.length()-1);
        }
        if(closed<open){
            s.append(')');
            backtrack(n,open,closed+1,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
