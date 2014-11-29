#include <iostream>
#include <cstring>

using namespace std;

const int MAX_N = 8;

int h, w, c;
int field[6][MAX_N][MAX_N];
int old;
/*
int field1[MAX_N][MAX_N];
int field2[MAX_N][MAX_N];
int field3[MAX_N][MAX_N];
int field4[MAX_N][MAX_N];
int field5[MAX_N][MAX_N];
*/

void debug(int m) {
    for (int i = 0; i < MAX_N; i++) {
        for (int j = 0; j < MAX_N; j++) {
            cout << field[m][i][j] << " ";
        }
        cout << endl;
    }
    cout << "----------" << endl;
}

void dfs(int x, int y, int n, int m) {
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    
    field[m][y][x] = n;
    
    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (0 <= nx && nx < w && 0 <= ny && ny < h && field[m][ny][nx] == old) {
            dfs(nx, ny, n, m);
        }
    }
}

// ¶ã‚Æ‚Â‚È‚ª‚Á‚Ä‚¢‚éƒ}ƒX‚ð‚·‚×‚ÄFn‚É•Ï‚¦‚é, m‚Í‰ñ”(1`5)
void change(int n, int m) {
    memcpy(field[m], field[m-1], sizeof(field[m-1]));
    old = field[m][0][0];
    dfs(0, 0, n, m);
}

int check() {
    int ans = 0;
    old = field[5][0][0];
    dfs(0, 0, -1, 5);
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (field[5][i][j] == -1) {
                ans++;
            }
        }
    }
    
    return ans;
}

void solve() {
    int ans = 0;
    for (int i = 1; i <= 6; i++) {
        if (field[0][0][0] == i) {
            continue;
        }
        change(i, 1);
        for (int j = 1; j <= 6; j++) {
            if (field[1][0][0] == j) {
                continue;
            }
            change(j, 2);
            for (int k = 1; k <= 6; k++) {
                if (field[2][0][0] == k) {
                    continue;
                }
                change(k, 3);
                for (int l = 1; l <= 6; l++) {
                    if (field[3][0][0] == l || c == l) {
                        continue;
                    }
                    change(l, 4);
                    change(c, 5);
                    //debug(5);
                    ans = max(ans, check());
                }
            }
        }
    }
    cout << ans << endl;
}

int main() {
    while (true) {
        cin >> h >> w >> c;
        
        if (h == 0) {
            break;
        }
        memset(field, 0, sizeof(field));
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cin >> field[0][i][j];
            }
        }
        //cout << "‰Šúó‘Ô" << endl;
        //debug(0);
        solve();
    }
    
    return 0;
}
