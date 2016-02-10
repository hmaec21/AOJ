// AOJ 1187 "ICPCの順位付け" (ICPC国内予選 2013 Problem B)
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int M, T, P, R;
            M = sc.nextInt();
            T = sc.nextInt();
            P = sc.nextInt();
            R = sc.nextInt();
            if (M == 0) {
                break;
            }
            
            ArrayList<Team> teams = new ArrayList<Team>();
            for (int i = 0; i < T; i++) {
                teams.add(new Team(i + 1, P));
            }
            //System.out.println(teams.size());
            for (int i = 0; i < R; i++) {
                int m, t, p, j;
                m = sc.nextInt();
                t = sc.nextInt();
                p = sc.nextInt();
                j = sc.nextInt();
                Team tmp = teams.get(t - 1);
                if (j == 0) {
                    // 正解
                    tmp.solved++;
                    tmp.time += m + 20 * tmp.wa[p];
                } else {
                    // 不正解
                    tmp.wa[p]++;
                }
            }
            
            Collections.sort(teams, new TeamComp());
            for (int i = 0; i < T; i++) {
                Team tmp1 = teams.get(i);
                if (i > 0) {
                    Team tmp2 = teams.get(i - 1);
                    if (tmp1.equals(tmp2)) {
                        System.out.print("=");
                    } else {
                        System.out.print(",");
                    }
                }
                System.out.print(tmp1.num);
            }
            System.out.println();
        }
    }
}

class Team {
    int num; // チーム番号
    int solved; // 正解数
    int time; // ペナルティタイム
    int[] wa; // 各問題の不正解回数
    
    public Team(int n, int p) {
        this.num = n;
        wa = new int[p+1];
    }
    
    public boolean equals(Team t) {
        return this.solved == t.solved && this.time == t.time;
    }
}

class TeamComp implements Comparator<Team> {
    public int compare(Team a, Team b) {
        if (a.solved != b.solved) {
            return -(a.solved - b.solved);
        } else if (a.time != b.time) {
            return a.time - b.time;
        } else {
            return -(a.num - b.num);
        }
    }
}
