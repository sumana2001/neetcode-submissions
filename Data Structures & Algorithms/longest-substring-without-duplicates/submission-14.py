class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = {}
        i=0
        j=0
        maxLen=0
        while j < len(s):
            if s[j] in d:
                i=max(d[s[j]]+1,i)
            d[s[j]]=j
            maxLen=max(maxLen,j-i+1)
            j+=1
        return maxLen


        