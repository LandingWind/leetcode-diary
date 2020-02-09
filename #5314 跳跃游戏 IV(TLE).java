// 超时的dfs 做了一定的剪枝和记忆化

import java.util.ArrayList;
import java.util.HashMap;

class test {
    int mintap = 1000000;
    int array[] = null;
    int visit[] = null;
    int length;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        int arr[] = {6,1,9};
        test a = new test();
        System.out.println(a.minJumps(arr));
    }

    void dfs(int index, int tap) {
        if (index == 0) {
            if (mintap > tap) {
                mintap = tap;
            }
            return;
        }
        if (tap >= mintap) return;
        for(Integer i:map.get(array[index])) {
            if(i==index) continue;
            if(this.visit[i] == 0 || tap < this.visit[i]) {
                this.visit[i] = tap;
                dfs(i, tap + 1);
            }
        }
        if (index - 1 >= 0) {
            if(this.visit[index-1] == 0 || tap < this.visit[index-1]) {
                this.visit[index-1] = tap;
                dfs(index - 1, tap + 1);
            }
        }
        if (index + 1 < this.length) {
            if(this.visit[index+1] == 0 || tap < this.visit[index+1]) {
                this.visit[index+1] = tap;
                dfs(index + 1, tap + 1);
            }
        }
    }

    public int minJumps(int[] arr) {
        this.array = arr;
        this.length = arr.length;
        this.visit = new int[this.length];
        // init map
        HashMap<Integer, ArrayList<Integer>> map = this.map;
        for (int i=0;i<this.length;i++) {
            if(map.containsKey(arr[i])) {
                ArrayList<Integer> ls = map.get(arr[i]);
                ls.add(i);
                map.put(arr[i], ls);
            } else {
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(i);
                map.put(arr[i], ls);
            }
        }
        dfs(arr.length - 1, 0);
        return mintap;
    }
}