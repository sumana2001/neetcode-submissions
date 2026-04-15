class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),i);
        }
        int cur=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int end=mp.get(c);
            if(end>cur) {
                cur=end;
            } 
            if(i==cur){
                list.add(cur-start+1);
                start=cur+1;
                if(start<s.length()){
                cur=mp.get(s.charAt(start));
                }
            }
        }
        return list;
    }
}
