// AOJ 1148 "ログイン/ログアウト記録の解析" (ICPC国内予選 2007 Problem B)
#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAX_M = 10000;

int N, M;
int r, q;
int use[MAX_M][1261];

int main() {
    while (true) {
        cin >> N >> M;
        if (N == 0) {
            break;
        }
        //cout << "check1" << endl;
        
        int usePc[M+1]; // 使用しているPCの数
        int useLastStart[M+1]; // 最後に使用し始めた時間
        //int useTime[M+1]; // 使用時間
        memset(use, 0, sizeof(use));
        memset(usePc, 0, sizeof(usePc));
        memset(useLastStart, 0, sizeof(useLastStart));
        //memset(useTime, 0, sizeof(useTime));
        
        
        cin >> r;
        for (int i = 0; i < r; i++) {
            int t, n, m, s;
            cin >> t >> n >> m >> s;
            if (s == 1) {
                // ログイン
                if (usePc[m] == 0) {
                    useLastStart[m] = t;
                }
                usePc[m]++;
            } else {
                // ログアウト
                usePc[m]--;
                if (usePc[m] == 0) {
                    for (int j = t - 1; j >= useLastStart[m]; j--) {
                        use[m][j] = 1;
                    }
                }
            }
        }
        //cout << "check2" << endl;
        cin >> q;
        for (int i = 0; i < q; i++) {
            int ts, te, m;
            int ans = 0;
            cin >> ts >> te >> m;
            
            for (int j = ts; j < te; j++) {
                if (use[m][j] == 1) {
                    ans++;
                }
            }
            cout << ans << endl;
        }
    }
    
    return 0;
}
