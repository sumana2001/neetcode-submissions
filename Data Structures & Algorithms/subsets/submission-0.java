class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums,int i,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int j=i;j<nums.length;j++){
            list.add(nums[j]);
            backtrack(nums,j+1,list);
            list.remove(list.size()-1);
        }
        
    }
}
