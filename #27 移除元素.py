class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        pos = 0
        for item in nums:
            if item!=val:
                nums[pos] = item
                pos = pos+1
        return pos