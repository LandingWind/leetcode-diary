class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        digits.reverse()
        carry=1
        for index in range(len(digits)):
            x=digits[index]+carry
            digits[index]=x%10
            carry=int(x/10)
            if carry==0:
                break
        if carry==1:
            digits.append(1)
        digits.reverse()
        return digits