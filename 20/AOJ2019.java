// AOJ 2019 "お姫様の嫁入り" (ICPC模擬国内予選 2008 Problem B)
import java.util.Scanner;

public class AOJ2019 {
    public static void main(String[] args) {
        final int MAX_P = 10;
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int num = 0; // 刺客に襲われる回数の期待値の最大値
            int[] e = new int[MAX_P+1]; // e[i]: 期待値iの総距離長
            for (int i = 0; i < n; i++) {
                int d = sc.nextInt();
                int p = sc.nextInt();
                e[p] += d;
                num += d * p;
            }
            
            for (int i = MAX_P; i >= 1; i--) {
                int pay = Math.min(e[i], m);
                num -= i * pay;
                m -= pay;
                if (m <= 0) {
                    break;
                }
            }
            System.out.println(num);
        }
    }
}
