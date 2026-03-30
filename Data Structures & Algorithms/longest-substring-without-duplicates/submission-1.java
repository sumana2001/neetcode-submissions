class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> mp=new HashSet<>();
        int start=0,maxLen=0;
        for(int end=0;end<s.length();end++){
            Character curr=s.charAt(end);
            if(mp.contains(curr)){
                while(s.charAt(start)!=curr){
                    mp.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            mp.add(curr);
            maxLen=Math.max(maxLen,end-start+1);
        }
        return maxLen;
    }
}