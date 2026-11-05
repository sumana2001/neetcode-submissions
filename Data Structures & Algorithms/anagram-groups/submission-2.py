class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp={}
        for word in strs:
            arr=[0]*26
            for ch in word:
                arr[ord(ch)-ord('a')]+=1
            key=tuple(arr)
            if key in mp:
                mp[key].append(word)
            else:
                l=[word]
                mp[key]=l
        finalList=[]
        for key in mp:
            finalList.append(mp[key])
        return finalList
            
        