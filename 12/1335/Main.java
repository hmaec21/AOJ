// AOJ 1335 "Equal Sum Sets" (ICPCアジア地区予選 2013 会津大会 Problem A)
import java.util.Scanner;

public class Main {
    static int n;
    static int k;
    static int s;
    static int count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            n = sc.nextInt();
            k = sc.nextInt();
            s = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            count = 0;
            dfs(0, 0, 1);
            System.out.println(count);
        }
    }
    
    public static void dfs(int sum, int c, int i) {
        if (c == k) {
            if (sum == s) {
                count++;
            }
            return;
        }
        if (i > n || sum > s) {
            return;
        }
        
        dfs(sum, c, i + 1);
        dfs(sum + i, c + 1, i + 1);
    }
}
