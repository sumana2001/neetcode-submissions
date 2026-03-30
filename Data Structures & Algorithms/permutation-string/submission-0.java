class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] arr=new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
        }
        int[] arr2=new int[26];
        int start=0;
        for(int end=0;end<s2.length();end++){
            arr2[s2.charAt(end)-'a']++;
            if(end-start+1>s1.length()){
                arr2[s2.charAt(start)-'a']--;
                start++;
            }
            boolean flag=true;
            for(int i=0;i<26;i++){
                if(arr[i]!=arr2[i]) {
                    flag=false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}
