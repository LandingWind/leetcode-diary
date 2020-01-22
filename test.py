class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        len1 = len(haystack)
        len2 = len(needle)
        if len2==0:
            return 0
        if len1<len2:
            return -1
        pos=0
        for i in range(len1):
            if haystack[i]==needle[0] and len1-i>=len2:
                # detect more char
                flag = True
                for j in range(len2):
                    if i+j>=len1 or j>=len2:
                        flag = False
                        break
                    if haystack[i+j]!=needle[j]:
                        flag = False
                        break
                if flag:
                    return i
        return -1