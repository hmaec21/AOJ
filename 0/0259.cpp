#include <iostream>
#include <string>
#include <algorithm>
#include <sstream>

using namespace std;

// http://d.hatena.ne.jp/pogin/20121001/1349069143
inline int toInt(string s) {
    int v;
    istringstream sin(s);
    sin >> v;
    return v;
}

template<class T> inline string toString(T x) {
    ostringstream sout;
    sout << x;
    return sout.str();
}

int main() {
    while (true) {
        string s;
        cin >> s;
        if (s == "0000") {
            break;
        }
        if (toInt(s) % 1111 == 0) {
            cout << "NA" << endl;
            continue;
        }
        
        int ans = 0;
        while (s != "6174") {
            ans++;
            sort(s.begin(), s.end());
            string min = s;
            string max;
            max = min;
            reverse(max.begin(), max.end());
            //cout << "max: " << max << " min: " << min << endl;
            int next = toInt(max) - toInt(min);
            //cout << "next: " << next << endl;
            string next_string = toString<int>(next);
            int next_length = next_string.length();
            if (next_length <= 3) {
                for (int i = next_length; i < 4; i++) {
                    next_string.append("0");
                }
            }
            s = next_string;
        }
        cout << ans << endl;
    }
    
    return 0;
}
