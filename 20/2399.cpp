#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    while (true) {
        int N;
        cin >> N;
        if (N == 0) {
            break;
        }
        
        vector<int> member[N];
        for (int i = 0; i < N; i++) {
            int M;
            cin >> M;
            for (int j = 0; j < M; j++) {
                int p;
                cin >> p;
                member[i].push_back(p);
            }
            sort(member[i].begin(), member[i].end());
        }
        vector<int> leak;
        int K;
        cin >> K;
        for (int i = 0; i < K; i++) {
            int l;
            cin >> l;
            leak.push_back(l);
        }
        sort(leak.begin(), leak.end());
        
        int ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (int)leak.size(); j++) {
                if (!(binary_search(member[i].begin(), member[i].end(), leak[j]))) {
                    goto nextmember;
                }
            }
            if (ans != -1) {
                ans = -1;
                goto end;
            } else {
                ans = i + 1;
            }
        nextmember:
            int a;
        }
    end:
        cout << ans << endl;
    }
    
    return 0;
}
