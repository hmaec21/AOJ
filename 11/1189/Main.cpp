// AOJ 1189 "素数洞穴" (ICPC国内予選 2013 Problem D)
#include <iostream>
#include <algorithm>

using namespace std;

/*
100 099 098 097 096 095 094 093 092 091
065 064 063 062 061 060 059 058 057 090
066 037 036 035 034 033 032 031 056 089
067 038 017 016 015 014 013 030 055 088
068 039 018 005 004 003 012 029 054 087
069 040 019 006 001 002 011 028 053 086
070 041 020 007 008 009 010 027 052 085
071 042 021 022 023 024 025 026 051 084
072 043 044 045 046 047 048 049 050 083
073 074 075 076 077 078 079 080 081 082
*/

const int MAX_N = 1000;
const int MAX_N2 = MAX_N * MAX_N;

int caves[MAX_N][MAX_N]; // ここに置かないとSegmentation falutになる
pair<short, int> dp[MAX_N][MAX_N]; // 素数洞穴の数、最後に通った素数洞穴の番号
// ↑は頑張れば2行分だけで済みそう
bool is_prime[MAX_N2 + 1];

// 入力
int n, m;

void sieve() {
    for (int i = 0; i <= MAX_N2; i++) {
        is_prime[i] = true;
    }
    is_prime[0] = is_prime[1] = false;
    for (int i = 2; i <= MAX_N2; i++) {
        if (is_prime[i]) {
            for (int j = 2 * i; j <= MAX_N2; j += i) {
                is_prime[j] = false;
            }
        }
    }
    
    return;
}

// 初期化 素数表と洞穴を作成
void init() {
    sieve();
    int dx[4] = {1, 0, -1, 0};
    int dy[4] = {0, 1, 0, -1};
    
    int num = MAX_N2;
    int array = 0;
    int x = 0;
    int y = 0;
    for (int i = 0; i < MAX_N; i++) {
        for (int j = 0; j < MAX_N; j++) {
            caves[i][j] = 0;
        }
    }
    
    for (int i = num; i > 0; i--) {
        caves[y][x] = i;
        int tx = x + dx[array];
        int ty = y + dy[array];
        if (tx < 0 || tx >= MAX_N || ty < 0 || ty >= MAX_N || caves[ty][tx] != 0) {
            array = (array + 1) % 4;
        }
        x += dx[array];
        y += dy[array];
    }
    /*
    for (int i = 0; i < MAX_N; i++) {
        for (int j = 0; j < MAX_N; j++) {
            if (j > 0) {
                cout << " ";
            }
            printf("%7d", caves[i][j]);
        }
        cout << endl;
    }
    */
    return;
}

void search(int sx, int sy) {
    /*
    下から順に最良の経路を探す
    ある洞穴の最良経路はそこから行ける3つの内、最も良いもの
    */
    for (int i = MAX_N - 1; i >= 0; i--) {
        for (int j = MAX_N - 1; j >= 0; j--) {
            if (caves[i][j] > m) {
                // 存在しない穴はスキップ
                dp[i][j].first = 0;
                dp[i][j].second = 0;
                continue;
            }
            
            if (i == MAX_N - 1) {
                // 一番下の場合
                if (is_prime[caves[i][j]]) {
                    dp[i][j].first = 1;
                    dp[i][j].second = caves[i][j];
                } else {
                    dp[i][j].first = 0;
                    dp[i][j].second = 0;
                }
            } else {
                pair<short, int> tmp[3];
                // 降りることが出来る穴を調べる
                for (int k = -1; k <= 1; k++) {
                    if (j + k < 0 || j + k >= MAX_N) {
                        tmp[k+1].first = 0;
                        tmp[k+1].second = 0;
                    } else {
                        tmp[k+1].first = dp[i+1][j+k].first;
                        tmp[k+1].second = dp[i+1][j+k].second;
                    }
                }
                // 素数洞穴の個数が最も多いものを選ぶ(個数が同じなら最後に通る素数洞穴が最も大きいもの)
                sort(tmp, tmp + 3, greater<pair<short, int> >());
                dp[i][j].first = tmp[0].first;
                dp[i][j].second = tmp[0].second;
                
                if (is_prime[caves[i][j]]) {
                    dp[i][j].first++;
                    if (dp[i][j].second == 0) {
                        // ここが最後に通る素数洞穴の場合
                        dp[i][j].second = caves[i][j];
                    }
                }
            }
        }
    }
    return;
}

void solve(int sx, int sy) {
    search(sx, sy);
    cout << dp[sy][sx].first << " " << dp[sy][sx].second << endl;
}

int main() {
    init();
    while (true) {
        cin >> m >> n;
        if (m == 0) {
            break;
        }
        int sx, sy;
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                dp[i][j].first = 0;
                dp[i][j].second = 0;
                if (caves[i][j] == n) {
                    sx = j;
                    sy = i;
                }
            }
        }
        solve(sx, sy);
    }
    
    return 0;
}
