class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,target,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates,int i,int target,List<Integer> list){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<candidates.length;j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            list.add(candidates[j]);
            backtrack(candidates,j+1,target-candidates[j],list);
            list.remove(list.size()-1);
        }
    }
}
