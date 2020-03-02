class Solution {
    /*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // for(int num:nums) System.out.print(num+" ");
        // System.out.println();
        int len = nums.length;
        int ll=0;
        int rr=len-1;
        for(int j=0;j<len;j++) {
            if(j>0 && nums[j]==nums[j-1]) continue;
            for(int i=j+1;i<len-2;i++) {
                if(i>j+1 && nums[i]==nums[i-1]) continue;
                rr=len-1;
                ll=i+1;
                while(ll<rr){
                    if(nums[j]+nums[i]+nums[ll]+nums[rr]<target) {
                        ll++;
                        while(ll<rr && nums[ll]==nums[ll-1]) ll++;
                    } else if(nums[j]+nums[i]+nums[ll]+nums[rr]>target) {
                        rr--;
                        while(ll<rr && nums[rr]==nums[rr+1]) rr--;
                    } else {
                        // System.out.println(ll+" "+rr+" "+j+" "+i);
                        ArrayList<Integer> al = new ArrayList<>();
                        Collections.addAll(al, nums[j],nums[i],nums[ll],nums[rr]);
                        res.add(al);
                        rr--;
                        ll++;
                        while(ll<rr && nums[ll]==nums[ll-1]) ll++;
                        while(ll<rr && nums[rr]==nums[rr+1]) rr--;
                    }
                }
            }
        }
        return res;
    }
    */

    // 优化速度 version
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int ll=0;
        int rr=len-1;
        for(int j=0;j<len-3;j++) {
            if(j>0 && nums[j]==nums[j-1]) continue;
            if(nums[j]+nums[j+1]+nums[j+2]+nums[j+3]>target) break;
            if(nums[j]+nums[len-1]+nums[len-2]+nums[len-3]<target) continue;
            for(int i=j+1;i<len-2;i++) {
                if(i>j+1 && nums[i]==nums[i-1]) continue;
                if(nums[j]+nums[i]+nums[i+1]+nums[i+2]>target) break;
                if(nums[j]+nums[i]+nums[len-1]+nums[len-2]<target) continue;
                rr=len-1;
                ll=i+1;
                while(ll<rr){
                    if(nums[j]+nums[i]+nums[ll]+nums[rr]<target) {
                        ll++;
                        while(ll<rr && nums[ll]==nums[ll-1]) ll++;
                    } else if(nums[j]+nums[i]+nums[ll]+nums[rr]>target) {
                        rr--;
                        while(ll<rr && nums[rr]==nums[rr+1]) rr--;
                    } else {
                        ArrayList<Integer> al = new ArrayList<>();
                        Collections.addAll(al, nums[j],nums[i],nums[ll],nums[rr]);
                        res.add(al);
                        rr--;
                        ll++;
                        while(ll<rr && nums[ll]==nums[ll-1]) ll++;
                        while(ll<rr && nums[rr]==nums[rr+1]) rr--;
                    }
                }
            }
        }
        return res;
    }
}