// AOJ 0000 "QQ" (パソコン甲子園 2003 本選 問題 001)
#include <iostream>

using namespace std;

int main() {
    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            cout << i << "x" << j << "=" << i * j << endl;
        }
    }
    
    return 0;
}
