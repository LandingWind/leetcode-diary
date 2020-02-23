class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int count=0;
        int pos=0;
        int visit[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(pos);
        visit[pos]=1;
        while(!st.empty()) {
            pos=st.pop();
            count++;
            if(leftChild[pos]!=-1) {
                if(visit[leftChild[pos]]==1) return false;
                st.push(leftChild[pos]);
                visit[leftChild[pos]]=1;
            }
            if(rightChild[pos]!=-1) {
                if(visit[rightChild[pos]]==1) return false;
                st.push(rightChild[pos]);
                visit[rightChild[pos]]=1;
            }
        }
        if(count<n) return false;
        return true;
    }
}