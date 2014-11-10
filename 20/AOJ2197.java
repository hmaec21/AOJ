import java.util.Scanner;

public class AOJ2197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int ans = 0;
            for (int i = 1; i < n; i++) {
                int sum = 0;
                for (int j = i; sum < n; j++) {
                    sum += j;
                }
                if (sum == n) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
