class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res=nums[0]+nums[1]+nums[2];
        int diff=Math.abs(target-res);
        int len = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<len-2;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1;
            int r = len-1;
            while(l<r) {
                int sum = nums[i] + nums[l]+nums[r];
                // System.out.println(sum);
                if(Math.abs(target-sum) < diff) {
                    diff = Math.abs(target-sum);
                    res = sum;
                }
                if(target-sum>0) {
                    l++;
                    while(l<r && nums[l]==nums[l-1]) l++;
                }
                else if(target-sum<0) {
                    r--;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
                else {
                    return target;
                }
            }
        }
        return res;
    }
}