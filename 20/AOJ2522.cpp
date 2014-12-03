#include <iostream>
#include <string>
#include <cctype>

using namespace std;

const int MIN_LENGTH = 6;

bool isValid(string s) {
    bool num, lower, upper;
    num = lower = upper = false;
    if (s.length() < MIN_LENGTH) {
        return false;
    }
    
    for (int i = 0; i < (int)s.length(); i++) {
        if (isdigit(s.at(i))) {
            num = true;
        } else if (islower(s.at(i))) {
            lower = true;
        } else if (isupper(s.at(i))) {
            upper = true;
        }
    }
    if (num && lower && upper) {
        return true;
    } else {
        return false;
    }
}

int main() {
    string s;
    cin >> s;
    
    if (isValid(s)) {
        cout << "VALID" << endl;
    } else {
        cout << "INVALID" << endl;
    }
    
    return 0;
}
