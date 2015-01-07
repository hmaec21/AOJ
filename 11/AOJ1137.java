// AOJ 1137 "Numeral System" (ICPC国内予選 2005 Problem C)
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class AOJ1137 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int ans = parseInt(s1) + parseInt(s2);
            System.out.println(toMCXI(ans));
        }
    }
    
    public static int parseInt(String s) {
        int n = 0;
        int tmp = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('2' <= c && c <= '9') {
                tmp = c - '0';
            } else {
                if (c == 'm') {
                    n += tmp * 1000;
                } else if (c == 'c') {
                    n += tmp * 100;
                } else if (c == 'x') {
                    n += tmp * 10;
                } else if (c == 'i') {
                    n += tmp;
                }
                tmp = 1;
            } 
        }
        return n;
    }
    
    public static String toMCXI(int n) {
        StringBuffer s = new StringBuffer();
        char[] c = {'i', 'x', 'c', 'm'};
        
        for (int i = 0; i < c.length; i++) {
            int tmp = n % 10;
            if (tmp > 0) {
                s.insert(0, c[i]);
                if (tmp > 1) {
                    s.insert(0, tmp);
                }
            }
            n /= 10;
        }
        return s.toString();
    }
}
