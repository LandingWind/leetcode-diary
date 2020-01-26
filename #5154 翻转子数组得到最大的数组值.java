// optimal solution O(n)
// main idea: 绝对值拆解开来分成四种情况,然后归类未知数的函数
class Solution {
    public int cal(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        return sum;
    }
    public int maxValueAfterReverse(int[] nums) {
        int res = 0;
        int len = nums.length;
        int origin = cal(nums);
        // System.out.println("origin: "+origin);
        // special condition: one end is the edge
        for (int i = 1; i < len - 1; i++) {
            res = Math.max(res, origin + Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
        }
        for (int i = 1; i < len - 1; i++) {
            res = Math.max(res, origin + Math.abs(nums[i - 1] - nums[len - 1]) - Math.abs(nums[i] - nums[i - 1]));
        }
        // other conditon
        int[] farr = { -1, 1 };
        for (int f1 : farr)
            for (int f2 : farr) {
                int mx = -(1 << 31);
                for (int i = 1; i < len; i++) {
                    res = Math.max(res,
                            origin + mx + f1 * nums[i - 1] + f2 * nums[i] - Math.abs(nums[i - 1] - nums[i]));
                    mx = Math.max(mx, -f1 * nums[i - 1] - f2 * nums[i] - Math.abs(nums[i - 1] - nums[i]));
                }
            }
        return res;
    }
}

// classic solution O(n^2) pass points: 14/16
class Solution {
    public int cal(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        return sum;
    }

    public int maxValueAfterReverse(int[] nums) {
        int res = 0;
        int len = nums.length;

        int maxt = 0;
        // int maxi = 0;
        // int maxj = len-1;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {

                int oldv = 0;
                int newv = 0;
                if (i > 0) {
                    oldv += Math.abs(nums[i - 1] - nums[i]);
                    newv += Math.abs(nums[i - 1] - nums[j]);
                }
                if (j < len - 1) {
                    oldv += Math.abs(nums[j] - nums[j + 1]);
                    newv += Math.abs(nums[i] - nums[j + 1]);
                }
                int t = newv - oldv;
                if (t > maxt) {
                    // maxi = i;
                    // maxj = j;
                    maxt = t;
                }
                // System.out.println(i+" "+j+" "+t);
            }
        }
        // int nums2[] = new int[len];
        // for(int k=0;k<len;k++) nums2[k] = nums[k];
        // for(int k=maxi;k<=maxj;k++) nums2[k] = nums[maxj-k+maxi];

        // for(int k=0;k<len;k++) System.out.print(nums2[k]+" ");
        res = cal(nums) + maxt;

        return res;

    }
}