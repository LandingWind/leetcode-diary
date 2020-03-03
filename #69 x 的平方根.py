class Solution:
    def mySqrt(self, x: int) -> int:
        l=1
        r=x
        while l<=r:
            mid=(l+r)>>1
            t=mid**2
            if t==x:
                return mid
            if t>x:
                r=mid-1
            else:
                l=mid+1
        return r