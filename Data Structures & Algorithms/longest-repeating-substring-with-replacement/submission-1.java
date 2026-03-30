class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr=new int[26];
        int max=0;
        int currMax=0;
        int start=0;
        s=s.toUpperCase();
        for(int end=0;end<s.length();end++){
            Character curr=s.charAt(end);
            arr[curr-'A']++;
            currMax=Math.max(arr[curr-'A'],currMax);
            while(end-start+1-currMax>k){
                arr[s.charAt(start)-'A']--;
                start++;
            }
            max=Math.max(max,end-start+1);
        }
        return max;
    }
}
