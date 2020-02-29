class Solution {
    List<List<Integer>> res=new ArrayList<>();
    HashSet<Integer> visit = new HashSet<Integer>();
    int nums[] = null;
    int len = 0;
    public void dfs(int step, ArrayList<Integer> al) {
        if(step==this.len) {
            // success
            this.res.add(al);
            return;
        }
        for(int num:nums) {
            if(!visit.contains(num)) {
                visit.add(num);
                ArrayList<Integer> al2 = (ArrayList<Integer>) al.clone();
                al2.add(num);
                dfs(step+1, al2);
                visit.remove(num);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.len = nums.length;
        dfs(0, new ArrayList<Integer>());
        return res;
    }
}