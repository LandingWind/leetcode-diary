class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        if(len==0) return -1;
        if(len==1) {
            if(nums[0]==target) return 0;
            else return -1;
        }
        int l=0;
        int r=len-1;
        while(l<=r) {
            int mid=(l+r)>>1;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]) {
                if(nums[l]<=target && nums[mid]>=target) r=mid-1;
                else l=mid+1;
            }else{
                if(nums[mid]<=target && nums[r]>=target) l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
    }
}