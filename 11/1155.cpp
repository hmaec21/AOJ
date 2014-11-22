// 参考サイト: http://mayah.jp/icpc/domestic2008/
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

//入力
string s;

int eval(const string& s, int& pos) {
    // 定数の場合
    if (s[pos] == '0' || s[pos] == '1' || s[pos] == '2') {
        int v = s[pos] - '0';
        pos++;
        return v;
    }
    
    // マイナス符号の場合
    if (s[pos] == '-') {
        pos++;
        int v = eval(s, pos);
        return 2 - v;
    }
    
    if (s[pos] == '(') {
        int v;
        pos++;
        int tmp1 = eval(s, pos);
        if (s[pos] == '+') {
            pos++;
            int tmp2 = eval(s, pos);
            v = max(tmp1, tmp2);
        } else if (s[pos] == '*') {
            pos++;
            int tmp2 = eval(s, pos);
            v = min(tmp1, tmp2);
        }
        pos++;
        return v;
    }
}

void solve() {
    int ans = 0;
    
    for (int p = 0; p <= 2; p++) {
        for (int q = 0; q <= 2; q++) {
            for (int r = 0; r <= 2; r++) {
                string tmp = s;
                for (int i = 0; i < (int)tmp.length(); i++) {
                    // P, Q, Rを定数0, 1, 2に置換する
                    if (tmp[i] == 'P') {
                        tmp[i] = p + '0';
                    } else if (s[i] == 'Q') {
                        tmp[i] = q + '0';
                    } else if (s[i] == 'R') {
                        tmp[i] = r + '0';
                    }
                }
                int pos = 0;
                //cout << tmp << endl;
                int result = eval(tmp, pos);
                if (result == 2) {
                    ans++;
                }
            }
        }
    }
    cout << ans << endl;
    
    return;
}

int main() {
    while (true) {
        getline(cin, s);
        if (s[0] == '.') {
            break;
        }
        solve();
    }
    
    return 0;
}
