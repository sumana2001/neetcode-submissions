class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] count=new int[26];
        for(int i=0;i<s1.length();i++){
            count[s1.charAt(i)-'a']++;
        }
        int start=0;
        for(int end=0;end<s2.length();end++){
            int idx=s2.charAt(end)-'a';
            count[idx]--;
            while(count[idx]<0){
                count[s2.charAt(start)-'a']++;
                start++;
            }
            if(end-start+1==s1.length()) return true;
        }
        return false;
    }
}
