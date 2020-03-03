class Solution:
    def addBinary(self, a: str, b: str) -> str:
        s=0
        lena=len(a)
        lenb=len(b)
        for i in range(lena):
            x=int(a[i:i+1])
            s=s+x*(2**(lena-1-i))
        for i in range(lenb):
            x=int(b[i:i+1])
            s=s+x*(2**(lenb-1-i))
        return bin(s).replace('0b', '')