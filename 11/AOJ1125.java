// 国内予選 2003 B Get Many Persimmon Trees
import java.util.Scanner;

public class AOJ1125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[][] field = new int[h][w];
            
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y-1][x-1] = 1;
            }
            
            int s = sc.nextInt();
            int t = sc.nextInt();
            
            int ans = 0;
            for (int i = 0; i <= h - t; i++) {
                for (int j = 0; j <= w - s; j++) {
                    int tmp = 0;
                    for (int k = 0; k < t; k++) {
                        for (int l = 0; l < s; l++) {
                            tmp += field[i+k][j+l];
                        }
                    }
                    ans = Math.max(ans, tmp);
                }
            }
            System.out.println(ans);
        }
    }
}
