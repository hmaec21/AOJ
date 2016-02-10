// AOJ 2253 "ブレイブ・フォース・ストーリー" (ICPC模擬国内予選 2011 Problem B)
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int t = sc.nextInt();
            int n = sc.nextInt();
            if (t == 0) {
                break;
            }
            
            int[][] field = new int[121][121];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y+60][x+60] = -1;
            }
            int sx = sc.nextInt() + 60;
            int sy = sc.nextInt() + 60;
            int[] dx = {0, 1, 1, 0, -1, -1};
            int[] dy = {1, 1, 0, -1, -1, 0};
            Queue<Field> que = new LinkedList<Field>();
            que.offer(new Field(sx, sy));
            while (que.peek() != null) {
                Field tmp = que.poll();
                int tmpx = tmp.x;
                int tmpy = tmp.y;
                if (field[tmpy][tmpx] == t) {
                    continue;
                }
                for (int i = 0; i < dx.length; i++) {
                    int nx = tmpx + dx[i];
                    int ny = tmpy + dy[i];
                    if (0 <= ny && ny < field.length && 0 <= nx && nx < field[ny].length
                        && field[ny][nx] == 0 && !(nx == sx && ny == sy)) {
                        que.offer(new Field(nx, ny));
                        field[ny][nx] = field[tmpy][tmpx] + 1;
                    }
                }
            }
            
            int count = 0;
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] > 0 && field[i][j] <= t) {
                        count++;
                    }
                }
            }
            System.out.println(count + 1);
        }
    }
}

class Field {
    int x;
    int y;
    Field(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
