class Solution {
    public List<String> letterCombinations(String digits) {
        String refs[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<String>();
        int len = digits.length();
        if(len==0) return res;
        String ref = refs[digits.charAt(0)-'0'];
        for(int j=0;j<ref.length();j++) res.add(""+ref.charAt(j));
        for(int i=1;i<len;i++) {
            ref = refs[digits.charAt(i)-'0'];
            int t = res.size();
            for(int j=0;j<ref.length();j++) {
                char ch = ref.charAt(j);
                for(int k=0;k<t;k++) res.add(res.get(k)+ch);
            }
            // System.out.println(res);
            for(int k=0;k<t;k++) res.remove(0);
        }
        return res;
    }
}