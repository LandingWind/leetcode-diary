class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int l=0;
        int r=len-1;
        int pos=-1;
        while(l<=r) {
            int mid=(l+r)>>1;
            if(nums[mid]==target) {
                pos=mid;
                break;
            }
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        int res[]=new int[2];
        if(pos==-1 || len==0) {
            res[0]=-1;res[1]=-1;
        } else {
            int start=pos;
            int end=pos;
            while(start>0 && nums[start-1]==target) start--;
            while(end+1<len && nums[end+1]==target) end++;
            res[0]=start;res[1]=end;
        }
        return res;
    }
}