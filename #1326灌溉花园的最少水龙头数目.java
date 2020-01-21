// good solution
class Solution {
    public int minTaps(int n, int[] ranges) {
        int len = n+1;
        int land[] = new int[n];
        for(int i=0;i<len;i++) {
            int left = Math.max(0,i-ranges[i]);
            int right = Math.min(i+ranges[i],n);
            for(int j=left;j<right;j++) {
                land[j] = Math.max(land[j], right);
            }
        }
        // count
        int count = 0;
        int pos=0;
        while(pos<n){
            if(land[pos]==0) return -1;
            pos = land[pos];
            count++;
        }
        return count;
    }
}

// bad solution : TLE 8/35
class Solution {
    int min;
    int n;
    int ranges[];
    public void dfs(int step, HashSet<Integer> nos) {
        if(judge(nos)) {
            // success
            if(min>n+1-step) {
                min = n+1-step;
            }
            // search further step
            step = step + 1;
            for(int i=0;i<n+1;i++) {
                if(!nos.contains(i)) {
                    nos.add(i);
                    dfs(step, nos);
                    nos.remove(i);
                }
            }
        } else {
            return;
        }
    }
    public boolean judge(HashSet<Integer> nos) {
        int map[] = new int[n];
        for(int i=0;i<n+1;i++) {
            if(nos.contains(i)) continue;
            int item = ranges[i];
            if(item == 0) continue;
            for(int j=i-item;j<=i+item-1;j++) {
                if(j<0 || j>=n) continue;
                map[j] = 1;
            }
        }
        for(int i=0;i<n;i++) {
            if(map[i]==0) {
                return false;
            }
        }
        return true;
    }
    public int minTaps(int n, int[] ranges) {
        this.min = n+1;
        this.n = n;
        this.ranges = ranges;
        HashSet<Integer> nos = new HashSet<>();
        if(!judge(nos)) {
            return -1;
        }
        dfs(0, nos);

        return min;
    }
}

// update solution: TLE 13/35
class Solution {
    int min;
    int n;
    int k;
    int ranges[];
    HashSet<Integer> must = new HashSet<>();
    public void dfs(int step, HashSet<Integer> nos) {
        if(judge(nos)) {
            // success
            if(min>k-step) {
                min = k-step;
            }
            // search further step
            step = step + 1;
            for(int i=0;i<n+1;i++) {
                if(!nos.contains(i)) {
                    nos.add(i);
                    dfs(step, nos);
                    nos.remove(i);
                }
            }
        } else {
            return;
        }
    }
    public boolean judge(HashSet<Integer> nos) {
        int map[] = new int[n];
        for(int i=0;i<n+1;i++) {
            if(nos.contains(i)) continue;
            int item = ranges[i];
            if(item == 0) continue;
            for(int j=i-item;j<=i+item-1;j++) {
                if(j<0 || j>=n) continue;
                map[j] = 1;
            }
        }
        for(int i=0;i<n;i++) {
            if(map[i]==0) {
                return false;
            }
        }
        return true;
    }
    public int minTaps(int n, int[] ranges) {
        this.min = n+1;
        this.k = n+1;
        this.n = n;
        this.ranges = ranges;
        HashSet<Integer> nos = new HashSet<>();
        if(!judge(nos)) {
            return -1;
        }
        // update must exist info
        for(int i=0;i<n+1;i++) {
            nos.add(i);
            if(!judge(nos)) must.add(i);
            nos.remove(i);
        }
        // add must no info
        nos.clear();
        for(int i=0;i<n+1;i++) {
            int item = ranges[i];
            if(item==0) {
                nos.add(i);
                min--;k--;
                continue;
            }
            int left = i-item;
            int right = i+item;
            if(left<0) left=0;
            if(right>n) right=n;
            for(int j=0;j<n+1;j++) {
                if(i==j) continue;
                if(nos.contains(j)) continue;
                int item2 = ranges[j];
                int left2 = j-item2;
                int right2 = j+item2;
                if(left2<0) left2=0;
                if(right2>n) right2=n;
                if(left>=left2 && right<=right2) {
                    nos.add(i);
                    min--;k--;
                    break;
                }
            }
        }
        // System.out.println(nos);
        // System.out.println(must);
        // do dfs
        dfs(0, nos);

        return min;
    }
}
