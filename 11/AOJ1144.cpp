// AOJ 1144 "カーリング 2.0" (ICPC国内予選 2006 Problem D)
#include <iostream>
#include <cstring>
#include <cstdio>
#include <algorithm>

using namespace std;

const int MAX_H = 20;
const int MAX_W = 20;
const int LIMITS = 10;

// 入力
int w, h;
int field[MAX_H+2][MAX_W+2];

int sx, sy;
int gx, gy;
int turn;

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

void debug() {
    printf("s(%d, %d), g(%d, %d)\n", sx, sy, gx, gy);
    for (int i = 0; i <= h + 1; i++) {
        for (int j = 0; j <= w + 1; j++) {
            printf("%2d ", field[i][j]);
        }
        cout << endl;
    }
    cout << endl;
    
    return;
}

void dfs(int c, int x, int y) {
    if (c > LIMITS) {
        return;
    }
    //printf("%d\n", c);
    for (int i = 0; i < 4; i++) {
        if (field[y+dy[i]][x+dx[i]] == 1) {
            continue;
        }
        int tmpx = x;
        int tmpy = y;
        while (field[tmpy+dy[i]][tmpx+dx[i]] != 1 && field[tmpy][tmpx] != -1) {
            tmpx += dx[i];
            tmpy += dy[i];
            if (tmpx == gx && tmpy == gy) {
                turn = min(turn, c);
                return;
            }
            if (field[tmpy][tmpx] == -1) {
                break;
            }
        }
        if (field[tmpy][tmpx] != -1) {
            field[tmpy+dy[i]][tmpx+dx[i]] = 0;
            dfs(c + 1, tmpx, tmpy);
            field[tmpy+dy[i]][tmpx+dx[i]] = 1;
        }
    }
}

void solve() {
    dfs(1, sx, sy);
    if (turn != 99) {
        printf("%d\n", turn);
    } else {
        printf("-1\n");
    }
}

int main() {
    while (true) {
        cin >> w >> h;
        if (w == 0) {
            break;
        }
        for (int i = 0; i < MAX_H + 2; i++) {
            memset(field[i], -1, sizeof(field[i]));
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                cin >> field[i][j];
                if (field[i][j] == 2) {
                    sx = j;
                    sy = i;
                } else if (field[i][j] == 3) {
                    gx = j;
                    gy = i;
                }
            }
        }
        //debug();
        turn = 99;
        solve();
    }
    
    return 0;
}
