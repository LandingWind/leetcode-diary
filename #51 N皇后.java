import java.util.ArrayList;
import java.util.List;

public class EightQueen {
    int n;
    List<List<String>> mAll = new ArrayList<>();
    void dfs(int step, List<Integer> m) {
        if(step == n) {
//            System.out.println(m);
            ArrayList<String> mm = new ArrayList<>();
            for (int i=0;i<n;i++) {
                StringBuilder strb = new StringBuilder();
                int t = m.get(i);
                for (int j=0;j<n;j++) {
                    if(j==t) strb.append('Q');
                    else strb.append('.');
                }
                mm.add(strb.toString());
            }
            mAll.add(mm);
            return;
        }
        int row[] = new int[n];
        for(int i=0;i<m.size();i++) {
            int t = m.get(i);
            row[t] = 1;
            int diffrow = step-i;
            int left = t-diffrow;
            int right = t+diffrow;
            if(left>=0) row[left]=1;
            if(right<=n-1) row[right]=1;
        }
        for(int i=0;i<n;i++) {
            if(row[i]==0) {
                m.add(i);
                dfs(step+1, m);
                m.remove(m.size()-1);
            }
        }
        return;
    }
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        dfs(0, new ArrayList<Integer>());
        return this.mAll;
    }

    public static void main(String[] args) {
        EightQueen a = new EightQueen();
        System.out.println(a.solveNQueens(4));
    }
}
