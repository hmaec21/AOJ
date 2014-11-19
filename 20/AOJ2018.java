import java.util.Scanner;

public class AOJ2018 {
    public static void main(String[] args) {
        final int MIN_BET = 100; // 投票券1枚の値段
        final int MAX_P = 100; // 控除率の最大値
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] x = new int[n+1];
            int sum = 0; // 掛け金の合計
            for (int i = 1; i <= n; i++) {
                x[i] = sc.nextInt();
                sum += x[i];
            }
            sum *= MIN_BET;
            
            int pay = sum * (MAX_P - p) / MAX_P; // 当選者に払う金額の合計
            int ans = x[m] == 0 ? 0 : pay / x[m];
            System.out.println(ans);
        }
    }
}
