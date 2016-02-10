// AOJ 1179 "ミレニアム" (ICPC国内予選 2012 Problem A)
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int m = sc.nextInt();
            int d = sc.nextInt();
            
            int ans = length(y, m, d);
            System.out.println(ans);
        }
    }
    
    public static int length(int y, int m, int d) {
        int length = 0;
        
        length += lengthOfMonth(y, m) - d + 1;
        
        for (int i = m + 1; i <= 10; i++) {
            length += lengthOfMonth(y, i);
        }
        
        for (int i = y + 1; i < 1000; i++) {
            length += lengthOfYear(i);
        }
        
        return length;
    }
    
    public static int lengthOfMonth(int y, int m) {
        if (y % 3 == 0 || m % 2 == 1) {
            return 20;
        } else {
            return 19;
        }
    }
    
    public static int lengthOfYear(int y) {
        int length = 0;
            for (int i = 1; i <= 10; i++) {
                length += lengthOfMonth(y, i);
            }
        
        return length;
    }
}
