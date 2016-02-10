// AOJ 1124 "When Can We Meet?" (ICPC国内予選 2003 Problem A)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAXDATE = 100;
        
        while (true) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int[] date = new int[MAXDATE + 1];
            for (int i = 0; i < n; i++) {
                int m = sc.nextInt();
                for (int j = 0; j < m; j++) {
                    int tmp = sc.nextInt();
                    date[tmp]++;
                }
            }
            
            int ans = 0;
            int max = 0;
            for (int i = 1; i < date.length; i++) {
                if (date[i] >= q && date[i] > max) {
                    ans = i;
                    max = date[i];
                }
            }
            System.out.println(ans);
        }
    }
}
