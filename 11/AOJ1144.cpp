#include <iostream>
#include <cstring>
#include <cstdio>

using namespace std;

const int MAX_H = 20;
const int MAX_W = 20;
const int LIMITS = 10;

// 入力
int w, h;
int field[MAX_H+2][MAX_W+2];

int sx, sy;
int gx, gy;
int posx, posy;
int count;

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

int dfs(int c) {
    if (c > LIMITS) {
        return -1;
    }
}

void solve() {
    posx = sx;
    posy = sy;
    count = 0;
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
        solve();
    }
    
    return 0;
}
