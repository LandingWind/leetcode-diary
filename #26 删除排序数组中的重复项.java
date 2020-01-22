class Solution {
    public int removeDuplicates(int[] nums) {
        int t=-10086;
        int count=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==t) {
                // duplicate
            } else {
                t = nums[i];
                nums[count] = t;
                count++;
            }
        }
        return count;
    }
}