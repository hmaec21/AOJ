// AOJ 2582 "踏み台昇降" (ICPC模擬国内予選 2014 Problem A)
import java.util.Scanner;

public class AOJ2582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int ans = 0;
            boolean isUp = false;
            boolean isDown = false;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                if (s.charAt(1) == 'u') {
                    if (isUp) {
                        ans++;
                        isUp = false;
                    } else if (isDown) {
                        isDown = false;
                    } else {
                        isUp = true;
                    }
                } else {
                    if (isUp) {
                        isUp = false;
                    } else if (isDown) {
                        ans++;
                        isDown = false;
                    } else {
                        isDown = true;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
