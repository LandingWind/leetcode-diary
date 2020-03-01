class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = new int[nums.length];
        int len = nums.length;
        for(int i=0;i<len;i++) {
            int t=0;
            for(int j=0;j<len;j++) {
                if(i==j) continue;
                if(nums[i]>nums[j]) t++;
            }
            res[i]=t;
        }
        return res;
    }
}