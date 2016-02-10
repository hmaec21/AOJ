// AOJ 2300 "Calender Colors" (JAG夏合宿 2011 day 3 Problem A)
import java.util.Scanner;

public class Main {
    static double[] l;
    static double[] a;
    static double[] b;
    static double ans;
    static int n;
    static int m;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        l = new double[n];
        a = new double[n];
        b = new double[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextDouble();
            a[i] = sc.nextDouble();
            b[i] = sc.nextDouble();
        }
        
        ans = 0.0;
        dfs(0, 0, new double[m], new double[m], new double[m]);
        System.out.println(ans);
    }
    
    public static void dfs(int pos, int c, double[] tmpl, double[] tmpa, double[] tmpb) {
        if (c == m) {
            double tmp = 0.0;
            for (int i = 0; i < tmpl.length; i++) {
                for (int j = i + 1; j < tmpl.length; j++) {
                    tmp += Math.pow(tmpl[i] - tmpl[j], 2) + Math.pow(tmpa[i] - tmpa[j], 2)
                           + Math.pow(tmpb[i] - tmpb[j], 2);
                    ans = Math.max(ans, tmp);
                }
            }
        } else if (m - c > n - pos) {
            return;
        } else {
            dfs(pos + 1, c, tmpl, tmpa, tmpb);
            tmpl[c] += l[pos];
            tmpa[c] += a[pos];
            tmpb[c] += b[pos];
            dfs(pos + 1, c + 1, tmpl, tmpa, tmpb);
            tmpl[c] = tmpa[c] = tmpb[c] = 0.0;
        }
    }
}
