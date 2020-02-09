// bfs + hashmap -- version

import java.util.*;

class test {
    public static void main(String[] args) {
        int arr[] = {6,1,9};
        test a = new test();
        System.out.println(a.minJumps(arr));
    }

    public int minJumps(int[] arr) {
        int len = arr.length;
        int visit[] = new int[len];
        Arrays.fill(visit, -1); // not visited at first
        // init hashMap
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i=0;i<len;i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new HashSet<Integer>());
            }
            map.get(arr[i]).add(i);
        }
        // bfs
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visit[0] = 0;
        while(!q.isEmpty()) {
            int index = q.poll();
            // put in
            if(index-1 >= 0 && visit[index-1]==-1) {
                visit[index-1] = visit[index] + 1;
                q.offer(index-1);
            }
            if(index+1 < len && visit[index+1]==-1) {
                visit[index+1] = visit[index] + 1;
                q.offer(index+1);
            }
            for(int i:map.get(arr[index])) {
                if(visit[i]==-1) {
                    visit[i] = visit[index] + 1;
                    q.offer(i);
                }
            }
            map.get(arr[index]).clear();
            if(visit[len-1] != -1) break;
        }
        return visit[len-1];
    }
}