class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        TreeMap<Integer,Integer> map =new TreeMap<>();
        for(int k:arr) {
            if(map.containsKey(k)) {
                map.put(k, map.get(k)+1);
            } else {
                map.put(k, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
           @Override
           public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
               return o2.getValue().compareTo(o1.getValue());
           }
        });
        System.out.println(list);
        int t=0;
        int res=0;
        for (Map.Entry<Integer, Integer> mapping : list){
            if(t>=len/2) break;
            res++;
            t=t+mapping.getValue();
        }   
        return res;
    }
}