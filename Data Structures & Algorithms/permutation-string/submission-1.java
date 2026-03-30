class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] count1=new int[26];
        int[] count2=new int[26];
        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        int matches=0;
        for(int i=0;i<26;i++){
            if(count1[i]==count2[i]) matches++;
        }
        int start=0;
        for(int end=s1.length();end<s2.length();end++){
            if(matches==26) return true;
            int r=s2.charAt(end)-'a';
            int l=s2.charAt(start)-'a';
            start++;

            count2[r]++;
            if(count1[r]==count2[r]) matches++;
            else if(count1[r]+1==count2[r]) matches--;

            count2[l]--;
            if(count1[l]==count2[l]) matches++;
            else if(count1[l]-1==count2[l]) matches--;
           
        }
        return matches==26;
    }
}
