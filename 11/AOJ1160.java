// AOJ 1160 "島はいくつある？" (ICPC国内予選 2009 Problem B)
import java.util.Scanner;

public class AOJ1160 {
    static int[][] field;
    static int ans;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0) {
                break;
            }
            
            field = new int[h][w];
            ans = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    field[i][j] = sc.nextInt();
                }
            }
            solve();
            System.out.println(ans);
        }
    }
    
    public static void solve() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    ans++;
                    dfs(j, i);
                }
            }
        }
    }
    
    public static void dfs(int x, int y) {
        field[y][x] = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + j >= 0 && x + j < field[y].length &&
                    y + i >= 0 && y + i < field.length &&
                    field[y+i][x+j] == 1) {
                    dfs(x + j, y + i);
                }
            }
        }
    }
}
