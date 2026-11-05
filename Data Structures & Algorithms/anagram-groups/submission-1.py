class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp={}
        for word in strs:
            key="".join(sorted(word))
            if key in mp:
                l=mp[key]
                l.append(word)
                mp[key]=l
            else:
                l=[word]
                mp[key]=l
        finalList=[]
        for key in mp:
            finalList.append(mp[key])
        return finalList
            
        