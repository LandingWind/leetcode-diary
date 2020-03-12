class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        len1=len(str1)
        len2=len(str2)
        res=""
        for i in range(1,min(len1,len2)+1):
            # print(i)
            if len1%i==0 and len2%i==0:
                x=str1[:i]
                # print(x,type(x))
                d1=x*(len1//i)
                d2=x*(len2//i)
                # print(d1,d2)
                if d1==str1 and d2==str2:
                    res=x
        return res