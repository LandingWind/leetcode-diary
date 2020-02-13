// 回溯

import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        System.out.println("s: " + s);
        System.out.println("p: " + p);
        Regex regex = new Regex();
        System.out.println("res: " + regex.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty(); // empty condition
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2))) || (firstMatch && isMatch(s.substring(1), p));
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
