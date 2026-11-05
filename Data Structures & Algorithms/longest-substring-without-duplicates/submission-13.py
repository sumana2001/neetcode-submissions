class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen=set()
        maxLen=0
        i=0
        j=0
        while j<len(s):
            if s[j] in seen:
                while s[j]!=s[i]:
                    seen.remove(s[i])
                    i+=1
                seen.remove(s[i])
                i+=1
            maxLen=max(maxLen,j-i+1)
            seen.add(s[j])
            j+=1
        return maxLen

        