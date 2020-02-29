class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // for(int num:nums) System.out.println(num);
        int len = nums.length;
        int ll=0;
        int rr=len-1;
        for(int i=0;i<len-2;i++) {
            if(nums[i]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;
            rr=len-1;
            ll=i+1;
            while(ll<rr){
                if(nums[i]+nums[ll]+nums[rr]<0) {
                    ll++;
                    while(ll<rr && nums[ll]==nums[ll-1]) ll++;
                } else if(nums[i]+nums[ll]+nums[rr]>0) {
                    rr--;
                    while(ll<rr && nums[rr]==nums[rr+1]) rr--;
                } else {
                    ArrayList<Integer> al = new ArrayList<>();
                    Collections.addAll(al, nums[i],nums[ll],nums[rr]);
                    res.add(al);
                    rr--;
                    ll++;
                    while(ll<rr && nums[ll]==nums[ll-1]) ll++;
                    while(ll<rr && nums[rr]==nums[rr+1]) rr--;
                }
            }
        }
        return res;
    }
}