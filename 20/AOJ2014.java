// AOJ 2014 "土地囲い" (ICPC模擬国内予選 2007 Problem C)
import java.util.Scanner;

public class AOJ2014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0) {
                break;
            }
            
            StringBuffer[] field = new StringBuffer[h];
            for (int i = 0; i < field.length; i++) {
                field[i] = new StringBuffer(sc.next());
            }
            
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length(); j++) {
                    if (field[i].charAt(j) == 'W') {
                        dfs(field, j, i, 'w');
                    } else if (field[i].charAt(j) == 'B') {
                        dfs(field, j, i, 'b');
                    }
                }
            }
            
            int bArea = 0;
            int wArea = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length(); j++) {
                    if (field[i].charAt(j) == 'b') {
                        bArea++;
                    } else if (field[i].charAt(j) == 'w') {
                        wArea++;
                    }
                }
            }
            System.out.println(bArea + " " + wArea);
        }
    }
    
    public static void dfs(StringBuffer[] field, int x, int y, char c) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (0 <= ny && ny < field.length && 0 <= nx && nx < field[ny].length()) {
                if (field[ny].charAt(nx) == '.') {
                    field[ny].setCharAt(nx, c);
                    dfs(field, nx, ny, c);
                } else if ((field[ny].charAt(nx) == 'b' && c == 'w')
                || (field[ny].charAt(nx) == 'w' && c == 'b')) {
                    field[ny].setCharAt(nx, 'g');
                    dfs(field, nx, ny, c);
                }
            }
        }
    }
}
