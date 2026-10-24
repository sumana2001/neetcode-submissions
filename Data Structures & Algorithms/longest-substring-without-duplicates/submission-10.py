class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        i=0
        maxLen=0
        start=0
        end=0
        while i<len(s):
            end=i
            if s[i] in seen:
                for j in range(start, end):
                    start+=1
                    seen.remove(s[j])
                    if s[i] == s[j]:
                        break
            maxLen=max(maxLen,end-start+1)
            seen.add(s[i])
            end+=1
            i+=1
        return maxLen

        