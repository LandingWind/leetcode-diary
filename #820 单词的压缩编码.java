class Solution {
    int total=0;
    public void dfs(Node cur, int now) {
        if(cur.flag==false) {
            total+=now+1;
            return;
        }
        for(int i=0;i<26;i++) {
            if(cur.children[i]!=null) {
                dfs(cur.children[i], now+1);
            }
        }
    }
    public int minimumLengthEncoding(String[] words) {
        int len=words.length;
        //trie
        Node root=new Node();
        for(String word:words) {
            Node pos=root;
            String rev=new StringBuilder(word).reverse().toString();
            for(int i=0;i<rev.length();i++) {
                int val=rev.charAt(i)-'a';
                if(pos.children[val]==null) {
                    pos.children[val] = new Node();
                    pos.flag = true;
                    pos=pos.children[val];
                }else{
                    pos=pos.children[val];
                }
            }
        }
        dfs(root, 0);
        return this.total;
    }
}
class Node {
    Node children[]=new Node[26];
    boolean flag=false;
    Node() {
        for(Node child:children) {
            child=null;
        }
    }
}