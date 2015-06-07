// AOJ 1135 "Ohgas' Fortune" (ICPC国内予選 2005 Problem A)
import java.util.Scanner;

public class AOJ1135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int max = 0;
            int init = sc.nextInt();
            int year = sc.nextInt();
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int method = sc.nextInt();
                double rate = sc.nextDouble();
                int cost = sc.nextInt();
                if (method == 0) {
                    max = Math.max(max, simpleInterest(init, year, rate, cost));
                } else if (method == 1) {
                    max = Math.max(max, compoundInterest(init, year, rate, cost));
                } else {
                    System.err.println("想定していない運用方法が入力されました。");
                    System.exit(1);
                }
            }
            System.out.println(max);
        }
    }
    
    public static int simpleInterest(int init, int year, double rate, int cost) {
        int sumInterest = 0;
        int money = init;
        
        for (int i = 1; i <= year; i++) {
            sumInterest += money * rate;
            money -= cost;
        }
        return money + sumInterest;
    }
    
    public static int compoundInterest(int init, int year, double rate, int cost) {
        int money = init;
        for (int i = 1; i <= year; i++) {
            money += money * rate - cost;
        }
        return money;
    }
}
