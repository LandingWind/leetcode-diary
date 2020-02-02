import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] words = s.split(" ");
        int wordsLen = words.length;
        int[] lens = new int[wordsLen];
        int maxLen = 0;
        for(int i=0;i<wordsLen;i++) {
            lens[i] = words[i].length();
            maxLen = Math.max(maxLen, lens[i]);
        }
        ArrayList<String> res = new ArrayList<>();
        for(int i=0;i<maxLen;i++) {
            StringBuffer buf = new StringBuffer();
            int last=0;
            for(int j=0;j<wordsLen;j++) {
                if(i<lens[j]) {
                    buf.append(words[j].charAt(i));
                    last=j;
                }else {
                    buf.append(" ");
                }
            }
            String tt = buf.toString();
            // eliminate the end space
            tt = tt.substring(0,last+1);
            res.add(tt);
        }

        System.out.println(res);
    }
}
