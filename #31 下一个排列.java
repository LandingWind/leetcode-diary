class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len==0 || len==1) return;
        
        for(int i=len-1;i>=1;i--) {
            if(nums[i]>nums[i-1]) {
                Arrays.sort(nums,i,len);
                int minPos=i;
                for(int j=i;j<len;j++) {
                    if(nums[j]>nums[i-1]) {
                        minPos=j;break;
                    } 
                }
                int t=nums[i-1];
                nums[i-1]=nums[minPos];
                nums[minPos]=t;
                return;
            }
        }
        Arrays.sort(nums);
    }
}