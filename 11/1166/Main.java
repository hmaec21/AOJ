// AOJ 1166 "迷図と命ず" (ICPC国内予選 2010 Problem B)
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] field;
    static String[] wall;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int w, h;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0) {
                break;
            }
            field = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    field[i][j] = 0;
                }
            }
            field[0][0] = 1;
            
            wall = new String[2*h-1];
            sc.nextLine();
            for (int i = 0; i < 2 * h - 1; i++) {
                wall[i] = sc.nextLine();
            }
            //debug();
            solve();
        }
    }
    
    public static void debug() {
        for (int i = 0; i < wall.length; i++) {
            System.out.println(wall[i]);
        }
    }
    
    public static void solve() {
        Queue<Field> que = new LinkedList<Field>();
        que.offer(new Field(0, 0));
        while (que.peek() != null) {
            Field tmp = que.poll();
            if (tmp.x == w - 1 && tmp.y == h - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                //System.out.println(tmp.x + " " + tmp.y + " " + nx + " " + ny + ": ");
                if (0 <= nx && nx < w && 0 <= ny && ny < h && !isWall(tmp.x, tmp.y, nx, ny) && field[ny][nx] == 0) {
                    que.offer(new Field(nx, ny));
                    field[ny][nx] = field[tmp.y][tmp.x] + 1;
                }
            }
        }
        System.out.println(field[h-1][w-1]);
    }
    
    // 隣接する2マスに壁があればtrue，そうでなければfalseを返すメソッド
    public static boolean isWall(int x1, int y1, int x2, int y2) {
        if (wall[y1+y2].charAt(x1 + x2) == '1') {
            return true;
        } else {
            return false;
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
