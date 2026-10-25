class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        start=0
        maxLen=0
        for end in range(len(s)):
            while s[end] in seen:
                seen.remove(s[start])
                start+=1
            seen.add(s[end])
            maxLen=max(maxLen,end-start+1)
        return maxLen
        