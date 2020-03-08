class Solution {
    public int numTimesAllBlue(int[] light) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int len = light.length;
        for(int i=0;i<len;i++) {
            hm.put(light[i]-1, i);
        }
        int count=0;
        int pos=-1;
        HashSet<Integer> onhs=new HashSet<>();
        HashSet<Integer> bluehs=new HashSet<>();
        for(int i=0;i<len;i++) {
            int curpos=hm.get(i);
            onhs.add(curpos);
            if(pos+1==curpos) {
                // count++;
                pos++;
                while(pos<len && onhs.contains(pos)) {
                    onhs.remove(pos);
                    bluehs.add(pos);
                    pos++;
                }
                pos--;
            }
            if(onhs.isEmpty()) count++;
        }
        
        
        
        return count;
    }
}