class Solution {
    public List<Integer> grayCode(int n) {
        int t=1<<n;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<t;i++) {
            res.add(i^(i/2));
        }
        // System.out.println(res);
        return res;
    }
}