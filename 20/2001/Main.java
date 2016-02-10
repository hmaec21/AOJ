// AOJ 2001 "Amida, the City of Miracle" (ICPC模擬国内予選 2006 Problem B)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_H = 1000;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            boolean[][] hline = new boolean[MAX_H+1][n+1];
            for (int i = 0; i < m; i++) {
                int h = sc.nextInt();
                int p = sc.nextInt();
                int q = sc.nextInt();
                hline[h][p] = true;
            }
            
            int xpos = a;
            for (int h = MAX_H; h >= 1; h--) {
                if (hline[h][xpos-1]) {
                    // 左側に横棒がある場合
                    xpos--;
                } else if (hline[h][xpos]) {
                    // 右側に横棒がある場合
                    xpos++;
                }
            }
            System.out.println(xpos);
        }
    }
}
