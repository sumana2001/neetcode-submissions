class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res=new ArrayList<>();
        backtrack(nums,0,target,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums,int i,int target,List<Integer> list){
        if(target<0) return;
        if(target==0) {
            res.add(new ArrayList<>(list));
        }
        for(int j=i;j<nums.length;j++){
            list.add(nums[j]);
            backtrack(nums,j,target-nums[j],list);
            list.remove(list.size()-1);
        }
    }
}
