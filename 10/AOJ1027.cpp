// AOJ 1027 UAPC 2009 Problem I "A Piece of Cake"
#include <cstdio>

using namespace std;

int main() {
    while (true) {
        int K;
        scanf("%d", &K);
        if (K == 0) {
            break;
        }
        
        int ans = 0;
        for (int i = 0; i < K * (K - 1) / 2; i++) {
            int tmp;
            scanf("%d", &tmp);
            ans += tmp;
        }
        ans /= K - 1;
        printf("%d\n", ans);
    }
    
    return 0;
}
