class Solution {
    public int maxEvents(int[][] events) {
        int len = events.length;
        int count=0;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]) return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        Set<Integer> set = new HashSet<>();
        for(int[]e:events) {
            for(int i=e[0];i<=e[1];i++) if(set.add(i)) break;
        }
        return set.size();
    }   
}