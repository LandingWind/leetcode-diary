package unionfind;

import java.util.*;

public class SwapString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SwapString a = new SwapString();

        String s = in.nextLine();
        int n = in.nextInt();
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(in.nextInt());
            pair.add(in.nextInt());
            pairs.add(pair);
        }
        String res = a.smallestStringWithSwaps(s, pairs);
        System.out.println("res: " + res);
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        DSU dsu = new DSU(len);
        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            dsu.join(x, y);
        }
//         System.out.println(dsu);
        // force union
        int temp;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < len; i++) {
            temp = dsu.find(i);
            hs.add(temp);
        }
        StringBuilder strb = new StringBuilder(s);
        for (Integer item : hs) {
            System.out.println("sort item: " + item);
            // collect item
            List<Character> ls = new ArrayList<>();
            List<Integer> pos = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (dsu.parent[i] == item) {
                    ls.add(s.charAt(i));
                    pos.add(i);
                }
            }
            // sort
            Collections.sort(ls, Comparator.comparingInt(Character::charValue));
            System.out.println(ls);
            for (int i=0;i<ls.size();i++) {
                strb.setCharAt(pos.get(i), ls.get(i));
            }
        }

        return strb.toString();
    }
}
