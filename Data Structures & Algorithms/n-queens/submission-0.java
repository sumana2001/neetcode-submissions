class Solution {
    List<List<String>> res;
    Set<Integer> cols;
    Set<Integer> diag1;
    Set<Integer> diag2;
    public List<List<String>> solveNQueens(int n) {
        res=new ArrayList<>();
        cols=new HashSet<>();
        diag1=new HashSet<>();
        diag2=new HashSet<>();
        backtrack(0,n,new ArrayList<>());
        return res;
    }

    private void backtrack(int row,int n,List<String> board){
        if(row==n){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int col=0;col<n;col++){
            if(cols.contains(col) || diag1.contains(row-col) || diag2.contains(row+col)){
                continue;
            }
            cols.add(col);
            diag1.add(row-col);
            diag2.add(row+col);
            char[] rowArr=new char[n];
            Arrays.fill(rowArr,'.');
            rowArr[col]='Q';
            board.add(new String(rowArr));
            backtrack(row+1,n,board);
            board.remove(board.size()-1);
            cols.remove(col);
            diag1.remove(row-col);
            diag2.remove(row+col);
        }
    }
}
