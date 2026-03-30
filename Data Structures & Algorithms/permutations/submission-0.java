class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(nums,used,new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums,boolean[] used,List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            list.add(nums[i]);
            used[i]=true;
            backtrack(nums,used,list);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
}
