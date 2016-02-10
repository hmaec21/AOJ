// AOJ 1147 "ICPC 得点集計ソフトウェア" (ICPC国内予選 2007 Problem A)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                max = Math.max(max, s);
                min = Math.min(min, s);
                sum += s;
            }
            int avg = (sum - min - max) / (n - 2);
            System.out.println(avg);
        }
    }
}
