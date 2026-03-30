class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        int start=0;
        int have=0;
        int need=mp.size();
        int minLen=Integer.MAX_VALUE;
        Map<Character,Integer> window = new HashMap<>();
        int minStart=0;
        for(int end=0;end<s.length();end++){
            Character c=s.charAt(end);
            window.put(c,window.getOrDefault(c,0)+1);
            if(mp.containsKey(c)){
                if(window.get(c)==mp.get(c)) have++;
            }
            while(have==need){
                int curr=end-start+1;
                if(curr<minLen){
                    minLen=curr;
                    minStart=start;
                }
                Character left=s.charAt(start);
                window.put(left,window.get(left)-1);
                if(mp.containsKey(left) && window.get(left)<mp.get(left)){
                    have--;
                }
                start++;

            }
        }
        if(minLen==Integer.MAX_VALUE) return "";
        return s.substring(minStart,minStart+minLen);
    }
}
