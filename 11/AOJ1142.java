// AOJ 1142 "列車の編成パートII" (ICPC国内予選 2006 Problem B)
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class AOJ1142 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Set<String> ss = new HashSet<String>();
            String s = sc.next();
            
            for (int j = 1; j < s.length(); j++) {
                String s1 = s.substring(0, j);
                String s2 = s.substring(j);
                
                StringBuffer tmp1 = new StringBuffer(s1);
                StringBuffer tmp2 = new StringBuffer(s2);
                String s1r = tmp1.reverse().toString();
                String s2r = tmp2.reverse().toString();
                
                ss.add(s1 + s2);
                ss.add(s1 + s2r);
                ss.add(s1r + s2);
                ss.add(s1r + s2r);
                ss.add(s2 + s1);
                ss.add(s2 + s1r);
                ss.add(s2r + s1);
                ss.add(s2r + s1r);
            }
            System.out.println(ss.size());
        }
    }
}
