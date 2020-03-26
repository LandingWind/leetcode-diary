class Solution:

    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        def dude(n):
            arr=[]
            for i in range(2,n+1):
                if n%i==0:
                    arr.append(i)
            return arr 
        l=len(deck)
        arr={}
        for i in deck:
            if i not in arr:
                arr[i]=1
            else:
                arr[i]+=1
        if len(arr)==1:
            if l>=2:
                return True
            else:
                return False
        
        arr2={}
        t=[]
        for (k,v) in arr.items():
            arr2[k]=dude(v)
            if t==[]:
                t=arr2[k]
        
        for x in t:
            ff=True
            s=0
            for (k,v) in arr2.items():
                if x not in v:
                    ff=False
                    break
                s=s+arr[k]/x
            if ff:
                if s>=2:
                    return True
        # print(arr,arr2)
        return False