// AOJ 1131 "Unit Fraction Partition" (ICPC国内予選 2004 Problem C)
// Note: 実行時に-Xss2mをつけないとStackOverflowErrorで落ちる
import java.util.Scanner;

public class Main {
    static int p;
    static int q;
    static int a;
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            p = sc.nextInt();
            q = sc.nextInt();
            a = sc.nextInt();
            n = sc.nextInt();
            if (p == 0) {
                break;
            }
            
            int ans = dfs(0, 1, n, 1);
            System.out.println(ans);
        }
    }
    
    public static int dfs(int c, int m, int num, int mother) {
        //System.out.println(c + "/" + m + " " + num + " " + mother);
        if (isEqual(p, q, c, m)) {
            //System.out.println(c + "/" + m + " " + num + " " + mother + " !");
            return 1;
        }
        if (mother * m > a || num <= 0 || m > a || isBigger(p, q, c, m)) {
            return 0;
        }
        
        int ans = 0;
        // 1/motherを使う場合
        ans += dfs(c * mother + m, m * mother, num - 1, mother);
        
        // 1/motherを使わない場合
        ans += dfs(c, m, num, mother + 1);
        
        
        return ans;
    }
    
    public static boolean isEqual(int c1, int m1, int c2, int m2) {
        return c1 * m2 == c2 * m1;
    }
    
    public static boolean isBigger(int c1, int m1, int c2, int m2) {
        return c1 * m2 < c2 * m1;
    }
}
