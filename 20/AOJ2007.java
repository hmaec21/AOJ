// AOJ 2007 "Make Purse Light" (ICPC模擬国内予選 2005 Problem B)
import java.util.Scanner;

public class AOJ2007 {
    static final int[] price = {10, 50, 100, 500};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0; // テストケースの個数
        
        while (true) {
            int pay = sc.nextInt();
            if (pay == 0) {
                break;
            }
            
            count++;
            int[] coin = new int[4]; // coin[0-3]: 10, 50, 100, 500円硬貨の枚数
            int[] result = new int[4];
            for (int i = 0; i < coin.length; i++) {
                coin[i] = sc.nextInt();
            }
            
            int total = coin[0] * 10 + coin[1] * 50 + coin[2] * 100 + coin[3] * 500;
            change(total - pay, result);
            if (count > 1) {
                System.out.println();
            }
            for (int i = 0; i < coin.length; i++) {
                int n = coin[i] - result[i];
                if (n > 0) {
                    System.out.println(price[i] + " " + n);
                }
            }
        }
    }
    
    public static void change(int total, int[] result) {
        for (int i = price.length - 1; i >= 0; i--) {
            int n = total / price[i];
            result[i] += n;
            total -= n * price[i];
        }
    }
}
