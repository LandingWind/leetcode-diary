class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int m=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            ArrayList<Integer> arr2=new ArrayList<>();
            for(int j=0;j<index[i];j++) arr2.add(arr.get(j));
            arr2.add(nums[i]);
            for(int j=index[i];j<arr.size();j++) arr2.add(arr.get(j));
            arr=arr2;
        }
        int res[]=new int[arr.size()];
        for(int i=0;i<arr.size();i++) res[i]=arr.get(i);
        return res;
    }
}