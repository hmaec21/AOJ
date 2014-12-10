// AOJ 1192 "税率変更" (ICPC国内予選 2014 Problem A)
import java.util.Scanner;

public class AOJ1192 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = sc.nextInt();
            if (x == 0) {
                break;
            }
            
            /*
             * s1: 商品1の税抜き価格
             * s2: 商品2の税抜き価格
             * x1: 商品1の変更前の税込価格
             * x2: 商品2の変更前の税込価格
             * y1: 商品1の変更後の税込価格
             * y2: 商品2の変更後の税込価格
             */
            int ans = 0;
            for (int s1 = 1; s1 < s; s1++) {
                for (int s2 = 1; s2 < s; s2++) {
                    int x1 = s1 * (100 + x) / 100;
                    int x2 = s2 * (100 + x) / 100;
                    
                    if (x1 + x2 == s) {
                        int y1 = s1 * (100 + y) / 100;
                        int y2 = s2 * (100 + y) / 100;
                        ans = Math.max(ans, y1 + y2);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
