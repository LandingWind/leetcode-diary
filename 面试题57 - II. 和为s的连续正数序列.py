class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        midtarget=target>>1
        res=[]
        t=1
        end=t+1
        pre=list(range(midtarget+2))
        s=t+end
        while(t<=midtarget):
            # too slow method
            # s=t
            # for i in range(t+1, target):
            #     s += i
            #     if s==target:
            #         res.append(list(range(t,i+1)))
            #         break
            #     elif s>target:
            #         break

            # a much quicker method
            # suppose t...y then (t+y)*(y-t+1)/2=target
            if s==target:
                res.append(pre[t:end+1])
                s=s-t+end+1
                t=t+1
                end=end+1
            elif s<target:
                s=s+end+1
                end=end+1
            else:
                s=s-t
                t=t+1
            
        return res