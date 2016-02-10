// AOJ 2401 "恒等式" (ICPC模擬国内予選 2012 Problem C)
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

const char ch[] = {'T', 'F'};

// 入力
string s;

int eval(const string &s, int &pos) {
    if (s[pos] == 'F') {
        pos++;
        return 0;
    }
    if (s[pos] == 'T') {
        pos++;
        return 1;
    }
    if (s[pos] == '-') {
        pos++;
        int v = eval(s, pos);
        return 1 - v;
    }
    if (s[pos] == '(') {
        pos++;
        int v1 = eval(s, pos);
        if (s[pos] == '*') {
            pos++;
            int v2 = eval(s, pos);
            pos++;
            int v = min(v1, v2);
            return v;
        }
        if (s[pos] == '+') {
            pos++;
            int v2 = eval(s, pos);
            pos++;
            int v = max(v1, v2);
            return v;
        }
        if (s[pos] == '-') {
            // "->"の場合
            pos += 2; // 演算子が2文字なので，その分だけずらす
            int v2 = eval(s, pos);
            pos++;
            int v = (v1 == 1 && v2 == 0) ? 0 : 1;
            return v;
        }
    }
}

void solve() {
    for (int a = 0; a < 2; a++) {
        for (int b = 0; b < 2; b++) {
            for (int c = 0; c < 2; c++) {
                for (int d = 0; d < 2; d++) {
                    for (int e = 0; e < 2; e++) {
                        for (int f = 0; f < 2; f++) {
                            for (int g = 0; g < 2; g++) {
                                for (int h = 0; h < 2; h++) {
                                    for (int i = 0; i < 2; i++) {
                                        for (int j = 0; j < 2; j++) {
                                            for (int k = 0; k < 2; k++) {
                                                string tmp = s;
                                                for (int l = 0; l < (int)tmp.length(); l++) {
                                                    if (tmp[l] == 'a') {
                                                        tmp[l] = ch[a];
                                                    } else if (tmp[l] == 'b') {
                                                        tmp[l] = ch[b];
                                                    } else if (tmp[l] == 'c') {
                                                        tmp[l] = ch[c];
                                                    } else if (tmp[l] == 'd') {
                                                        tmp[l] = ch[d];
                                                    } else if (tmp[l] == 'e') {
                                                        tmp[l] = ch[e];
                                                    } else if (tmp[l] == 'f') {
                                                        tmp[l] = ch[f];
                                                    } else if (tmp[l] == 'g') {
                                                        tmp[l] = ch[g];
                                                    } else if (tmp[l] == 'h') {
                                                        tmp[l] = ch[h];
                                                    } else if (tmp[l] == 'i') {
                                                        tmp[l] = ch[i];
                                                    } else if (tmp[l] == 'j') {
                                                        tmp[l] = ch[j];
                                                    } else if (tmp[l] == 'k') {
                                                        tmp[l] = ch[k];
                                                    }
                                                }
                                                
                                                int pos = 0;
                                                int f1 = eval(tmp, pos);
                                                pos++;
                                                int f2 = eval(tmp, pos);
                                                if (f1 != f2) {
                                                    cout << "NO" << endl;
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    cout << "YES" << endl;
}

int main() {
    while (true) {
        getline(cin, s);
        if (s[0] == '#') {
            break;
        }
        solve();
    }
}
