class Solution {
    public int minSteps(String s, String t) {
        int len = s.length();
        HashMap<Character, Integer> hs = new HashMap<>();
        for(int i=0;i<len;i++) {
            Character ch = s.charAt(i);
            if(!hs.containsKey(ch)) hs.put(ch, 0);
            int dd = hs.get(ch);
            hs.put(ch, dd+1);
        }
        for(int i=0;i<len;i++) {
            Character ch = t.charAt(i);
            if(hs.containsKey(ch)) {
                int dd = hs.get(ch);
                hs.put(ch, dd-1);
            }
        }
        int count=0;
        for (Integer value : hs.values()) {
            if(value > 0)
                count = count + value;
        }
        return count;
    }
}