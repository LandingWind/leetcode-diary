class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        n=num_people
        ans=[0]*n
        pos=0
        t=1
        while candies>0:
            if candies>=t:
                candies -= t
                ans[pos] += t
            else:
                ans[pos] += candies
                candies = 0
            pos += 1
            t += 1
            if pos>=n:
                pos=0

        return ans
