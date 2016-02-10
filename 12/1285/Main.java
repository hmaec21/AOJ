// AOJ 1285 "Grey Area" (ICPCアジア地区予選 2008 会津大会 Problem A)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int w = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] v = new int[n];
            int maxv = 0;
            for (int i = 0; i < n; i++) {
                v[i] = sc.nextInt();
                maxv = Math.max(maxv, v[i]);
            }
            
            int[] g = new int[maxv/w+1];
            int maxh = 0;
            for (int i = 0; i < v.length; i++) {
                g[v[i]/w]++;
                maxh = Math.max(maxh, g[v[i]/w]);
            }
            
            double ink = 0.01; // 線や文字を書く分
            for (int i = 0; i < g.length; i++) {
                ink += ((double)(g.length - i - 1) / (g.length - 1))
                       * ((double)g[i] / maxh);
            }
            System.out.println(ink);
        }
    }
}
