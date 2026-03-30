class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            if(mp.containsKey(sorted)){
                mp.get(sorted).add(str);
            } else {
                List<String> list=new ArrayList<>();
                list.add(str);
                mp.put(sorted,list);
            }
        }
        return new ArrayList<>(mp.values());
    }
}
